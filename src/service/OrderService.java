package service;

import dao.OrderDao;

import dao.UserInfoDao;
import dto.OrderDto;
import lombok.NoArgsConstructor;
import mapper.CreateOrderMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OrderService {

    private static final OrderService INSTANCE = new OrderService();
    private final OrderDao orderDao = OrderDao.getInstance();
    private final UserInfoDao userInfoDao = UserInfoDao.getInstance();


    //        private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final CreateOrderMapper createOrderMapper = CreateOrderMapper.getInstance();

    public Integer create(OrderDto orderDto) {
//            var validationResult = createUserValidator.isValid(userDto);
//            if (!validationResult.isValid()) {
//                throw new ValidationException(validationResult.getErrors());
//            }
        var orderEntity = createOrderMapper.mapFrom(orderDto);
        orderDao.save(orderEntity);
        return orderEntity.getId();
    }

    public List<OrderDto> findOrdersByUserId(Integer userId) {
        var orderDtos = findAll();
        return orderDtos.stream()
                .filter(orderDto -> orderDto.getId().equals(userId))
                .collect(Collectors.toList());
    }

    public static OrderService getInstance() {
        return INSTANCE;
    }


    public List<OrderDto> findAll() {
        return orderDao.findAll().stream()
                .map(order -> OrderDto.builder()
                        .id(order.getId())
                        .userInfoId(order.getUserInfoId().getId().toString())
                        .roomId(order.getRoomId().getId().toString())
                        .beginTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().toString())
                        .message(order.getMessage())
                        .build())
                .collect(toList());
    }

    public Optional<OrderDto> findOrderById(Integer id) {
        return orderDao.findById(id)
                .map(order -> OrderDto.builder()
                        .id(order.getId())
                        .userInfoId(order.getId().toString())
                        .roomId(order.getRoomId().toString())
                        .beginTimeOfTheOrder(order.getBeginTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().name())
                        .message(order.getMessage())
                        .build());

    }
}


//    public boolean delete(int id) {
//        return orderDao.delete(id);
//
//    }
//
//    public static OrderService getInstance() {
//        return INSTANCE;
//    }