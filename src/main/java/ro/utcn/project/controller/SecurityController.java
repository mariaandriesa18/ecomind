package ro.utcn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.constants.EndpointsRoutes;
import ro.utcn.project.constants.RedirectRoutes;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.entities.User;
import ro.utcn.project.service.UserService;

/**
 * Here add the basic security endpoints:login, register, default redirect if login success
 */
@Controller
public class SecurityController {

    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    /**
     * @RequestMapping with htpp method type is a deprecated annotation.
     * <p>
     * Use these annotations instead:
     * @GetMapping - to perform a get request and retrieve pages with data.
     * @PostMapping - to perform an add request.
     * @PutMapping - to perform an update request.
     * @DeleteMapping - to perform an delete request.
     */

    @Autowired
    private UserService userService;

    @GetMapping(EndpointsRoutes.HOME)
    private ModelAndView home() {
        log.warn("Don't forget to use logs instead of system.out. And also log controllers/services for specific operations.");
        ModelAndView modelAndView = new ModelAndView();
        log.info("Loged user doing this request is:" + userService.getSessionUserUsername());
        String username = userService.getSessionUserUsername();
        User user = userService.findByUserName(username);

        if(user.getRole().equals("admin")){
            modelAndView.setViewName(RedirectRoutes.ADMIN_PAGE_REDIRECT);
            return modelAndView;
        }

        if(user.getHouseholdProfile() == null){
            modelAndView.setViewName(RedirectRoutes.USER_WITHOUT_REDIRECT);
        }else {
            modelAndView.setViewName(RedirectRoutes.USER_WITH_REDIRECT);

        }
        return modelAndView;
    }

    @GetMapping(EndpointsRoutes.LOGIN)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


}