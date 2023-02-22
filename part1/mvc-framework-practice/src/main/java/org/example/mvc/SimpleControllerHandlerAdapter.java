package org.example.mvc;

import org.example.mvc.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = ((Controller) handler).handlerRequest(request, response);
        return new ModelAndView(viewName);
    }
}
