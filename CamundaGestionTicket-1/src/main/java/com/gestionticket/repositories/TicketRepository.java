package com.gestionticket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionticket.models.*;




@Repository
public interface TicketRepository extends JpaRepository<TicketM, Long>{
	List<TicketM> findByStatut(String statut);
	List<TicketM> findByTitre(String titre);
	List<TicketM> findByAssigner(String assigner);
	List<TicketM> findByLabel(label label);
	List<TicketM> findByAssignerAndStatut(String assigner, String statut);
	List<TicketM> findByLabelAndStatut(label label, String statut);

}
