package br.com.rafaellino.algaworkscurso.infra.repository;

import br.com.rafaellino.algaworkscurso.domain.model.Person;
import br.com.rafaellino.algaworkscurso.domain.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Person add(Person person) {
        return entityManager.merge(person);
    }
}
