/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Luis Matuz
 */
public class Factorial extends Application {
    
    //Toda la estructura de los componentes
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,400,400);
        
        Label etiqueta = new Label("Número");
        grid.add(etiqueta, 0, 1);
        
        Label resultado = new Label();
        grid.add(resultado,0,3);
        
        
        TextField numero = new TextField();
        grid.add(numero, 1, 1);
        
        Button factorial = new Button();
        factorial.setText("Calcular factorial");
        factorial.setAlignment(Pos.BOTTOM_LEFT);
        factorial.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String obtener = numero.getText();
                    int aux = java.lang.Integer.parseInt(obtener);
                    if(aux>0){
                        double factorial=1;
                            for(int i=aux;i>=1;i--){
                                factorial*=i;
                            }
                            resultado.setText("Resultado: " + factorial);
                    }
                    else {
                        System.out.println("Error, numero negativo.");
                    }
                    
                }
                catch(Exception e){
                    System.out.println("Hubo un error.");
                }                
            }
        });
        grid.add(factorial,1,2);
        
        
        
        /*
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(etiqueta);
        */
        
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
