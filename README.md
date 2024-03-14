

<img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>

<img src="http://img.shields.io/static/v1?label=STATUS&message=%20FINALIZADO&color=critical&style=for-the-badge"/>


# Projeto JDBC - CRUD Gerenciador de Usuários

Este é um projeto de exemplo de um Gerenciador de Usuários, desenvolvido em Java com JDBC
para interagir com um banco de dados PostgreSQL ou qualquer SGDB.

## Funcionalidades
- Adicionar novo usuário no banco de dados
- Buscar usuário por ID no banco de dados
- Atualizar usuário existente no banco de dados por ID
- Deletar usuário no banco de dados por ID
- Listar todos usuários existentes no banco de dados

## Pré-requisitos
- Java 8 ou superior instalado
- PostgreSQL, MySql ou outro SGDB instalado e configurado

## Configurando a String de conexão

### PostgreSQL
Se estiver utilizando o PostgreSQL, você pode configurar a string de conexão da seguinte forma:
   ```sql
   private static final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
   private static final String USER = "username";
   private static final String PASSWORD = "password";
   ```
Substitua "nome_do_banco", "username" e "password" pelos valores correspondentes ao seu ambiente.

### MySQL
Para o MySQL, a string de conexão pode ser configurada assim:
```sql
private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
private static final String USER = "username";
private static final String PASSWORD = "password";
```
Assim como no exemplo anterior, substitua os valores conforme necessário.

### Oracle, SQL Server, H2, etc.
Para outros bancos de dados como Oracle, SQL Server, H2, entre outros, consulte a 
documentação correspondente para obter as instruções de configuração das strings 
de conexão.

## Configuração do Banco de Dados

Antes de executar a aplicação, certifique-se de criar o banco de dados e a tabela
necessária no PostgreSQL ou em outro SGDB. Você pode fazer isso executando os
seguintes scripts SQL:

```sql
CREATE DATABASE gerenciador_usuarios;
```
  
```sql
CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL
);
```

## Configuração da Aplicação
- Clone este repositório para o seu ambiente local.
- Importe o projeto em sua IDE de desenvolvimento Java.
- Certifique-se de ter as dependências JDBC do PostgreSQL configuradas em seu projeto.
- Verifique e ajuste as configurações de conexão com o banco de dados no arquivo ConnectionUtil.java.

## Executando a Aplicação

Para executar a aplicação, siga os passos abaixo:

1. Certifiuqe-se de ter o Java e o PostgreSQL instalados em sua máquina.
2. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/DiegoMouraOficial/java-jdbc-postgresql.git
   ````

3. Após clonar o repositório, vá até o package `app` e selecione a classe 
(AddUser, DeleteUse, GetAllUsers, GetByIdUser ou UpdateUser)o que deseja executar.

4. Você pode executar a aplicação a partir de sua IDE de desenvolvimento Java clicando em Run.

## 🛠️ Estrutura do Projeto
### package app
 - `AddUser`: Classe com o método para adicionar novo usuário no banco de dados.
 - `DeleteUser`: Classe com o método para deletar usuário no banco de dados por ID.
 - `GetAllUsers`: Classe com o método para listar todos usuários existentes no banco de dados.
 - `GetByIdUser`: Classe com o método para buscar usuário por ID no banco de dados.
 - `UpdateUser`: Classe com o método para atualizar usuário existente no banco de dados por ID.
### package: dao
 - `UserDAO.java`: Classe DAO que contém métodos para manipular dados de usuários no banco de dados.
### package: model
 - `User.java`: Classe modelo que representa um usuário com ID, nome e email.
### package: util
- `ConnectionUtil.java`: Classe utilitária para obter a conexão com o banco de dados.




<h2> 🤝 Contribuindo </h2>

<p>
Este repositório foi criado para fins de estudo. Fique a vontade para contribuir!
    
Se te ajudei de alguma forma, ficarei feliz em saber. 😜
    
Caso você conheça alguém que se identifique com esse conteúdo, não deixe de compartilhar.

Se deseja contribuir com este projeto, fique à vontade para abrir issues e pull requests no repositório do GitHub.
</br></br>

<h4>Se possível:</h4>

- ⭐️ Dê Star para o projeto
- 🐛 Encontrar e relatar issues
</p>

---

Disponibilizado 😜 por [Diego Moura dos Santos](https://www.linkedin.com/in/diegomouradossantos/).
