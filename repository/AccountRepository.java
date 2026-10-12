package com.bm.demo.repository;

import com.bm.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Spring Data JPA automatically provides all CRUD methods out-of-the-box!
    // It also handles exception translation automatically under the hood.
}