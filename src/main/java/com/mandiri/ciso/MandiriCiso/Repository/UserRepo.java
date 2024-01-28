package com.mandiri.ciso.MandiriCiso.Repository;

import com.mandiri.ciso.MandiriCiso.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
