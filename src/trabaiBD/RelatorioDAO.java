package trabaiBD;
public class RelatorioDAO {
    public void calcularMediaPrecoPorCategoria() throws SQLException {
        String sql = "SELECT c.nome AS categoria, AVG(p.preco) AS mediaPreco " +
                     "FROM Produto p JOIN Categoria c ON p.categoria_id = c.id " +
                     "GROUP BY c.nome";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Categoria: " + rs.getString("categoria"));
                System.out.println("Média de Preço: " + rs.getBigDecimal("mediaPreco"));
                System.out.println("------------");
            }
        }
    }

    public void listarVendasComItens() throws SQLException {
        String sql = "SELECT v.id AS vendaId, v.data, c.nome AS clienteNome, p.nome AS produtoNome, iv.quantidade, iv.preco " +
                     "FROM Venda v " +
                     "JOIN Cliente c ON v.cliente_id = c.id " +
                     "JOIN ItemVenda iv ON v.id = iv.venda_id " +
                     "JOIN Produto p ON iv.produto_id = p.id";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Venda ID: " + rs.getInt("vendaId"));
                System.out.println("Data: " + rs.getDate("data"));
                System.out.println("Cliente: " + rs.getString("clienteNome"));
                System.out.println("Produto: " + rs.getString("produtoNome"));
                System.out.println("Quantidade: " + rs.getInt("quantidade"));
                System.out.println("Preço: " + rs.getBigDecimal("preco"));
                System.out.println("------------");
            }
        }
    }
}
