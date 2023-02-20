package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.RequestMethod;
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
        log.info("path: {}", request.getRequestURI());
        log.info("request method type: [{}]", RequestMethod.valueOf(request.getMethod()));
        Controller handler = requestHandlerMapping.findController(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));

        try {
            String viewName = handler.handlerRequest(request, response);

            if (viewName.startsWith("redirect:/")) {
                String path = viewName.substring(viewName.indexOf("/"));
                response.sendRedirect(path);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher(viewName);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            log .error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
