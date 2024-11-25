package com.montonurb.med.api.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.montonurb.med.api.models.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m FROM Medico m WHERE m.ativo = TRUE")
    Page<Medico> buscarMedicosAtivos(Pageable pageable);
}
