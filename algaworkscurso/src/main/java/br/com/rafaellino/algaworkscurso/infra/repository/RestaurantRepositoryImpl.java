package br.com.rafaellino.algaworkscurso.infra.repository;

import br.com.rafaellino.algaworkscurso.domain.model.Restaurant;
import br.com.rafaellino.algaworkscurso.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Restaurant add(Restaurant restaurant) {
        return entityManager.merge(restaurant);
    }
}
