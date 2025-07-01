# SafeCross

SafeCross é um aplicativo mobile desenvolvido em React Native com Expo, focado em segurança viária e acessibilidade urbana. Ele permite registrar áreas afetadas, visualizar notificações, acessar câmeras, consultar histórico de ações e muito mais.

# Desenvolvido por 

 - [Caíque Walter - RM550693](https://github.com/devCaiqueWS)
 - [Guilherme Nobre Bernardo - RM98604](https://github.com/GN0Ber)
  - [Matheus José de Lima Costa - RM551157](https://github.com/MatheusCosta616)

## Índice

- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Como rodar o projeto](#como-rodar-o-projeto)
  - [Pré-requisitos](#pré-requisitos)
  - [Clonando o projeto](#clonando-o-projeto)
  - [Configurando o banco de dados com Docker](#configurando-o-banco-de-dados-com-docker)
  - [Rodando a API Java](#rodando-a-api-java)
  - [Rodando o app mobile](#rodando-o-app-mobile)
- [Referências](#referências)

---

## Funcionalidades

### 1. **Login e Cadastro**
- **Tela de Login:** Permite autenticação do usuário.
- **Tela de Cadastro:** Criação de nova conta, incluindo nome, email, senha e ID do dispositivo.

### 2. **Home**
- **Busca de Rotas:** Inputs para partida e destino.
- **Acesso rápido:** Botões para registrar área, acessar câmera, histórico, perfil e semáforo.

### 3. **Registrar Área Afetada**
- Usa a localização atual do usuário para registrar áreas com problemas (ex: buracos, sinalização ruim).
- Exibe registros já existentes na localização.
- Envia os dados para a API, marcando como "pendente" para validação.

### 4. **Notificações**
- Lista notificações recebidas pelo usuário, agrupadas por tipo (alerta, informativo, aviso).
- Permite limpar todas as notificações.

### 5. **Perfil**
- Exibe dados do usuário (nome, email, dispositivo).
- Permite editar informações do perfil.
- Logout.

### 6. **Histórico**
- Lista ações realizadas pelo usuário, como áreas registradas, visualizações de câmera e sincronizações.

### 7. **Câmera**
- Demonstração de acesso à câmera (pode ser expandido para gravação ou foto).

### 8. **Semáforo em Tempo Real**
- Simulação visual de um semáforo, alternando entre vermelho, verde e amarelo.

---

## Arquitetura

- **Frontend:** React Native (Expo)
- **Backend:** [API Java Spring Boot - safeCross-api](https://github.com/MatheusCosta616/safe-cross-api)
- **Banco de Dados:** MySQL (Docker)

---

## Como rodar o projeto

### Pré-requisitos

- [Node.js](https://nodejs.org/)
- [Expo CLI](https://docs.expo.dev/get-started/installation/)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [Java 17+](https://adoptium.net/) (para rodar a API)

### Clonando o projeto

```sh
git clone https://github.com/devCaiqueWS/SafeCrossAPP.git
cd SafeCrossAPP
```

### Configurando o banco de dados com Docker

1. Crie um arquivo `docker-compose.yml` na raiz do projeto (ou use o exemplo abaixo):

```yaml
version: '3.1'
services:
  db:
    image: mysql:8.0
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: safecross
      MYSQL_USER: safecross
      MYSQL_PASSWORD: safecross
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql
volumes:
  db_data:
```

2. Suba o banco de dados:

```sh
docker-compose up -d
```

3. O banco estará disponível em `localhost:3306` com:
   - **Database:** safecross
   - **User:** safecross
   - **Password:** safecross

### Rodando a API Java

1. Clone o repositório da API:

```sh
git clone https://github.com/seu-usuario/safeCross-api.git
cd safeCross-api
```

2. Configure o arquivo `application.properties` para apontar para o banco Docker:

```
spring.datasource.url=jdbc:mysql://localhost:3306/safecross
spring.datasource.username=safecross
spring.datasource.password=safecross
```

3. Rode a API:

```sh
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8082`.

### Rodando o app mobile

1. Instale as dependências:

```sh
npm install
```

2. Inicie o projeto Expo:

```sh
npm start
```

3. Use o app Expo Go no seu celular ou um emulador para rodar o app.

---

## Referências

- **Frontend:** [safeCross-app (este repositório)](https://github.com/devCaiqueWS/SafeCrossAPP)
- **Backend:** [safeCross-api (Java Spring Boot)](https://github.com/MatheusCosta616/safe-cross-api)

---

## Observações

- Certifique-se de que a API e o banco estejam rodando antes de iniciar o app.
- Para Android emulador, o app já usa `10.0.2.2` para acessar o backend local.
- Para produção, ajuste as URLs no código conforme necessário.

---

