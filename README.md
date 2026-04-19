# 📅 Sistema de Eventos

Sistema web para cadastro e gerenciamento de eventos e convidados, desenvolvido com **Spring Boot**, **JPA**, **Thymeleaf** e **MySQL**.

---

## 📋 Sobre o projeto

A aplicação permite gerenciar eventos e seus respectivos convidados de forma simples e intuitiva, com páginas renderizadas no servidor via Thymeleaf.

**Funcionalidades disponíveis:**

- Cadastrar novos eventos
- Listar eventos cadastrados
- Visualizar detalhes de um evento
- Adicionar e remover convidados de um evento
- Excluir eventos

---

## 🗂️ Entidades

**Evento**
| Campo | Tipo |
|-----------|--------|
| codigo | Long |
| nome | String |
| local | String |
| data | Date |
| horario | String |
| convidados | List\<Convidado\> |

**Convidado**
| Campo | Tipo |
|---------------|--------|
| rg | String |
| nomeConvidado | String |
| evento | Evento |

---

## 🛠️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**

---

## 📁 Estrutura do projeto

```
src/main/java/com/evento/evento/
├── EventoApplication.java
├── controllers/
│   ├── EventoController.java
│   └── Convidado.java
├── models/
│   └── Evento.java
└── repository/
    ├── EventoRepository.java
    └── ConvidadoRepository.java

src/main/resources/templates/evento/
├── formEvento.html
├── index.html
└── detalhesEventos.html
```

---

## ▶️ Como executar

### Pré-requisitos

- [Java 21](https://www.oracle.com/java/technologies/downloads/) instalado
- [Maven](https://maven.apache.org/) instalado (ou use o Maven Wrapper incluído)
- [MySQL](https://www.mysql.com/) em execução

### Passos

**1. Clone o repositório**
```bash
git clone https://github.com/EdgarLacerda/Sistema-de-eventos.git
cd Sistema-de-eventos
```

**2. Configure o banco de dados**

Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_eventos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

> Crie o banco de dados `sistema_eventos` no MySQL antes de executar a aplicação.

**3. Execute a aplicação**
```bash
./mvnw spring-boot:run
```

**4. Acesse no navegador**
```
http://localhost:8080
```

---

## 📌 Observações

- O projeto já inclui o **Maven Wrapper** (`mvnw` e `mvnw.cmd`), dispensando a instalação manual do Maven.
- A aplicação utiliza renderização server-side com **Thymeleaf**.
- O Spring JPA pode criar as tabelas automaticamente conforme a configuração de `ddl-auto`.

