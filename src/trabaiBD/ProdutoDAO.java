package trabaiBD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    public void adicionarProduto(String nome, BigDecimal preco, int categoriaId) throws SQLException {
        String sql = "INSERT INTO Produto (nome, preco, categoria_id) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setBigDecimal(2, preco);
            stmt.setInt(3, categoriaId);
            stmt.executeUpdate();
        }
    }

    public void atualizarProduto(int id, String nome, BigDecimal preco, int categoriaId) throws SQLException {
        String sql = "UPDATE Produto SET nome = ?, preco = ?, categoria_id = ? WHERE id = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setBigDecimal(2, preco);
            stmt.setInt(3, categoriaId);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void excluirProduto(int id) throws SQLException {
        String sql = "DELETE FROM Produto WHERE id = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void obterProduto(int id) throws SQLException {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Preço: " + rs.getBigDecimal("preco"));
                System.out.println("Categoria ID: " + rs.getInt("categoria_id"));
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public void listarProdutos() throws SQLException {
        String sql = "SELECT * FROM Produto";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Preço: " + rs.getBigDecimal("preco"));
                System.out.println("Categoria ID: " + rs.getInt("categoria_id"));
                System.out.println("------------");
            }
        }
    }
}
