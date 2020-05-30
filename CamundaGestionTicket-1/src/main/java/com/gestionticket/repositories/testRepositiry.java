package com.gestionticket.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionticket.models.test;
@Repository
public interface testRepositiry extends JpaRepository<test, Long>{



}