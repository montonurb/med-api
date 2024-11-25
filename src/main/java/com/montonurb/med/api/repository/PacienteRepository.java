package com.montonurb.med.api.repository;

import com.montonurb.med.api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
