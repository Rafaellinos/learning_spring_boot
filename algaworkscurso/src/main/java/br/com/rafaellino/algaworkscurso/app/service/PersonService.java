package br.com.rafaellino.algaworkscurso.app.service;

import br.com.rafaellino.algaworkscurso.app.event.PersonCreatedEvent;
import br.com.rafaellino.algaworkscurso.domain.model.Person;
import br.com.rafaellino.algaworkscurso.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ApplicationEventPublisher eventPublisher;

    public Person create(Person person) {
        person = personRepository.add(person);
        eventPublisher.publishEvent(new PersonCreatedEvent(person));
        return person;
    }
}
