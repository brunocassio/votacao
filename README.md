# votacao

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
