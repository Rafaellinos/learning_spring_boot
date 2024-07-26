package br.com.rafaellino.algaworkscurso.infra.repository;

import br.com.rafaellino.algaworkscurso.domain.model.Kitchen;
import br.com.rafaellino.algaworkscurso.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Kitchen add(Kitchen kitchen) {
        return entityManager.merge(kitchen);
    }
}
