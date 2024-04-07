package br.com.med.voll.apimedi.repository;

// import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.voll.apimedi.models.Medico;
import jakarta.validation.constraints.NotNull;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {
    Page<Medico> findAll(Pageable paginacao);

    Object getReferenceById(@NotNull Long id);

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
