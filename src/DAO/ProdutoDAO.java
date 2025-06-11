package DAO;

import model.Produto;
import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    private final String url = "jdbc:mysql://localhost:3306/meu_banco";
    private final String user = "leticia";
    private final String password = "Crazyhair1*";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserir(Produto p) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";
                try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, p.getNome());
                    stmt.setDouble(2, p.getPreco());
                    stmt.setInt(3, p.getQuantidade());
                    stmt.executeUpdate();
                }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ?, WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

// url, user, password = referentes ao endereço do banco MYSQL local, usuário criado pela pessoa, senha do usuário
// metodo conectar: abre uma conexao com o banco de dados usando os dados definidos acima, toda operacao do repositorio vai chamar esse metodo
// metodo inserir produto: insere um novo produto no banco; usa PreparedStatement para evitar SQL Injection (tecnica maliciosa onde o invasor insere comandos no SQL
// malformados em campos de entrada (como formularios) para: ler dados confidenciais, apagar ou ler tabelas, quebrar a seguranca do sistema
// metodo listar: executa um select * from produtos (leitura: seleciona tudo da tabela produtos), para cada linha da tabela: cria um novo objeto Produto, preenche os dados,
// adiciona o produto a lista
// metodo atualizar produto: atualiza um produto já existente no banco com base no id
// metodo excluir: deleta o produto da tabela com base no id
// stmt: instancia de PreparedStatement ou Statement, ele é responsável por executar comandos do SQL no banco de dados
