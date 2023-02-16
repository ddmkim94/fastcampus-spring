package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 서블릿 컨테이너!

/**
 * 서블릿 객체의 생명 주기 관리
 * 서블릿 객체를 싱글톤으로 관리한다.
 */
@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 서블릿 생성 후 초기화 할 때 실행
        log.info("init");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 클라이언트 요청이 들어올 때마다 실행
        log.info("service");

    }

    @Override
    public void destroy() {
        // 서블릿이 소멸될 때 실행
        log.info("destroy");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
