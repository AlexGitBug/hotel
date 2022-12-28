package service;

import dao.OrderDao;

import dao.UserInfoDao;
import dto.OrderDto;
import lombok.NoArgsConstructor;
import mapper.CreateOrderMapper;
import java.util.List;

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

    public static OrderService getInstance() {
        return INSTANCE;
    }

    public List<OrderDto> findAll() {
        return orderDao.findAll().stream()
                .map(order -> OrderDto.builder()
//                        .id(String.valueOf(order.getId()))
                        .userInfoId(order.getUserInfoId().getId().toString())
                        .roomId(order.getRoomId().getId().toString())
                        .beginTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().toString())
                        .message(order.getMessage())
                        .build())
                .collect(toList());

    }

    public List<OrderDto> findById(int id) {
        return orderDao.findById(id).stream()
                .map(order -> OrderDto.builder()
//                        .id(String.valueOf(order.getId()))
                        .userInfoId(order.getUserInfoId().toString())
                        .roomId(order.getRoomId().toString())
                        .beginTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().toString())
                        .message(order.getMessage())
                        .build())
                .collect(toList());

    }
}

