### Learning Java Spring Boot

> Esse repositório contém apenas informações coletas nos cursos de spring e spring boot.

* Core Java (J2SE)
    - java.lang, java.util, Arrays, Streams, JSBC etc
    - Basic foundation
    - Mainly used for Desktop enviroment


* JE (Java Standard Edition) vs Java
    - JE == JDK, Core java + JVM + Compiler + libraries and toolkits

* JEE (Java Enterprise Edition) or Jakarta EE or 2EE or J2EE
    - Jakarta = core java + web server
    - EE == Enterprise specification that extend Java SE

* Hibernate and Spring Framework
    - It's not part of Jakarta, it's just libraries and frameworks used in Enterprise software development. 
    - Spring supports Jakarta EE and Java SE Environment.
    - Build java applications
    - Alternative for j2ee
    - released in 2004
    - Lighweight development with java POJOs (Plain-old-java-objects)
    - Dependency injection loose coupling
    - Declarative with AOP (Aspect oriented programming)
    - Minimize boilerplate

* EJB v1 and 2 complexity: poor performance of entity beans, multiple interfaces, multiple deployment descriptos and complex - Not used

* You can do the same thing that spring does in JEE, but because of the very bad reputation of EJB, everyone preferes spring.

* Spring - AOP (Aspect Oriented Programming)
    - Logging, security, transactions etc

* Data Access Layers:
    - JDBC (Reduces code by 50%)
    - ORM -> Hibernate and jpa
    - Transactions 
    - OXM
    - JMS -> async messages

* Web Layer | home of Spring MVC
    - Servlet 
    - WebSocket
    - Web
    - Portlet

* Infra
    - AOP
    - Aspects
    - Instrumentation -> 
    - Messaing

pom.xml = project object model, coração de um projeto maven

Content negotiation => header dizendo qual formato espera receber, exemplo:
application/json, application/xml. 

Flyway => para gerenciar os scripts de migração. Ex: vc cria um arquivo V001__cria-tabela-cliente.sql, nele, vc coloca os arquivos de migração.
A cada mudança nele, é necessário trocar a versão, para V002 por exemplo, se n 
o flyway irá subir uma execption de validação. Ou pode-se deleta os registros flyway na tabela.

# Jakarte EE
* Hibernete é uma implementação do jakarta ee especificação
* Spring data spa é apenas uma biblioteca q ajuda a interagir com Jakarta ee

____________________________________________________

- Core container: Core, beans, SpEL, context
- Factory for creating and manage beans
- AOP - Logging, transactions, security - Aspect oriented programming
- JSM - async msgs
- Jmx - instrumentations

____________________________________________________

# Maven:

- management tool
- maven check local repo
- provides directories structures by default (standardize)
- find jars for u

## Maven key concepts

- pom.xml = Project object model file / root
- POM structure
  - metadata = project name, version, etc
  - dependencies = spring, hibernate | version is optional | GAV - groupId/ArtifactID/Version
  - plug ins = Junit reports
- Maven wrapperfiles:
  - mvnw = run maven project | no need maven or the correct version installed, this script downloads for u
  - mvnw.cmd = for windows
  - mvnw clean compile test on linux
  - ./mvnw clean compile test
  - use mvn $args if u have maven installed
- maven plug in
  - mvn package
  - mvn spring-boot:run

- spring-boot-starter-web = spring-web/hibernate/tomcat/json/spring-webmvc, etc

# warning:

- do not use src/main/webapp if u app is build using .jar, only works for .war
- spring boot includes default template for certain template engines, such as Freemaker, thymeleaf and mustache
- unit test

# Sprint boot starters:

- collection of dependencies maven grouped together for a common propose, tested and verified
- e.g.: spring MVC: spring-boot-starter-web => spring-web, spring-webmvc, hibernate-validator, json, tomcat.
- spring web is spring-boot-starter-web

## Spring boot list of starters:

spring-boot-starter-web = rest, webapps, tomcat, validators, REST
spring-boot-starter-security = spring security support
spring-boot-starter-data-jpa = JPA and hibernate

## Stater parent

- version in parent is used for all dependencies, so u dont need to specify each one of them
- make all compatible
- default config of spring boot plugin (mvn spring-boot:run commands)
- default config for java version, utf8 config

# Spring dev tools

- auto restart when updates


# Actuator

- monitor app
- expose endpoint of monitoring

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-actuator</artifactId>
    <version>2.1.2.RELEASE</version>
