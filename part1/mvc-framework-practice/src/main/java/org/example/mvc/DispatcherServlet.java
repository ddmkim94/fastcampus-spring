package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private final RequestMappingHandlerMapping requestHandlerMapping = new RequestMappingHandlerMapping();

    // 서블릿을 생성할 때 RequestMappingHandlerMapping 생성 & 초기화
    @Override
    public void init() throws ServletException {
        requestHandlerMapping.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started!");
        Controller handler = requestHandlerMapping.findController(request.getRequestURI());

        try {
            String viewName = handler.handlerRequest(request, response);
            log.info("viewName: [{}]", viewName);

            RequestDispatcher rd = request.getRequestDispatcher(viewName);
            rd.forward(request, response);
        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
