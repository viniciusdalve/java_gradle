#
Projeto Java + Gradle


-Descrição do seu projeto - =

API REST com 3 entidades : SETOR, CARGO, TRABALHADOR

-Funcionalidades:

Listar setores, adicionar setor, excluir setor, alterar setor;

Listar cargos, adicionar cargos, excluir cargos, alterar cargos;

Listar trabalhadores, adicionar trabalhadores, excluir trabalhadores

-Regras de negócio:

Após um setor criado, é possível cargo pode ser criado atrelado a este setor, depois de um cargo criado, é possível criar um trabalhador atrelado a este cargo e setor.

Não é possível cadastrar mais de um trabalhador com o mesmo cpf

Despois de excluido um setor, todos os cargos e trabalhadores atrelados a ele, também serão excluídos

-Tecnologias:

Java 11
SpringBoot 2.5.4
PostgreSQL
Gradle

-Manual de funcionamento:

Criar primeiramente um bacno de dados no postgre, cahamado "seasolutions"

Rodar a aplicação

Olhar documentação Swagger em http://localhost:8080/swagger-ui/index.html#/

Realizar o funcionamento dos endpoints de acordo com a documentação.






