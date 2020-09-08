package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.utcn.project.dto.ShowUsersDTO;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.entities.User;
import ro.utcn.project.mapper.UserToShowUsersDto;
import ro.utcn.project.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Please check the following links:
 * https://www.baeldung.com/spring-security-authentication-with-a-database.
 * https://docs.spring.io/spring-security/site/docs/3.0.x/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html.
 */
@Service
public class  UserService extends UserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findByUserName(String name){
        return userRepository.findUserByUsername(name);
    }


    public List<ShowUsersDTO> getAllUsers(){
        return UserToShowUsersDto.convertListOfUsersToListOfShowUsersDTO(userRepository.findAllRegularUsers());
    }


    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public void saveUser(UserDto userDTO){
        User user = new User();
        user.setUser_id(UUID.randomUUID().toString());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setUser_name(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setRole("regular");

        userRepository.save(user);

    }

    @Transactional
    public void updateUser(User user){
        User user1  = userRepository.getOne(user.getUser_id());
        user1.setHouseholdProfile(user.getHouseholdProfile());
        user1.setUser_name(user.getUser_name());
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
    }

    @Transactional
    public void deleteUser(String username){
        userRepository.deleteUserByUsername(username);
    }


    @Transactional
    public void updateUserbyUsername(UserDto userDto, String username ){
        //User user = userRepository.findUserByUsername(userDto.getUsername());
        if(userDto.getName() != null){
            userRepository.updateUserName(userDto.getName(),username);
        }
        if(userDto.getUsername() != null){
            userRepository.updateUserUsername(userDto.getUsername(), username);
        }

        if(userDto.getEmail() != null){
            userRepository.updateUserEmail(userDto.getEmail(), username);
        }
        if(userDto.getSurname() != null){
            userRepository.updateUserSurname(userDto.getSurname(), username);
        }

    }
}
