package ro.utcn.project.mapper;

import org.springframework.stereotype.Component;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.entities.User;

@Component
public class UserMapper {

    public static UserDto convertUserToUserDTO(User user){

        if(user != null) {
            UserDto userDTO = new UserDto();
            userDTO.setName(user.getName());
            userDTO.setSurname(user.getSurname());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            return userDTO;
        }

        return null;

    }

    public static User dtoToUser(UserDto userDto){
        if(userDto != null){
            User user = new User();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setUser_name(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            return user;
        }
        return null;
    }


}
