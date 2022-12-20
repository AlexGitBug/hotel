package service;

import dao.OrderDao;

import dao.UserInfoDao;
import dto.OrderDto;

import dto.UserInfoDto;
import entity.Enum.ConditionEnum;
import entity.Order;
import entity.Room;
import entity.UserInfo;
import exception.ValidationException;
import lombok.NoArgsConstructor;
import mapper.CreateOrderMapper;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                        .id(String.valueOf(order.getId()))
                        .userInfoId(String.valueOf(order.getUserInfoId()))
                        .roomId(String.valueOf(order.getRoomId()))
                        .beginTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().toString())
                        .message(order.getMessage())
//                        .description("""
//                                   %s - %s - %s - %s - %s - %s
//                                """.formatted(order.getUserInfoId().getId(), order.getRoomId().getId(), order.getBeginTimeOfTheOrder(), order.getEndTimeOfTheOrder(),
//                                order.getCondition(), order.getMessage()))
                        .build())
                .collect(toList());

    }

    public List<OrderDto> findById(int id) {
        return orderDao.findById(id).stream()
                .map(order -> OrderDto.builder()
                        .id(String.valueOf(order.getId()))
                        .userInfoId(String.valueOf(order.getUserInfoId().getId()))
                        .roomId(String.valueOf(order.getRoomId().getId()))
                        .beginTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .endTimeOfTheOrder(order.getEndTimeOfTheOrder().toString())
                        .condition(order.getCondition().toString())
                        .message(order.getMessage())
//                        .description("""
//                                   %s - %s - %s - %s - %s - %s
//                                """.formatted(order.getUserInfoId().getId(), order.getRoomId().getId(), order.getBeginTimeOfTheOrder(), order.getEndTimeOfTheOrder(),
//                                order.getCondition(), order.getMessage()))
                        .build())
                .collect(toList());

    }



//    public void update(int id, LocalDate beginTime, LocalDate endTime,
//                       ConditionEnum condition, String message) {
//        var orderHotel = orderDao.findById(id);
////        var user = UserInfo.builder()
////                .id(userId)
////                .build();
////        var room = Room.builder()
////                .id(roomId)
////                .build();
//        orderHotel.ifPresent(order -> {
////            order.setUserInfoId(user);
////            order.setRoomId(room);
//            order.setBeginTimeOfTheOrder(beginTime);
//            order.setEndTimeOfTheOrder(endTime);
//            order.setCondition(condition);
//            order.setMessage(message);
//            orderDao.update(order);
//
//        });
//    }

//    public void save(LocalDate beginTime, LocalDate endTime, ConditionEnum condition, String message) {

//        var user = UserInfo.builder()
//                .id(userId)
//                .build();
//        var room = Room.builder()
//                .id(roomId)
//                .build();
//        var order = Order.builder()
//                .userInfoId(user)
//                .roomId(room)
//                .beginTimeOfTheOrder(beginTime)
//                .endTimeOfTheOrder(endTime)
//                .condition(condition)
//                .message(message)
//                .build();
//        orderDao.save(order);
//
//    }
//    public boolean delete(int id) {
//        return orderDao.delete(id);
//
//    }
//
//    public static OrderService getInstance() {
//        return INSTANCE;
//    }
}
