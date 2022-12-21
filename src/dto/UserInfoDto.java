package dto;


import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Value
@Builder
public class UserInfoDto {

    String firstName;
    String lastName;
    String email;
    String password;
    String roleId;
    String telephone;
    String birthday;
    Part image;
}