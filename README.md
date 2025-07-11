# 🏦 Agregador de Investimentos

Este projeto é o backend de uma aplicação **Agregadora de Investimentos**, desenvolvido com Java 21, Spring Boot e MySQL.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate (ORM)
- MySQL
- Maven

## ✅ Funcionalidades

Esta é uma API REST completa com operações CRUD:

- 🔍 Consultar usuários
- ➕ Criar usuários
- ✏️ Atualizar dados de usuários
- ❌ Deletar usuários

## 📦 Estrutura do Projeto

O projeto está estruturado seguindo as boas práticas da arquitetura em camadas:

src/
└── main/

└── java/

└── seu_pacote/

├── controller/ --> Camada de entrada (endpoints REST)

├── service/ --> Regra de negócio

└── repository/ --> Persistência com JPA


## 🧠 Conceitos Aplicados

- Inversão de Controle (IoC)
- Injeção de Dependência (DI)
- Uso de annotations do Spring como `@RestController`, `@Service`, `@Repository`, `@Autowired`
- Mapeamento ORM com Hibernate via `@Entity`

## 🛠️ Como Rodar Localmente

1. Clone o repositório:
    
git clone https://github.com/seuusuario/agregador-investimentos.git

2. Configure seu banco MySQL com as credenciais no application.properties

Rode o projeto com:

./mvnw spring-boot:run


## 📫 Contato
Desenvolvido por Guilherme dos Santos Mendonça Enéas
