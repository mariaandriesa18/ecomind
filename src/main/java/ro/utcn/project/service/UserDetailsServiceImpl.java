package ro.utcn.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.User;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    private Converter<User, UserDetails> userUserDetailsConverter;


    @Autowired
    public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
        this.userUserDetailsConverter = userUserDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return userUserDetailsConverter.convert( user);
    }

    /**
     *
     * The UserDetailsService is used to load the user from a back-end structure like database.
     * The loadUserByUsername method is called when a user tries to login with a username and password,
     * then it is the responsibility of the service to load the user definition and return it to the security framework.
     * The required details includes data like username, password, accountNonExpired, credentialsNonExpired, accountNonLocked and authorities.
     *
     * Once the spring security receives the user object, it will validate the user against the password entered by the user and other data like
     * user account status (accountNonExpired, credentialsNonExpired etc)
     *
     */

    /**
     * Please check the User entity @toString method
     */
    public String getSessionUserUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();

        } else {
             username = principal.toString();
        }
        return username;
    }
}
