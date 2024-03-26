package vn.edu.tdtu.javatech.Lab10.service;

import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.javatech.Lab10.model.User;
import vn.edu.tdtu.javatech.Lab10.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException{
        List<User> userList = userRepository.findByUsername(username);
        if (userList == null || userList.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return userList.get(0);
    }

}