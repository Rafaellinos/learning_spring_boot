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
