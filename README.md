# votacao

### Arquitetura 

- A arquitetura escolhida nesse desafio foi a Hexagonal

![Captura de Tela 2024-06-27 às 11 15 20](https://github.com/brunocassio/votacao/assets/6243187/b936c346-8ccb-4a33-b1f7-b38da35e6844)


### Como executar a aplicação?

- A aplicação é Spring Boot standalone, ou seja, após baixar o codigo, rodar a Main classe DesafioVotacaoApplication.java
- Nela já está configurado as dependencias do Docker e Postgres (pom.xml), é necessário ter o cliente Docker instalado na sua maquina.


### Como testar a aplicação?

- Após executar a aplicação, acesse: http://localhost:8080/swagger-ui/index.html
- Adicionar os associados primeiro atraves do endpoint POST /v1/associados, nela contém a validação de CPF e é o primeiro passo para continuar o fluxo.
- Para registrar um voto é necessário primeiro abrir a votação.
- A votação tem uma duração default de 1 minuto, porém pode ser parametrizada com o tempo que você informar.
- Após abrir a votação, informar o id da pauta e do associado e escolher sua opção de voto. ex: S ou N.
- {id} significa que é o id da pauta cadastrada.

### Como conferir os dados na base de dados?

- A configuração de conexão está no arquivo compose.yaml:
    - acesse localhost:5050 para abrir o pgAdmin no browser
    - usuario: admin@localhost.com
    - senha: admin
    - Ao clicar em Servers ele pedirá a senha do banco que é: password (todos esses dados estão no compose.yaml)

### Observações Finais

- Devido ao curto tempo, não foi possível criar algumas tarefas bonus e nem cobrir completamente a aplicação com testes.
- Eu decidi utilizar a biblioteca Mapstruct para conversão dos dto's/entidades e com isso gerou um problema de recursividade no endpoint de contabilizar os votos.
- Esse problema da recursividade existe uma solução utlizando CycleAvoidingMappingContext, mas precisava de mais tempo para soluciona-lo.
- Também gostaria de ter trabalhado um pouco mais na melhoria da Documentação da api.
