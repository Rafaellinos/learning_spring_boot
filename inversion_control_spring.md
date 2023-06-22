# Inversion of Control (IoC)

- what is it?
- Is a factory that produces an object instance stored somewhere
- spring container produces the object
- spring containers functions: create and manage object, inject object dependencies
- IoC container manages the dependencies
- Dependency injection (DI) is a form of IoC
- good for unit testing, swap dependencies and louse coupling

![spring_container_factory](assets/spring_container_factory.png)

## Example:

- without IoC:

```java
class Client {
    private Cooker cooker;
    public Cliend() {
        this.cooker = new Cooker(); // <- client must implement the dependency
    }
}
```

- with IoC

```java
class Client {
    private Cooker cooker;
    public Client(Cooker cooker) { 
        // inversion of control, client does not know the implementation
        // dependency is injected
        this.cooker = cooker;
    }
}
```

- with spring IoC
```java
class Client {
    private Cooker cooker;
    
    @Autowired // cooker must have @Component and is injected by spring container
    public Client(Cooker cooker) {
        this.cooker = cooker;
    }
}
```

- advantages:
  - louse coupling
  - reusable
  - use interface to make it batter, do not depend on implementation

- ways to configure IoC
  - XML config file (legacy)
  - Java annotation
  - java source code

# Overview

- types of injection:
  - setter injection
    - for option dependencies
  - constructor injection
    - use when have required dependencies
    - first choice

- @autowired
  - spring look for classes matches
  - type class or interface
  - scan for components
  - if u use constructor with interface param and have only one implementation, spring solve it
  - @Autowired is option if only one constructor

- @component
  - regular java class managed by spring
  - makes class available for dependency injection

- recommend flow:
  - interface -> implementation with @Component -> @Autowired in constructor client

# Spring main entrypoint

- Spring will scan for classes with special annotations, such as @Component, @Service, etc
- Managed by spring container
- on the main entrypoint of the java application, we have @SpringBootApplication
  - Auto Configuration @EnableAutoConfiguration
  - Component Scanning @ComponentScan (Scan main package e.g.: com.example.springtest recursive)
    - spring will not scan other packages like com.example.anotherpackage
    - to use other packages, list explicit @SpringBootApplication(scanBasePackages={"all packages..."})
  - Additional configuration @Configuration (register extra @Beans or import other config classes)
- SpringApplication.run(self.class, args) -> bootstrap spring boot app
  - create app context and register all beans
  - starts embedded server tomcat

# Setter injection

- used in set<Something> like @Autowired setCoach(Coach theCoach) {...}

# @Component vs @Service vs @Repository

- @Component
  - mark the class as a bean for spring to manage
  - registered in ApplicationContext
- @Service
  - Mark as business logic
  - registered in ApplicationContext
  - specialization of @Component
- @Repository
  - used to mark as a persistent layer class
  - used to catch persistence exceptions

# Field injection

- not recommended
- make hard to unittest
- even for private fields by using reflections
- e.g.:

```java
@RestController
class Controller {
    
    @Autowired
    private Coach myCoach; // <- field injection
    // no constructor and no setters
    
    @GetMapping("/hello")
    public String getHello() {
        return myCoach.getSomeString();
    }
}
```


# Qualifiers

- useful for multi interface implementation
- use @Component("qualifierName") || or use @Qualifier with class name lowercase camel
- Constructor autowired:
  - public String someMethod(@Qualifier("qualifierName") Coach coach)
  - or use variable with same name: someMethod(Coach qualifierName)
- SetterField
  - use @Qualifier("qualifierName") as a "wrapper" for the setField method

# Primary annotation

- @Primary for a @Component class, this class will be chosen as a primary option for injection
- no need to use @Qualifier
- only one for multiple implementation
- @Qualifier has higher priority


# Lazy initialization

- @Lazy
- by default, when app starts, all beans are initialized
- spring create an instance of each one of them
- When marked as lazy initialization only init if:
  - needed for dependency injection
  - explicit requested
- to set all the bean as lazy, use spring.main.lazy-initialization=true on properties
- Disadvantages: @RestController is not created until requested, may generate timeout
