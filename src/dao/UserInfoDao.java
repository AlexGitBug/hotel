package dao;


import entity.CategoryRoom;
import entity.Role;
import entity.UserInfo;
import exception.DaoException;
import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInfoDao {
    private static final UserInfoDao INSTANCE = new UserInfoDao();


    private static final String FIND_ALL_SQL = """
            SELECT id, first_name, last_name, email, password ,telephone, birthday
            FROM user_info
            """;

    private static final String DELETE_SQL = """
            DELETE FROM user_info
            WHERE id  = ?
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = "INSERT INTO user_info(first_name, last_name, email, password, role_id, telephone, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_SQL = """
            UPDATE user_info
            SET first_name = ?,
                last_name = ?,
                email = ?,
                password = ?,
                telephone = ?
                birthday = ?
            WHERE id = ?
            """;
    private UserInfoDao() {
    }

    public List<UserInfo> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();

            List<UserInfo> userInfo = new ArrayList<>();
            while (resultSet.next()) {
                userInfo.add(buildUserInfo(resultSet));
            }
            return userInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<UserInfo> findById(int id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            UserInfo userInfo = null;
            if (resultSet.next()) {
                userInfo = buildUserInfo(resultSet);
            }
            return Optional.ofNullable(userInfo);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private UserInfo buildUserInfo(ResultSet resultSet) {
        try {
            var userRole = Role.builder()
                    .id(resultSet.getObject("id", Integer.class))
                    .rank(resultSet.getObject("rank", String.class))
                    .build();
            return UserInfo.builder()
                    .id(resultSet.getObject("id", Integer.class))
                    .firstName(resultSet.getObject("first_name", String.class))
                    .lastName(resultSet.getObject("last_name", String.class))
                    .email(resultSet.getObject("email", String.class))
                    .password(resultSet.getObject("password", String.class))
                    .role(userRole)
                    .telephone(resultSet.getObject("telephone", String.class))
                    .birthday(resultSet.getTimestamp("birthday").toLocalDateTime().toLocalDate())
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



//    private UserInfo buildUserInfo(ResultSet resultSet) throws SQLException {
//        return UserInfo.builder()
//                .id(resultSet.getObject("id", Integer.class))
//                .firstName(resultSet.getObject("first_name", String.class))
//                .lastName(resultSet.getObject("last_name", String.class))
//                .email(resultSet.getObject("email", String.class))
//                .password(resultSet.getObject("password", String.class))
//                .role(resultSet.getObject("role_id", Integer.class))
//                .telephone(resultSet.getObject("telephone", String.class))
////                .birthday(resultSet.getObject("birthday", String.class))
//                .build();
//
//    }

    public UserInfo save(UserInfo userInfo) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, userInfo.getFirstName());
            preparedStatement.setObject(2, userInfo.getLastName());
            preparedStatement.setObject(3, userInfo.getEmail());
            preparedStatement.setObject(4, userInfo.getPassword());
            preparedStatement.setInt(5, userInfo.getRole().getId());
            preparedStatement.setObject(6, userInfo.getTelephone());
            preparedStatement.setObject(7, userInfo.getBirthday());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                userInfo.setId(generatedKeys.getInt("id"));
            }
            return userInfo;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public void update(UserInfo userInfo) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, userInfo.getFirstName());
            preparedStatement.setString(2, userInfo.getLastName());
            preparedStatement.setString(3, userInfo.getEmail());
            preparedStatement.setString(4, userInfo.getPassword());
            preparedStatement.setString(5, userInfo.getTelephone());
            preparedStatement.setString(6, userInfo.getBirthday().toString());
            preparedStatement.setInt(7, userInfo.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static UserInfoDao getInstance() {
        return INSTANCE;
    }
}