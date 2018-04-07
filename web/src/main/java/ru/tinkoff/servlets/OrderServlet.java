package ru.tinkoff.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tinkoff.entities.Order;
import ru.tinkoff.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index")
public class OrderServlet extends HttpServlet {
    @Autowired
    OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Order order = orderService.getLastOrderByAccountId(1L);
        out.print(order.toString());
        System.out.println("hello");
    }



    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-service.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        Order order = orderService.getLastOrderByAccountId(1L);
        System.out.println(order);
    }
}
