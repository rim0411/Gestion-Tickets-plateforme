package com.user.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.models.userM;

@Repository
public interface UserRepository extends JpaRepository<userM, Long> {
	Optional<userM> findByUsername(String username);

	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}
