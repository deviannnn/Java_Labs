package vn.edu.tdtu.lab9_10.service;

import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.tdtu.lab9_10.model.Account;

public interface AccountService {
    public Account findByEmail(String email);
    UserDetails loadUserByUsername(String email);
}