</dependency>
```

management.endpoints.web.exposure.include=health,info or *

- endpoints:
  - /actuator
    - /health - customizable
    - /info - not exposed by default, must set on properties
    - use info.app.* to show in /info e.g.: info.app.version: 0.0.1
    - /auditevents:
    - /beans - all beans registered
    - /mappings - all @RequestMapping paths


# Spring security

- spring-boot-stater-security
- generate token automatically
- spring.security.user.name and password to access actuator endpoint
- can use roles, encrypted password etc

# Spring boot command-line

- java -jar | mvn package && java -jar mycoolapp.jar
- mvn spring-boot:run | must have maven plugin

# Spring custom application properties

- @value to access spring properties

# Spring boot server

- groups of properties available: 
- core
  - logging based on package name
    - logging.level.org.hibernate=TRACE
    - logging.level.org.springframework=DEBUG
  - log file output
    - logging.file.name=log_crazy.log
    - logging.file.path=/home/log_folder
- web
  - server:
    - server.port=7070
    - server.servlet.context-path=/my-silly-app # on browser: localhost:7070/my-silly-app
    - server.servlet.session.timeout=15m # default 30min
- security
  - spring.security.user.name=admin && .user.password=123
- data
  - spring.datasource.url=jdbc:mysql...
- devtools, 
- actuator
  - web.exposure.include/exclude
  - web.base-path=actuator # /actuator/health
- integration, testing

# Algaworks spring curso

## Spring vs Jakarta EE (java ee)

- Jakarta está no eclipse foundation
  - Java EE == Jakarta EE   
    - baseado em padronizações
    - JPA é uma especificação que ta dentro do Java EE
    - hibernate implementa a especificação do JPA
- Spring plataforma, inovação, avança mais rapido que J-EE
  - JEE ou spring?
    - pode usar os dois ao mesmo tempo
    - como JPA com spring
    - CDI (J-EE) vs spring framework
    - spring 3 == configuração programática
    - simplificar. convention over configuration, optinativo
    - starters spring == agrupadores de dependencias
    - spring boot vs spring MVC?
      - spring boot camada encima do spring
      - spring mvc:
        - servlet. web. @Controller, @GetMapping
      - spring boot:
        - convention over configuration, auto configuração, pré definições.
        - tomcat, starters

## beans

- beans @component => @configuration, @controller, @restController
- @Bean em metodo retorna bean construido
- método @Bean pode usar um metodo da mesma classe que retorna um bean.
  - ex: @Bean public ClasseXY criaClasseXY() {return new ClasseXY();} 
  - ex cont: @Bean public ClasseXX criaclasseXX() {return new ClasseXX(criaClasseXY());}
  - ou receber o bean como parametro

## custom annotation

- `@Retention(RetentionPolicy.RUNTIME)` == pra anotacao
- public @interface
- pode ser usar custom anotação usando `@Qualifier` e enum

## profiles

- @Profile("prod") etc
- ative via properties spring.profiles.active=prod
- parametro ao iniciar o spring
- pode-se ativar varios profiles = profiles.active=mysql,prod,http....

## ciclo de vida dos beans

- metodo = qualquer void com anotações
- @PostConstruct = javaee, depois do construtor
- @PreDestroy = javaee, antes de destruir
  - quando para a aplicação
- ou via @Configuration @Bean(initMethod= "methodNameInit", destroyMethod = "methodNameDestroy")
- ou implementando a interface InitializingBean/DesposableBean e o metodo afterPropertiesSet()
- `BeanUtils.copyProperties(object1, object2, "id")` para passar dados do objeto2 ao objeto1. o "id" será ignorado nesse map
- `@Lazy` só instancia quando necessário e nao quando app sobe
  * util quando temos dependencia circular

## Observer pattern no spring

- tratar eventos quando algo acontecer
- criar classe de evento e usar ApplicationEventPublisher.publishEvent(new ClasseEvento())
- criar classe litener = recebe o evento (ClasseEvent), usar @EventListener

ex:

```java
@Data
public class Cliente {
    private String name;
    private boolean isActive;
}

@Getter
public class ClienteAtivoEvento {
  private Cliente cliente;  
  public ClienteAtivoEvento(Cliente cliente) {
    this.cliente = cliente;
  }
}

@Component
public class NotificacaoService {
    @EventListener
    public void clienteAtivadoLiterner(ClienteAtivoEvento evento) {
        // fazer algo quando o cliente foi criado....
      System.out.println("enviando email de boas vindas...");
    }
}

@Service
public class CreateCliente {
  
    @Autowired
    private ApplicationEventPublisher eventPublisher; // spring
  
    public void createClient(String nome, Cliente cliente) {
        var c = new Cliente();
        c.setIsActive(true);
        c.setName(nome);
        eventPublisher.publishEvent(new ClienteAtivoEvento(cliente));
    }
}

