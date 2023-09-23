package sn.usher21.helloapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.usher21.helloapp.models.User;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class UserDto {

    private Long id;
    private String fullname;
    private String phone;
    private String address;
    private String login;

    @JsonIgnore
    private String password;

    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .phone(user.getPhone())
                .address(user.getAddress())
                .login(user.getLogin())
                .build();
    }

    public static User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .fullname(userDto.getFullname())
                .phone(userDto.getPhone())
                .address(userDto.getAddress())
                .login(userDto.getLogin())
                .build();
    }
}
