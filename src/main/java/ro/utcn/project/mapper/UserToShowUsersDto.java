package ro.utcn.project.mapper;

import org.springframework.stereotype.Component;
import ro.utcn.project.dto.ShowUsersDTO;
import ro.utcn.project.entities.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToShowUsersDto {

    public static ShowUsersDTO convertUserToShowUsersDTO(User user){

        ShowUsersDTO s1 = new ShowUsersDTO();
        s1.setEmail(user.getEmail());
        s1.setName(user.getName());
        s1.setSurname(user.getSurname());
        return s1;
    }

    public static List<ShowUsersDTO> convertListOfUsersToListOfShowUsersDTO(List<User> userList){

        List<ShowUsersDTO> userDtoList = new ArrayList<>();
        for(User us : userList){
                userDtoList.add(convertUserToShowUsersDTO(us));
        }

        return  userDtoList;
    }

}