```

## application.properties

- arquivo de configuracao
- padrao eh application.properties, chave e valor
  - pode-se usar yml
- ex. server.port=8080
- eh possivel sobrescrever via linha de comando
  - ex. java -jar ./target/app-spring.jar --server.port=8082
  - spring: mvn spring-boot:run -Dserver.port 8082
  - via variavel de ambiente SERVER_PORT=8082

- custom properties:
  - no application.properties, coloque = propriedade.subpropriedade.valor=qualquer_string
  - use @Value("${propriedade.subpropriedade.valor}") String valor
  - pode-se criar classe de propriedade

ex:

```java
@Component
@ConfigurationProperties("propriedade.subpropriedade")
@Getter
@Setter
public class Properties {
    private String valor;
}
// adicione spring-boot-configuration-processor para IDE identificar classe e gerar no jar
```

- ambientes em profiles
  - crie application-local.properties, application-dev.properties, etc
  - env = SPRING_PROFILES_ACTIVE=dev

## Maven

- mvn dependency:tree ou :resolve = arvore de dependencias
- mvn help:effective-pom = pom completo

## JPA e Hibernate

- tradicional: Codigo java -> driver jdbc -> mysql
- ORM -> mapeamento de classes
  - ORM: Codigo java -> ORM -> driver jdbc -> mysql 
  - tabela -> classe
  - linha -> objeto instancia
  - coluna -> atributo/campos
  - FK -> campo de outra classe

- JPA = Java EE/Jakarta EE = especificação
- hibernate implementa JPA

- config pom.xml
  - starter = spring data jpa + spring data jpa
  - adicionar connection com banco de dados
  - spring.datasource.url=jdbc:mysql://localhost:3603/schema?createDatabaseIfNotExist=true&serverTimezone=UTC
  - spring.datasource.username e passaword
  - adicionar jar do driver especifico
  - spring.jpa.show-sql=true = mostra as queries sendo feitas no log

- codigo
  - `@PersistenceContext private EntityManager manager` -> manager.createQuery("from table", TableClass.class); -return > TypedQuery<TableClass>
  - @Transactional public SomeClass add(SomeClasss someClass) {manager.merge(cozinha)} // usar @Transactional
  - EntityManager -> find, merge(se passar id, atualiza), remove e createQuery
    - para remove, precisa dar find primeiro, pois, o objeto precisa estar em estado "managed", sem isso n será possivel remover
  - `@Repository` = `@Component` + adiciona tbm tradutor de exceptions da SQL para exceptions do spring

- JPQL - Java Persistence Query Language
  - definido por J-EE, semelhante ao SQL, porém mais orientado a objetos
  - ex: `manager.createQuery("from TableName where columnName like :name", ClassTable.class).setParameter("name", "%" + variable + "%")`
  - Pode-se fazer mapeamento de queries com xml em META-INF/orm.xml ao invés de usar `@Query`

- SDJ - Spring Data Jpa
  - repositório genérico. Facilita implementação de repos JPA
  - via interface com métodos comuns gerados em runtime, como `findAll()`
    - use `@Repository` e `extends JpaRepository<EntityClass, Long>`
    - `JpaRepository` herda de `PagingAndSorting` e `CrudRepository`, que oferecem métodos comuns
    - incluido em spring-boot-starter-jpa
    - para consultar por algum atributo, use o nome do método com o nome do atributo/campo
      - ex: `Object name(String name);` obter por nome
      - ex2: `Object findBy(String name)` ou `Object findByName(String name)`
    - métodos podem retornar `Optional` para evitar nullPointers
    - prefixos comuns:
      * buscar = get, query, find, read, stream, findFirst, findLast, findTop10
      * verificar = `exists` retorna boolean 
      * contar = countBy
    - sufixos comuns:
      * like/ilike = Contains/ConstainsIgnoreCase
      * between = range de datas, Long, Int, etc. Dois argumentos
      * And = combinar operaçoes
  - `@Query("from TableName where columnName like %:variableParam% and tableName.id = :id")`
    * Pode se manter o nome do parametro igual ou `@Param("ColumnName") Long id`
  - É possível fazer um custom repository colocando o sufixo de Impl. use `EntityManager` pra isso.
    * N é necessário implementar a interface, SDJ ira juntar os dois mesmo que o Impl n tenha tds métodos implementados
    * É possível fazer mixin das interfaces, como a interface do `@Repository` e outra com apenas uma interface/metodo implementado pela custom Impl
  - Criteria API = para queries complexas usando codigo java.
    * Use `CriteriaBuilder` para gerar `CriteriaQuery<T>`
    * Tem group(), where(), from(), like(), greaterThanOrEqualTo(), etc
  - Specifications (DDD) em SDJ
    * Classes que representam um filtro ex: `new EntityWithSomeFilterPropertySpec()`
    * use `implements Specification<T>` e implementar o método `T toPredicated(...criteria.Root, CriteriaQuery<?> query, CretieriaBuilder builder){}`
    * pode-se juntar especificacoes com `Specification<?>.and(anotherSpecification)`
  - `@NoRepositoryBean` para customizar `JpaRepository<T, ID>` base
    * Na Impl, extenda de `SimpleJpaRepository<T, ID>`
    * Implemente o método custom e faça composição das interfaces
    * no main, use a annotation `@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)`

- Aggregate DDD
  - Aggregate eh padrao do DDD
  - Eh um conjunto de objetos de dominio que podem se tratar de uma mesma unidade de dominio
   - ex: Pedido aggregate == Pedido domain(Aggregate root), ItemPedidoDomain e StatusPedidoDomain
   - quando referencia de fora do aggregate, sempre referenciar ao root

- Repository DDD
  - interface de abstração de acesso a dados
  - pensa em negocio, oq um repositorio de cozinha deveria permitir?
  - como se fosse uma coleção desse domain, como: "preciso de uma cozinha -> metodo get()"
  - geralmente, n se faz repository para dominios que n sejam root

- Relacionamentos/Cardinais
  * Many to one 
    - `@ManyToOne` classe atual (eh o many) e o campo é o one
    - ex. `public class ClasseXX { @ManyToOne private ClasseXY classeXY; }`
    - Cada ClasseXY, tem varias ClasseXX
    - joinColumn quando for manytoOne legado
  * One to many
    - `@OneToMany(mappedBy = "tableNameClasseXX")` classe atual (one) e o campo é o muitos
    - ex. `public class Classe XY { @OneToMany private List<ClasseXX> classeXXs; }` 
    - :warning: caso houver mapeamento circular, use `@JsonIgnore` de jackson
  * Many to many
    - `@ManyToMany(name="tableManyToManyName", joinColumn = @JoinColumn(name="id_entidade_que_estamos"))`
    - `joinColumn = @JoinColumn(name="id_entidade_que_estamos")` esse trecho serve pra especificar qual ID na tabela de many2many é da classe atual
    - `inverseJoinColumns = @JoinColumn(name="id_entidade_relacionamento")` aponta para qual id do relacionamento, ou seja, da outra classe que estamos referenciando

- `@Emdeddable` -> value object, sera usado em outro tabela mas mapeado na classe anotada
- `@Embedded` -> na classe target, coloque o field com referencia a classe de value object e a annotation de embedded

>> Padrao eh nullable, se for especificar calunas que n podem ser num, use o atributo `@Column(nullable=fase)`

## Spring via terminal

```java
public class main {

