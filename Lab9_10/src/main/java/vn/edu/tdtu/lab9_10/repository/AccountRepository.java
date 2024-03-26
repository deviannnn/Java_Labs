package vn.edu.tdtu.lab9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.tdtu.lab9_10.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
    boolean existsByEmail(String email);
}
