package com.victorsoto.accessmanagmentapi.repositories;

import com.victorsoto.accessmanagmentapi.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

  ApplicationUser findByUsername(String username);

}
