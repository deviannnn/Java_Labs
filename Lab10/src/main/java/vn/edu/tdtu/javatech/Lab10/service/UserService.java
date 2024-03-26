package vn.edu.tdtu.javatech.Lab10.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.edu.tdtu.javatech.Lab10.model.User;

public interface UserService extends UserDetailsService {

    User update(User user);

    public User loadUserByUsername(String username) throws UsernameNotFoundException;
}