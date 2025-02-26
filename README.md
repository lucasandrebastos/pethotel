# Documentação Inicial - Casa da Lauau

## Visão Geral
Pethotel é uma API para gestão de clientes e booking de serviços pet, como estadia e creche. O sistema permite cadastrar clientes, agendar serviços e gerenciar reservas de forma eficiente.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Data JPA** (para interação com banco de dados)
- **Spring Boot Web** (para exposição da API REST)
- **H2 Database** (banco de dados em memória para desenvolvimento e testes)
- **Lombok** (para reduzir boilerplate de código)
- **Spring Boot DevTools** (para desenvolvimento)
- **Spring Boot Test** (para testes automatizados)

## Como Rodar o Projeto
### Requisitos
- Java 21+
- Maven

### Passos
1. Clone o repositório:
   ```sh
   git clone https://github.com/lucasandrebastos/pethotel.git
   cd pethotel
   ```
2. Compile e rode a aplicação:
   ```sh
   mvn spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`

## Endpoints Iniciais
- `GET /reservations` - Lista todas as reservas
- `POST /reservations` - Cria uma nova reserva
- `GET /users` - Lista todos os clientes
- `POST /users` - Cadastra um novo cliente
- `GET /pets` - Lista todos os pets
- `POST /pets` - Cadastra um novo pet

---

# Documentação de Arquitetura - PetHotel

## Arquitetura do Sistema
A aplicação segue a arquitetura MVC (Model-View-Controller), embora seja uma API REST, então a "View" é substituída pela resposta JSON.

### Camadas do Sistema
1. **Controller**: Camada que expõe os endpoints REST.
2. **Service**: Camada de regras de negócio e processamento.
3. **Repository**: Camada de persistência utilizando Spring Data JPA.
4. **Model**: Representação das entidades do domínio (ex: Cliente, Reserva).

## Fluxo de Requisição
1. O cliente faz uma requisição HTTP para a API.
2. O Controller recebe a requisição e chama o Service.
3. O Service aplica regras de negócio e chama o Repository se necessário.
4. O Repository interage com o banco de dados e retorna os dados.
5. O Service processa os dados e retorna ao Controller.
6. O Controller responde ao cliente com um JSON formatado.

## Banco de Dados
Atualmente, a API utiliza **H2 Database** em memória para testes e desenvolvimento. Para produção, pode ser substituído por um banco relacional como PostgreSQL ou MySQL.

### Exemplo de Estrutura de Tabela (Reserva)
```sql
CREATE TABLE reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    service_type VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);
```

## Futuras Melhorias
- Implementar autenticação e autorização com JWT.
- Criar um sistema de notificações para os clientes.
- Melhorar a documentação com Swagger/OpenAPI.

---