  public static void main(String[] args) {
    // ClassConfigured has @SpringBootApplication
    ApplicatonContext applicatonContext = new SpringApplicationBuilder(ClassConfigured.class)
            .web(WebApplicationType.NONE).run(args);
    SomeBeanClass someBeanClass = applicatonContext.getBean(SomeBeanClass.class);
  }
}
```

## Spring Rest

- Rest = Representational state transfer
- API / modelo arquitetural, especificação para web services
- Client servidor / Stateless / pode cache
- Mais comum eh usar http para o REST

- Restful = API em conformidade 100% com REST
- para recursos, usar plural. ex: produtos/{codigo do produto}

- Annotations
  * `@Controller` e `@ResponseBody` == `@RestController`
  * `@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)`
  * `@RequestMapping` tbm aceita produces para controller inteira
  * `@PatchMapping` use `Map<String, Object>` para obter campos que foram setados e evitar receber o dto inteiro
  * findField de `ReflectionUtils.findField` e depois `Field.setField` para setar atributos dinamicamente

- jackson
  * `@JsonProperty(value = "titulo")` para representar campo no json
  * `@JsonIgnore` remover campo do parse
  * `@JsonRootName("classeNome")` nome da propriedade na tag xml da classe

- `ResponseEntity<T>` alternativa do retorno dos métodos da controller para ter builder
  - ex: `return ResponseEntity.status(HttpStatus.OK).body(variavel);`
  - ex2: `return ResponseEntity.ok(variavel);` ou `return ResponseEntity.notFound();`

- Modelo de maturidade de Richardson
  * nivel 0 (nao rest)
    - POX - plain old XML
    - http só para transporte, não usa semantica http ou status
    - geralmente, unica url pra tudo
  * nivel 1 (Recursos)
    - Varias urls, como /pessoas, /cidades
  * nivel 2 (Verbos http)
    - semantica http e codigos de retorno (200, 404, etc)
  * nivel 3 (HATEOAS)
    - links para subobjetos e recursos
    - json ex: `{outros..., "links": ["fornecedor": "/fornecedores/123"]}`

parei: 6.2