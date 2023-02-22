package org.example.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {

    private final Class<?> clazz;
    private final Method targetMathod;

    public AnnotationHandler(Class<?> clazz, Method targetMathod) {
        this.clazz = clazz;
        this.targetMathod = targetMathod;
    }

    public String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object handle = declaredConstructor.newInstance();

        return (String) targetMathod.invoke(handle, request, response);
    }
}
