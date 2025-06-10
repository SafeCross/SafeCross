# SafeCross API

API para gerenciamento de semáforos modelados, áreas afetadas, logs de sincronização, visualização computacional, notificações e usuários, desenvolvida para o projeto SafeCross.

## Integrantes

- **Caíque Walter Silva** - RM550693
- **Guilherme Nobre Bernardo** - RM98604
- **Matheus José de Lima Costa** - RM551157

## Requisitos

- **Java 17**
- **Maven**
- **Docker** (para executar o banco MySQL)

## Configuração do Banco de Dados

Antes de iniciar a aplicação, suba o banco de dados MySQL utilizando Docker:

```bash
docker run --name safecross-mysql -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=safecross -p 3306:3306 -d mysql:8.0
```

Isso irá criar um container do MySQL 8.0, com o banco `safecross` e senha do root `123`.

## Instruções para Rodar a Aplicação

1. **Clone o repositório**
2. **Configure o arquivo `application.properties`** com as informações de conexão ao banco (host: `localhost`, porta: `3306`, banco: `safecross`, usuário: `root`, senha: `123`).
3. **Compile e rode a aplicação:**
    ```bash
    mvn clean package
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

A documentação interativa (Swagger UI) estará disponível em:

```
http://localhost:8080/swagger-ui.html
```
ou
```
http://localhost:8080/swagger-ui/index.html
```



