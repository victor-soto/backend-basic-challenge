package com.victorsoto.athena.repositories;

import java.util.Optional;

import com.victorsoto.athena.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

  Optional<ApplicationUser> findByUsername(String username);

}
