package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {

    private static final Logger log = LoggerFactory.getLogger(UserCreateController.class);

    @Override
    public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");

        log.info("userId: {}, name: {}", userId, name);

        UserRepository.save(new User(userId, name));
        return "redirect:/users";
    }
}
