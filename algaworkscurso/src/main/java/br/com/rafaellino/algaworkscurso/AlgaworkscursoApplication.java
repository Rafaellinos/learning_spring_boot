package br.com.rafaellino.algaworkscurso;

import br.com.rafaellino.algaworkscurso.app.service.PersonService;
import br.com.rafaellino.algaworkscurso.domain.model.Kitchen;
import br.com.rafaellino.algaworkscurso.domain.model.Person;
import br.com.rafaellino.algaworkscurso.domain.model.Restaurant;
import br.com.rafaellino.algaworkscurso.domain.repository.KitchenRepository;
import br.com.rafaellino.algaworkscurso.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class AlgaworkscursoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AlgaworkscursoApplication.class, args);
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaworkscursoApplication.class).web(WebApplicationType.NONE).run(args);

		Kitchen kitchen = new Kitchen();
		kitchen.setName("cozinha brasileira");

		KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);
		kitchen = kitchenRepository.add(kitchen);
		Restaurant restaurant = Restaurant
				.builder().name("Restaurante do Alemao").kitchen(kitchen).shipmentFee(BigDecimal.valueOf(12.3)).build();
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		restaurant = restaurantRepository.add(restaurant);
		System.out.println(restaurant);

		Person person = Person.builder().age(32).document("423123213").name("rafael").build();
		PersonService personService = applicationContext.getBean(PersonService.class);
		person = personService.create(person);
		System.out.println(person.getId());

	}

}
