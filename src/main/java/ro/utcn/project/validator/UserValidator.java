package ro.utcn.project.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import ro.utcn.project.constants.MessagesConstants;
import ro.utcn.project.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate different flows related to user.
 */

public class UserValidator {

    public static String validateUserRegister(UserDto userDto) {
        if(StringUtils.isEmpty(userDto.getName())){
            return "Please insert a name";
        }
        if(StringUtils.isEmpty(userDto.getSurname())){
            return "Please insert a surname";
        }

        if(StringUtils.isEmpty(userDto.getUsername())){
            return "Please insert an username";
        }

        if (StringUtils.isNotEmpty(userDto.getEmail())) {
            if(!(UserValidator.validEmail(userDto.getEmail()))){
                return MessagesConstants.BAD_EMAIL;
            }
        }else {
                return MessagesConstants.INSERT_EMAIL;
        }

        if(StringUtils.isNotEmpty(userDto.getPassword()))
        {
            if(!(UserValidator.validPassword(userDto.getPassword()))){
                return MessagesConstants.BAD_PASSWORD;
            }
        }else{
            return  MessagesConstants.INSERT_PASSWORD;
        }


        return "OK";
    }

    public static boolean validPassword(String password){
        String pattern = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z]).{1,8})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return true;
    }

    public static boolean validEmail(String email){
        String pattern = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();

    }

}
