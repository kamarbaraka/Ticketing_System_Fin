package com.kamar.ticketing_system_fin.user.repository;

import com.kamar.ticketing_system_fin.user.entity.NormalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the normal user repository.
 * @author kamar baraka.*/

@Repository
public interface NormalUserRepository extends JpaRepository<NormalUser, String > {

    NormalUser findNormalUserByEmail(String email);
}
