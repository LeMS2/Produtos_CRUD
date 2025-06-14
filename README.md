CRUD de Produtos - Java Desktop (Swing + MySQL)

Este projeto é um sistema simples de cadastro de produtos desenvolvido com **Java Desktop (Swing)** e **MySQL**, seguindo o padrão **CRUD**:

- **C**: Criar produtos
- **R**: Ler/listar produtos
- **U**: Atualizar produtos
- **D**: Deletar produtos

---------------------------------------------------

📌 Funcionalidades

- Cadastro de produtos com **nome**, **preço** e **quantidade**
- Exibição de todos os produtos cadastrados
- Edição de produtos por **ID**
- Exclusão de produtos por **ID**
- Interface gráfica amigável feita com **Swing**
- Armazenamento e persistência com **MySQL**

----------------------------------------------------

🧩 Tecnologias utilizadas

- **Java 17+**
- **Swing** (interface gráfica)
- **JDBC** (conexão com o banco)
- **MySQL** (banco de dados relacional)
- **DBeaver** ou **phpMyAdmin** (administração do banco)

----------------------------------------------------

💾 Estrutura do Projeto

projeto/
├── model/ # Classe Produto.java
├── DAO/ # Classe ProdutoDAO.java
├── view/ # Interface gráfica (TelaPrincipal.java)
├── Main.java # Classe principal
├── README.md # Este arquivo
└── .gitignore # Arquivos ignorados pelo Git

----------------------------------------------------

📦 Banco de Dados (MySQL)

Script para criar o banco e tabela:

```sql
CREATE DATABASE IF NOT EXISTS meu_banco;
USE meu_banco;

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);

-----------------------------------------------------

⚙️ Como executar o projeto

1) Clone o repositório:

git clone https://github.com/SEU_USUARIO/Produtos_CRUD.git

2) Abra o projeto no IntelliJ IDEA

3) Configure o driver JDBC do MySQL:

 - mysql:mysql-connector-java:8.0.33

4) Ajuste os dados de conexão no arquivo RepositorioProduto.java:

	private final String url = "jdbc:mysql://localhost:3306/meu_banco";
	private final String user = "seu_usuario";
	private final String password = "sua_senha";

5) Execute a classe Main.java para iniciar o sistema.

🧪 Testes

- Use os botões Salvar, Editar, Excluir e Listar

- Insira ou altere produtos

- Veja os dados aparecerem na área de texto

👨‍💻 Autoria

Projeto desenvolvido por:

24039432-2 - Danilo Vaz
24329420-2 - Letícia Marques
24503197-2 - Lilian Beatriz
24341596-2 - Marina Zentil
24047506-2 -Thiago Rodrigo

Curso: Análise e Desenvolvimento de Sistemas - UniCesumar

Matéria: Análise e Projeto Orientado a Objetos

Professor: José Carlos Domingues Flores

📅 Prazo de entrega

16 de junho de 2025
