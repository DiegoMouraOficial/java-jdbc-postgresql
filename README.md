

<img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>

<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge"/>


# Projeto JDBC CRUD Básico com PostgreSQL

Este é um projeto Java simples que demonstra como criar um CRUD básico (Create, Read, Update, Delete) usando JDBC (Java Database Connectivity) com o banco de dados PostgreSQL. O projeto inclui um modelo `User` e um DAO `UserDAO` para interagir com o banco de dados.

## Funcionalidades

- Adiciona um novo usuário ao banco de dados (addUser)
- Busca um usuário pelo ID (getUserById)
- Atualiza um usuário existente no banco de dados (updateUser)
- Deleta um usuário pelo ID (deleteUser)
- Lista todos os usuários do banco de dados (getAllUsers)

## Pré-requisitos

- Java JDK instalado
- PostgreSQL
- Driver JDBC PostgreSQL (geralmente `postgresql`)

## 🛠️ Estrutura do Projeto

- `User.java`: Classe modelo que representa um usuário com ID, nome e email.
- `UserDAO.java`: Classe DAO que contém métodos para manipular dados de usuários no banco de dados.
- `ConnectionUtil.java`: Classe utilitária para obter a conexão com o banco de dados.

## Configuração do Banco de Dados

1. Instale o PostgreSQL e crie um banco de dados.

2. Crie uma tabela `users` com a seguinte estrutura:

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);

```

<h2> 🤝 Contribuindo </h2>

<p>
Este repositório foi criado para fins de estudo. Fique a vontade para contribuir!
    
Se te ajudei de alguma forma, ficarei feliz em saber. 😜
    
Caso você conheça alguém que se identifique com esse conteúdo, não deixe de compartilhar.
</br></br>

> <h4>Se possível:</h4>

- ⭐️ Dê Star para o projeto
- 🐛 Encontrar e relatar issues
</p>

---

Disponibilizado 😜 por [Diego Moura dos Santos](https://www.linkedin.com/in/diegomouradossantos/).
