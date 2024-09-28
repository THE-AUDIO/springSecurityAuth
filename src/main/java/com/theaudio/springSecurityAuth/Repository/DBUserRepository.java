package com.theaudio.springSecurityAuth.Repository;

import com.theaudio.springSecurityAuth.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Long> {
     DBUser findByUsername(String username);
}
