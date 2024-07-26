package br.com.rafaellino.algaworkscurso.app.event;

import br.com.rafaellino.algaworkscurso.domain.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonCreatedEvent {

    private final Person person;
}
