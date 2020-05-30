package com.user.repositories;

import java.util.List;
import java.util.Optional
;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.models.TicketM;
import com.user.models.userM;



@Repository
public interface TicketRepository extends JpaRepository<TicketM, Long>{
	List<TicketM> findByStatut(String statut);

}
