# CVC Bank API

Aplicação para registro e controle de transações financeiras.

## Requisitos do projeto

* Criar transações.
* Exibir transferências realizadas.
* Calcular taxa com base na diferença entre a data de agêndamento e a data efetiva da transferência.

### Requisitos adicionais aplicados

* Criação de conta - 
    - Somente usuários cadastrados podem realizar transferências
* Validação de conta e transferência
    - Transferências só podem ser realizadas por usuários que possuem saldo compatível, contemplando o valor da transferência e o adicional de taxa aplicada. Transferências não podem ser realizadas para uma mesma conta, ou para uma conta inválida.
* Controle de saldo das contas - 
    - Os saldos das contas devem ser atualizados após cada transferência com a finalidade de informar sempre o saldo atual do portador da conta.

### Próximas funcionalidades

* Exibição do extrato detalhado para do portador da conta
* Visualização do saldo, transações e taxas por parte do dono do banco.

## Documentação técnica

### Arquitetura

A Aplicação consiste em uma API Restful com os serviços de transação e conta centralizados, com a finalidade de garantir uma estrutura de validação viável, mas estruturados lógicamente para uma possível separação em serviços distintos.



#### Fluxo da Aplicação

Para acessar os recursos de conta e transferências é necessário realizar o processo de autenticação descrito no tópico API Docs. Estando autenticado, não é preciso informar a conta de origem para a realização de uma tranferência, só é necessário informar a identificação do beneficiário e o token gerado no processo de login (Bearer Token).

* Criação de conta 
- - POST /v1/accounts (Informar saldo inicial da conta, considerando isso como uma portabilidade ou transferência para a conta a ser criada)

* Geração de token de acesso aos recursos protegidos 
- - POST /login

##### Recursos protegidos

* Visualização de saldo da conta logada.
- - GET /v1/accounts

* Criação de uma transferência.
- - POST /v1/transfers

* Busca de uma transferência.
- - GET /v1/transfers/{id}

* Busca de todas as transferêcias da conta logada.
- - GET /v1/transfers

![alt text](https://github.com/lucasmancan/cvc-bank-api/blob/master/cvc-api.png?raw=true)


### Tecnologias Aplicadas

* Java 11
* Micronaut
* Docker
* Open API

#### Banco de dados
* H2 

### Justificativa

#### Java 11

Ultima versão LTS do Java lançada, garantindo segurança e performance para a aplicação, inferencia de tipos e outros recursos característicos dessa versão como melhor suporte a containers.

## Instruções para Devs :)

```bash

#Download do projeto
git clone https://github.com/lucasmancan/micronaut-cvc-bank-api.git

cd /micronaut-cvc-bank-api

#Rodando os testes
./mvnw test

# Gerando o arquivo executável 
./mvnw package

# Iniciando a aplicação
java -jar target/micronaut-cvc-bank-api-0.0.1.jar

```

### Ou Docker

```bash

#Download do projeto
git clone https://github.com/lucasmancan/micronaut-cvc-bank-api.git

cd /micronaut-cvc-bank-api

# Criando a imagem
docker build -t lucasmancan/micronaut-cvc-bank-api .

#Iniciando o container
docker run -d -p 8080:8080 lucasmancan/micronaut-cvc-bank-api:latest 

```

## Licença
[MIT](https://choosealicense.com/licenses/mit/)

## Autor
[Lucas Frederico Mançan](https://www.linkedin.com/in/lucasmancan/)



