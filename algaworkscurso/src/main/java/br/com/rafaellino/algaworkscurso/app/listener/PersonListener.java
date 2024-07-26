package br.com.rafaellino.algaworkscurso.app.listener;

import br.com.rafaellino.algaworkscurso.app.event.PersonCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PersonListener {

    @EventListener
    private void PersonCreateListener(PersonCreatedEvent event) {
        System.out.println("person created listener....");
        System.out.println(event.getPerson());
    }
}
