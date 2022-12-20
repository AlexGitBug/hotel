package mapper;

import dao.RoleDao;
import dao.RoomDao;
import dao.UserInfoDao;
import dto.OrderDto;
import entity.Enum.ConditionEnum;
import entity.Order;
import entity.Role;
import lombok.NoArgsConstructor;
import util.LocalDateFormatter;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateOrderMapper implements Mapper<OrderDto, Order> {

    private static final CreateOrderMapper INSTANCE = new CreateOrderMapper();
    private final UserInfoDao userInfoDao = UserInfoDao.getInstance();
    private final RoomDao roomDao = RoomDao.getInstance();
    private final RoleDao roleDao = RoleDao.getInstance();

    @Override
    public Order mapFrom(OrderDto object) {
        String rank = null;
        Optional<Role> optionalRole = roleDao.findById(Integer.parseInt(object.getId()));
        if (optionalRole.isPresent()) {
            rank = optionalRole.get().getRank();
        }
        return Order.builder()
                .userInfoId(userInfoDao.findById(Integer.parseInt(object.getUserInfoId())).get())
                .roomId(roomDao.findById(Integer.parseInt(object.getRoomId())).get())
                .beginTimeOfTheOrder(LocalDateFormatter.format(object.getBeginTimeOfTheOrder()))
                .endTimeOfTheOrder(LocalDateFormatter.format(object.getEndTimeOfTheOrder()))
                .condition(ConditionEnum.valueOf(object.getCondition()))
                .message(object.getMessage())
                .build();
    }

    public static CreateOrderMapper getInstance() {
        return INSTANCE;
    }
}
return UserInfo.builder()
        .firstName(object.getFirstName())
        .lastName(object.getLastName())
        .email(object.getEmail())
        .password(object.getPassword())
        .role(Role.builder()
        .id(Integer.parseInt(object.getRoleId()))
        .rank(rank)
        .build())
        .telephone(object.getTelephone())
        .birthday(LocalDateFormatter.format(object.getBirthday()))
        .build();
        }
