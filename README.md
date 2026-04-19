Sistema de Eventos 
Sistema web para cadastro e gerenciamento de eventos e convidados, desenvolvido com Spring Boot, JPA, Thymeleaf e MySQL. 
Sobre o projeto 
Este projeto permite: - cadastrar eventos; - listar eventos cadastrados; - visualizar os detalhes de um evento; - adicionar convidados a um
evento; - excluir eventos e convidados. 
A aplicação usa uma entidade Evento com os campos codigo, nome, local, data, horario e a relação com convidados. A entidade
Convidado possui rg, nomeConvidado e vínculo com um evento. O projeto está estruturado com controller, model e repository, além de páginas
Thymeleaf em src/main/resources/templates/evento. 
Tecnologias utilizadas 
Java 21
Spring Boot
Spring Data JPA
Thymeleaf
MySQL
Maven 
Estrutura principal 
src/main/java/com/evento/evento/
├── EventoApplication.java
├── controllers/
│ ├── EventoController.java
│ └── Convidado.java
├── models/
│ └── Evento.java
└── repository/
├── EventoRepository.java
└── ConvidadoRepository.java
 src/main/resources/templates/evento/
├── formEvento.html
├── index.html
└── detalhesEventos.html

Funcionalidades 
Eventos 
cadastro de novos eventos;
listagem de eventos;
visualização de detalhes por código;
remoção de eventos. 
Convidados 
inclusão de convidados em um evento;
listagem de convidados vinculados ao evento;
remoção de convidados. 
Como executar 
Pré-requisitos 
Java 21 instalado;
Maven instalado ou uso do Maven Wrapper;
MySQL em execução. 
Passos 
Clone o repositório: bash git clone https://github.com/EdgarLacerda/Sistema-de-eventos.git cd Sistema-de-eventos 
Configure o banco de dados MySQL conforme o seu ambiente.
Execute a aplicação: bash ./mvnw spring-boot:run 
Acesse a aplicação no navegador.Observações 
O projeto já contém Maven Wrapper (mvnw e mvnw.cmd).
A aplicação foi organizada para funcionar com páginas renderizadas no servidor usando Thymeleaf.
Se quiser, posso adaptar este README com nome do autor, objetivo acadêmico, prints e seção de instalação do banco de dados. 
Licença 
Defina aqui a licença do projeto, caso queira adicionar uma
