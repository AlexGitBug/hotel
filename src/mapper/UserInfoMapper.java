package mapper;

import dto.CreateDto.CreateUserDto;
import entity.UserInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoMapper implements Mapper<UserInfo, CreateUserDto> {

    private static final UserInfoMapper INSTANCE = new UserInfoMapper();
    @Override
    public CreateUserDto mapFrom(UserInfo object) {
        return CreateUserDto.builder()
                .id(object.getId())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .telephone(object.getTelephone())
                .birthday(object.getBirthday().toString())
//                .image(object.getImage())
                .build();

    }

    public static UserInfoMapper getInstance() {
        return INSTANCE;
    }
}