package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Controller 애노테이션이 설정되어 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @DisplayName("@Controller 애노테이션이 설정된 클래스 찾기!")
    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        log.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;

        log.debug("클래스 이름 = {}", clazz.getName());
        log.debug("User all declared fields = [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        log.debug("User all declared constructors = [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        log.debug("User all declared methods = [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        Class<User> clazz1 = User.class;

        User user = new User("1", "eunbin");
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("org.example.model.User"); // 패키지명 포함해서 작성해야 한다.

        log.debug("clazz1 = {}", clazz1);
        log.debug("clazz2 = {}", clazz2);
        log.debug("clazz3 = {}", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz3 == clazz1).isTrue();

    }

    // 파라미터로 Annotation 타입의 클래스만 올 수 있다.
    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example"); // org.example 하위 패키지에 있는 모든 클래스를 대상으로 조회
        // Controller 애노테이션을 가진 클래스를 조회한다!
        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
