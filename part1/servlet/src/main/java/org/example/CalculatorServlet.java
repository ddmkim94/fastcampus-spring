package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

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
        /**
         * - 서블릿 생성 후 초기화 작업 수행 (최초 실행시 1번만 실행)
         * - 다른 자원을 초기화 하는 경우에도 init()에 작성하면 된다.
         */
        log.info("init");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        /**
         * - 클라이언트 요청이 들어올 때마다 실행되는 메서드
         */
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
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
