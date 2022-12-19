package service;

import dao.UserInfoDao;
import dto.UserInfoDto;
import entity.UserInfo;
import exception.ValidationException;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserInfoService {
    private static final UserInfoService INSTANCE = new UserInfoService();
    private final UserInfoDao userInfoDao = UserInfoDao.getInstance();


    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(UserInfoDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userInfoDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserInfoService getInstance() {
        return INSTANCE;
    }
}
//        public List<UserInfoDto> findAll() {
//            return userInfoDao.findAll().stream()
//                    .map(userInfo -> UserInfoDto.builder()
//                            .id(userInfo.getId())
//                            .description("""
//                                %s - %s - %s - %s - %s - %s
//                            """.formatted(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getEmail(),
//                                    userInfo.getPassword(), userInfo.getTelephone(), userInfo.getBirthday()))
//                            .build())
//                    .collect(toList());
//
//        }
//
//        public List<UserInfoDto> findById(int id) {
//            return userInfoDao.findById(id).stream()
//                    .map(userInfo -> UserInfoDto.builder()
//                            .id(userInfo.getId())
//                            .description("""
//                            %s - %s - %s - %s - %s - %s
//                            """.formatted(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getEmail(),
//                                    userInfo.getPassword(), userInfo.getTelephone(), userInfo.getBirthday()))
//                            .build())
//                    .collect(toList());
//
//        }
//
//        public  void save(String firstName, String lastName, String email, String password, String telephone, String birthday) {
//            var userInfo = UserInfo.builder()
//                    .firstName(firstName)
//                    .lastName(lastName)
//                    .email(email)
//                    .password(password)
//                    .telephone(telephone)
//                    .birthday(birthday)
//                    .build();
//            userInfoDao.save(userInfo);
//
//        }
//
//        public boolean delete(int id) {
//            return userInfoDao.delete(id);
//
//        }
//
//        public void update(int id, String firstName, String lastName, String email, String password, String telephone) {
//            var userInfoHotel = userInfoDao.findById(id);
//            userInfoHotel.ifPresent(userInfo -> {
//                userInfo.setFirstName(firstName);
//                userInfo.setLastName(lastName);
//                userInfo.setEmail(email);
//                userInfo.setPassword(password);
//                userInfo.setTelephone(telephone);
//                userInfoDao.update(userInfo);
//            });
//        }
//
//        public static UserInfoService getInstance() {
//            return INSTANCE;
//        }
//    }
