package vn.edu.tdtu.repository;

import vn.edu.tdtu.model.User;

public interface UserRepository {
    void add(User item);
    User validate(String email, String password);
    User existed(String email);
}
