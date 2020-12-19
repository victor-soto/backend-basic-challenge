package com.victorsoto.athena.repositories;

import com.victorsoto.athena.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

  ApplicationUser findByUsername(String username);

}
