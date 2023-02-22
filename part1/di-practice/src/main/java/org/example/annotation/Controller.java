package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Controller 어노테이션은 class, interface, enum에만 사용할 수 있다!
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
