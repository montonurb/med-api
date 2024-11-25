package com.montonurb.med.api.repository;

import com.montonurb.med.api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
