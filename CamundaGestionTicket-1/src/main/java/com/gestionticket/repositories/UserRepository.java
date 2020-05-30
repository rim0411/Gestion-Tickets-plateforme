package com.gestionticket.repositories;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestionticket.models.*;


@Repository
public interface UserRepository extends JpaRepository<userM, Long> {
	Optional<userM> findByUsername(String username);
	List<userM> findByid(Long id);
	List<userM> findByLabel (label label);
	List<userM> findByusername(String username);
	List<userM> findByRoles(Role role);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
    @Query("SELECT u.email FROM user u WHERE u.email = ?1")
    Boolean findEmailVerifiedByEmail(String email);
    @Modifying
    @Query("update user u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
    userM findByEmail(String email);
     List< userM> findByemail(String email);}
