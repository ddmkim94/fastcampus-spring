package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // class, interface, enum 선언에 붙일 수 있다!
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지 기간은 런타임 기간까지!
public @interface Controller {

}
