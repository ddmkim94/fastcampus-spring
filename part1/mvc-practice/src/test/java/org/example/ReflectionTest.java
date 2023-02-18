package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * @Controller 애노테이션이 설정되어 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @DisplayName("@Controller 애노테이션이 설정된 클래스 찾기!")
    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("org.example"); // org.example 하위 패키지에 있는 모든 클래스를 대상으로 조회
        // Controller 애노테이션을 가진 클래스를 조회한다!
        Set<Class<?>> beans = reflections.getTypesAnnotatedWith(Controller.class);

        log.debug("beans: [{}]", beans);
    }
}
