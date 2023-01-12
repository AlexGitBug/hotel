package servlet;

import dto.OrderDto;
import dto.UserInfoDto;
import entity.Enum.RoleEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.*;
import util.JspHelper;

import java.io.IOException;

import static util.UrlPath.CHECK_ORDER_EXISTING;

@WebServlet(CHECK_ORDER_EXISTING)
public class CheckOrderExistingServlet extends HttpServlet {

    private final InfoOrderService infoOrderService = InfoOrderService.getInstance();
    private final UserInfoService userInfoService = UserInfoService.getInstance();
    private final RoomService roomService = RoomService.getInstance();
    private final OrderService orderService = OrderService.getInstance();
    private final CategoryRoomService categoryRoomService = CategoryRoomService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        infoOrderService.findOrderDto(orderId).ifPresentOrElse(orderDto -> {
            forwardOrderDto(req, resp, orderDto);
        }, () -> {
            sendError(resp);
        });
    }


    private void sendError(HttpServletResponse resp) {
        resp.setStatus(400);
        try {
            resp.sendError(400, "Booking does not exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void forwardOrderDto(HttpServletRequest req, HttpServletResponse resp, OrderDto orderDto) {
        UserInfoDto user = (UserInfoDto) req.getSession().getAttribute("user");
        req.setAttribute("order", orderDto);
        req.setAttribute("userInfo", userInfoService.findUserInfoById(user.getId()));
        req.setAttribute("roomFromOrder", roomService.findRoomById(orderDto.getRoom()));
        req.setAttribute("categoryRoom", categoryRoomService.findCategoryRoomById(orderDto.getRoom()));
        try {
            if (user.getRole().getRank().equals(RoleEnum.ADMIN.name())) {
                req.getRequestDispatcher(JspHelper.getPath("checkorder"))
                        .forward(req, resp);
            } else {
                req.getRequestDispatcher(JspHelper.getPath("orderbyid"))
                        .forward(req, resp);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
