package entity;

import entity.Enum.FloorEnum;
import entity.Enum.NumberRoomEnum;
import lombok.Builder;

import lombok.Data;

@Data
@Builder
public class Room {

    int id;
    NumberRoomEnum number;
    QuantityBed quantityBed;
    CategoryRoom categoryRoom;
    FloorEnum floor;
    int dayPrice;
    RoomStatusEnum status;

}
