package ro.utcn.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.constants.EndpointsRoutes;
import ro.utcn.project.constants.RedirectRoutes;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.mapper.UserMapper;
import ro.utcn.project.service.UserService;
import ro.utcn.project.validator.UserValidator;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping(EndpointsRoutes.REGISTER)
    public ModelAndView register() {

        ModelAndView mv= new ModelAndView();
        UserDto user = new UserDto();
        mv.addObject("user", user);
        mv.setViewName(EndpointsRoutes.REGISTER);

        return mv;
    }

    @PostMapping(EndpointsRoutes.REGISTER)
    public ModelAndView createUser(@Valid UserDto userDto, BindingResult bindingResult, ModelAndView mv) {

        String response = UserValidator.validateUserRegister(userDto);

        if(!(response.equals("OK"))){
            bindingResult.rejectValue("username", response);
        }

        UserDto emailExists = UserMapper.convertUserToUserDTO(userService.findUserByEmail(userDto.getEmail()));
        UserDto usernameExists = UserMapper.convertUserToUserDTO(userService.findByUserName(userDto.getUsername()));

        if(emailExists != null) {
            bindingResult.rejectValue("email", "error.user.email", "This email already exists!");
        }
        if(usernameExists != null ){
            bindingResult.rejectValue("username", "error.user.username", "This email already exists!");
        }

        if(bindingResult.hasErrors()) {
            mv.setViewName("register");

        } else {
            userService.saveUser(userDto);
            mv.addObject("msg", "User has been registered successfully!");
            mv.addObject("user", new UserDto());
            mv.setViewName(RedirectRoutes.LOGIN_REDIRECT);

        }
        return mv;
    }
}
