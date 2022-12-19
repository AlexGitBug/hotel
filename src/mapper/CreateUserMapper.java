package mapper;

    import dao.RoleDao;
    import dto.UserInfoDto;
    import entity.Role;
    import entity.UserInfo;
    import lombok.NoArgsConstructor;
    import util.LocalDateFormatter;


    import java.util.Optional;

    import static lombok.AccessLevel.PRIVATE;

    @NoArgsConstructor(access = PRIVATE)
    public class CreateUserMapper implements Mapper<UserInfoDto, UserInfo> {

        private static final CreateUserMapper INSTANCE = new CreateUserMapper();
        private final RoleDao roleDao = RoleDao.getInstance();
        @Override
        public UserInfo mapFrom(UserInfoDto object) {
            String rank = null;
            Optional<Role> optionalRole = roleDao.findById(Integer.parseInt(object.getRoleId()));
            if (optionalRole.isPresent()) {
                rank = optionalRole.get().getRank();
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

        public static CreateUserMapper getInstance() {
            return INSTANCE;
        }
    }

