package org.example.annotation.di;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.annotation.controller.UserController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {

    private Reflections reflections;
    private BeanFactory beanFactory;

    /**
     * 각 테스트 전에 호출되는 메서드
     * 보통 필요한 값들을 초기화 할 때 사용한다.
      */
    @BeforeEach
    void setUp() {
        reflections = new Reflections("org.example");
        /**
         * 해당 애노테이션이 붙어있는 클래스들을 찾아서 반환
         * UserController, UserService
          */
        Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClazz);
    }

    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {

        Set<Class<?>> beans = new HashSet<>();
        for (Class<? extends Annotation> annotation : annotations) {
            beans.addAll(reflections.getTypesAnnotatedWith(annotation));
        }

        return beans;
    }

    @Test
    void diTest() {
        UserController userController = beanFactory.getBean(UserController.class);

        assertThat(userController).isNotNull();
        assertThat(userController.getUserService()).isNotNull();
    }

}