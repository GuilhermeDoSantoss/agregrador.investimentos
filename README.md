# 📊 Agregador de Investimentos

Bem-vindo ao projeto **Agregador de Investimentos**!

Este projeto foi desenvolvido com foco em boas práticas de backend, arquitetura em camadas, testes unitários e consumo de APIs externas com Java 21 e Spring Boot.

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- OpenFeign
- JUnit 5
- Mockito

## 📌 O que foi implementado

### ✅ API REST CRUD
- Estrutura baseada em Controller, Service e Repository.
- Operações de criar, consultar, atualizar e deletar usuários.
- Annotations principais do Spring Boot.
- Injeção de dependência e inversão de controle com `@Autowired`, `@Service`, `@Repository`, `@RestController`, etc.

### ✅ ORM com Hibernate
- Mapeamento automático das classes Java para o banco de dados MySQL usando JPA.
- Criação de entidades com relacionamentos:
  - `@OneToOne`
  - `@OneToMany`
  - `@ManyToMany`

### ✅ Testes Unitários com JUnit5 e Mockito
- Testes robustos para a camada de serviço.
- Boas práticas aplicadas: isolamento de dependências, cobertura lógica e comportamento.
- Técnicas utilizadas:
  - `@Mock`, `@InjectMocks`
  - `verify`, `doReturn`, `doThrow`, `doNothing`
  - `ArgumentCaptor`

### ✅ Consumo de API Externa (Bolsa de Valores)
- Integração com APIs de preços de ações usando OpenFeign.
- Obtenção de credenciais e autenticação.
- Requisições HTTP GET com headers e parâmetros dinâmicos.

## 🗃️ Estrutura do Projeto

📁 src

┣ 📂 controller

┣ 📂 service

┣ 📂 repository

┣ 📂 entity

┣ 📂 dto

┗ 📂 tests

## ✅ Como executar

**1. Clone o repositório:**
   
   git clone
   
   https://github.com/GuilhermeDoSantoss/agregrador.investimentos.git

*Configure seu banco MySQL com as credenciais no application.properties*

**2. Rode a aplicação:** 

./mvnw spring-boot:run


**3. Rode a aplicação com:**

SpringBootApplication.

## 🧪 Rodando os Testes

**Execute:**

./mvnw test

## 🤝 Contribuições

Sinta-se à vontade para enviar PRs, sugestões ou abrir issues. Vamos construir juntos uma aplicação de valor!

## 📫 Contato
**Guilherme dos Santos Mendonça Enéas**
