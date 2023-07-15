# DigiSytem.

Systema proposto como desafio DigiSytem.

#### Mais detalhes podem ser obtidos através da implementação do Swagger http://localhost:8080/swagger-ui.html


### Acesso aos endpoints

```
POST /api/v1/pessoas HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
"nome":"James TESTE",
"idade":55,
"salario": 1000.00
}

```

```
PUT /api/v1/pessoas/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
"nome":"James TESTE",
"idade":55,
"salario": 1000.00
}
```





```
GET /api/v1/pessoas/1  HTTP/1.1
Host: localhost:8080
Content-Type: application/json
```

#### Parâmetros não obrigatórios

```
GET /api/v1/pessoas?salary=1000&name=James Gosling HTTP/1.1
Host: localhost:8080
Content-Type: application/json
```


## Autor

* **Lucas Frederico Mançan** - (lucasfmancan@gmail.com)


