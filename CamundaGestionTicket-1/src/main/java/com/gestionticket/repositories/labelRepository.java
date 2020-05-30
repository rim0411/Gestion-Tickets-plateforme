package com.gestionticket.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionticket.models.label;
@Repository
public interface labelRepository extends JpaRepository<label, Long>{
	label findByName(String name);
}
