package trabaiBD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainApp extends Application {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        
        try {
            produtoDAO.listarProdutos();
        } catch (SQLException e) {
            e.printStackTrace();
            textArea.setText("Erro ao carregar produtos.");
        }

        VBox vbox = new VBox(textArea);
        Scene scene = new Scene(vbox, 800, 600);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lista de Produtos");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}