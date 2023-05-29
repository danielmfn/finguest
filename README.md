# Readme

### Requisitos

Requisitos necessários para rodar o projeto:

* JDK 17.0.6
* Maven 3.8.4

### No diretório do projeto executar os seguintes comandos:
* mvn clean install -U
* mvn spring-boot:run

### Link Swagger
* url: http://localhost:8081/swagger-ui.html

### H2 Database
Acesso ao painel do H2 Database:

* url: http://localhost:8081/h2
* usuário: sa
* senha: admin

### Exemplos de Requisições

* POST (/v1/financeiro)
http://localhost:8081/v1/financeiro

`{
    "tipo" : "CRÉDITO",
    "valor": "100.60",
    "descricao": "Venda 3"
}`

* PUT (/v1/financeiro)
http://localhost:8081/v1/financeiro

`{
    "id": "1",
    "tipo": "CRÉDITO",
    "valor": "300.45",
    "descricao": "Venda 1"
}`

* GET (/v1/financeiro)
  http://localhost:8081/v1/financeiro
  
* GET (/v1/financeiro)/{id}
  http://localhost:8081/v1/financeiro/1

* DELETE (/v1/financeiro)
http://localhost:8081/v1/financeiro?id=5

* GET (/v1/financeiro/consolidado)
  http://localhost:8081/v1/financeiro/consolidado?data=2023-05-29


OBS: O projeto executará com uma carga inicial de dados
