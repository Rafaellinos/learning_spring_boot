package br.com.rafaellino.algaworkscurso.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "person")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class Person {

    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String document;
}
