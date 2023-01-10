package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;
import util.JspHelper;

import java.io.IOException;

import static util.UrlPath.ORDER_SERVLET_BY_ORDER_ID;

@WebServlet(ORDER_SERVLET_BY_ORDER_ID)
public class OrderServletById extends HttpServlet {

    private final OrderService orderService = OrderService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("orderlist", orderService.findById(id));
        req.getRequestDispatcher(JspHelper.getPath("orderbyid"))
                .forward(req, resp);

    }

}