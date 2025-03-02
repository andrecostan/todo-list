# 📝 To-Do List API

🚀 API RESTful para gerenciamento de tarefas do seminário da Especialização em Engenharia de Software com DevOps na disciplina Big Data

---

## 📌 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data Cassandra** (para integração com ScyllaDB)
- **Docker & Docker Compose**
- **Swagger UI** para documentação
- **Lombok** para simplificação do código

---

## 🚀 Como Executar o Projeto

### 📌 1️⃣ Clonar o Repositório

```sh
# Clonar o projeto
git clone https://github.com/andrecostan/todo-list.git

# Acessar a pasta do projeto
cd todo-list
```

### 📌 2️⃣ Subir o Banco de Dados (ScyllaDB)

O banco de dados **ScyllaDB** roda via **Docker Compose**.

```sh
# Subir o banco de dados
docker-compose up -d

# Parar o banco de dados
docker-compose down -v
```

✅ **Verificar se o banco está rodando corretamente:**

```sh
docker ps | grep scylla
```

### 📌 3️⃣ Configurar o Banco no ScyllaDB

Caso seja necessário, acesse o banco manualmente para verificar as tabelas:

```sh
docker exec -it scylla cqlsh

# Listar os keyspaces disponíveis
describe keyspaces;

# Selecionar o keyspace correto
USE todolist;

# Listar tabelas
describe tables;
```

Se o keyspace **não existir**, crie manualmente:

```cql
CREATE KEYSPACE IF NOT EXISTS todolist
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}
AND TABLETS = {'enabled': false};
```

### 📌 4️⃣ Configurar e Rodar a Aplicação

Certifique-se de ter o **Java 17** e o **Maven** instalados.

```sh
# Instalar dependências do Maven
./mvnw clean install

# Rodar a aplicação
./mvnw spring-boot:run
```

✅ **Se tudo estiver certo, a API estará rodando em:**\
📌 [`http://localhost:8080`](http://localhost:8080)

---

## 🔥 Testando a API no Swagger

A documentação interativa da API está disponível via **Swagger UI**:

📌 **Acesse o Swagger:**\
👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

📌 **Obter JSON da API OpenAPI:**\
👉 [`http://localhost:8080/v3/api-docs`](http://localhost:8080/v3/api-docs)

### **🔹 Endpoints Disponíveis**

| Método   | Endpoint      | Descrição                   |
| -------- | ------------- | --------------------------- |
| `GET`    | `/tasks`      | Lista todas as tarefas      |
| `GET`    | `/tasks/{id}` | Busca uma tarefa por ID     |
| `POST`   | `/tasks`      | Cria uma nova tarefa        |
| `PUT`    | `/tasks/{id}` | Atualiza uma tarefa pelo ID |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa pelo ID   |

---

## 📦 **Importar no Postman**

Caso queira testar via **Postman**, siga estes passos:

1. **Acesse:** `File > Import`
2. **Cole a URL:** `http://localhost:8080/v3/api-docs`
3. O Postman criará automaticamente os endpoints da API!

---

## 🛠 Possíveis Problemas e Soluções

🔴 **Erro: "Connection Refused" ao conectar no ScyllaDB**\
✅ **Solução:** O banco pode estar demorando para iniciar. Aguarde alguns segundos e tente novamente.

🔴 **Erro: "Invalid Keyspace" ao rodar o Spring Boot**\
✅ **Solução:** Verifique se o **keyspace ****`todolist`**** existe** no ScyllaDB com:

```sh
docker exec -it scylla cqlsh -e "DESCRIBE KEYSPACES;"
```

Se não existir, crie manualmente conforme explicado na seção **Configurar o Banco**.

🔴 **Erro: "Swagger não abre"**\
✅ **Solução:** A API pode não estar rodando. Certifique-se de que o **Spring Boot está em execução**:

```sh
./mvnw spring-boot:run
```

E acesse: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 📜 Licença

Este projeto está licenciado sob a licença **Apache 2.0**. Veja mais detalhes em [`LICENSE`](LICENSE).

---

## 📞 Contato

👨‍💻 **Desenvolvedor:** André Costa\
🔗 **GitHub:** [andrecostan](https://github.com/andrecostan)

Se gostou do projeto, deixe uma ⭐ no repositório!

---

🚀 **Agora é só rodar e testar!** Qualquer dúvida, me avise! 😃🔥

