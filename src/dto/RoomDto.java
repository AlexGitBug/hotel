package dto;

import entity.Enum.FloorEnum;
import entity.Enum.NumberRoomEnum;
import entity.RoomStatusEnum;
import lombok.Builder;


@Builder
public class RoomDto {

    int id;
    NumberRoomEnum number;
    FloorEnum floor;
    int dayPrice;
    RoomStatusEnum status;
}
