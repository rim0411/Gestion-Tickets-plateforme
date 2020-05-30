package com.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.models.TicketM;
import com.user.models.label;
@Repository
public interface labelRepository extends JpaRepository<label, Long>{



}
