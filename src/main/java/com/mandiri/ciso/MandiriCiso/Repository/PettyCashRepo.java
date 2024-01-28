package com.mandiri.ciso.MandiriCiso.Repository;

import com.mandiri.ciso.MandiriCiso.Model.PettyCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PettyCashRepo extends JpaRepository<PettyCash, Long> {
}
