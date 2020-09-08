package ro.utcn.project.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ro.utcn.project.entities.User;
import ro.utcn.project.service.MyUserDetails;


import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {

        MyUserDetails userDetails = new MyUserDetails();

        if (user != null) {
            userDetails.setUsername(user.getUser_name());
            userDetails.setPassword(user.getPassword());
            userDetails.setEnabled(true);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}