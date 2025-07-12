# 📊 Agregador de Investimentos

Este projeto é uma API RESTful desenvolvida com Java 21, Spring Boot e MySQL. O objetivo é criar o backend de um **Agregador de Investimentos**, com funcionalidades completas de CRUD, testes unitários e relacionamento entre entidades.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- JUnit 5
- Mockito

## 🧠 Conceitos Aplicados

- Injeção de Dependência e Inversão de Controle (IoC)
- Arquitetura com camadas: `Controller`, `Service`, `Repository`
- ORM com Hibernate para mapeamento objeto-relacional
- Testes unitários com JUnit 5 e Mockito
- Boas práticas em testes: uso de `ArgumentCaptor`, `verify`, `doReturn`, `doNothing`, `doThrow`

## 🔧 Funcionalidades

- ✅ Criar, atualizar, consultar e deletar usuários
- ✅ Testes unitários com cobertura e qualidade
- ✅ Relacionamentos entre entidades:
  - `@OneToOne`
  - `@OneToMany`
  - `@ManyToMany`
- ✅ APIs com suporte a relacionamentos de banco de dados

## 🗃️ Estrutura do Projeto

src/

├── controller

├── service

├── repository

├── entity

└── dto


## ✅ Como executar

**1. Clone o repositório:**
   
   git clone
   
   https://github.com/GuilhermeDoSantoss/agregrador.investimentos.git

*Configure seu banco MySQL com as credenciais no application.properties*

**2. Rode a aplicação:**

./mvnw spring-boot:run

## 🧪 Rodando os Testes

**Execute:**

./mvnw test

## 🤝 Contribuições

Sinta-se à vontade para enviar PRs, sugestões ou abrir issues. Vamos construir juntos uma aplicação de valor!

## 📫 Contato
**Guilherme dos Santos Mendonça Enéas**
