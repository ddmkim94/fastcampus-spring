package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller{
    @Override
    public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/user/list.jsp";
    }
}
