# Gerenciador de Apps Mobile em Java

- Projeto WEB criado para a 1ª prova da disciplina de Laboratório de Programação na UEL

### Tecnologias usadas

- Java + Spring Boot no back-end.
- Thymeleaf (HTML) + Bootstrap (CSS) no front-end.
- JPA/Hibernate + MySQL para persistência dos dados.
- Bean Validation para a validação dos dados

### Observação

1) Crie o banco de dados no MySQL com o nome gerenciamento_AppsMobile e uma tabela nomeada de AppsMobile, e execute o comando SQL que está disponível neste repositório
2) Depois, coloque este código em application.properties:
   
  ```
      spring.application.name=AppsMobile
      
      spring.datasource.url=jdbc:mysql://localhost:3306/gerenciamento_AppsMobile
      spring.datasource.username= (o seu usuário do My SQL, mas o padrão é root)
      spring.datasource.password= (sua senha do My SQL)
      
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql= true
      spring.jpa.database-plataform=org.hibernate.dialect.MySQL8Dialect
      
      spring.mvc.hiddenmethod.filter.enabled=true
  ```
