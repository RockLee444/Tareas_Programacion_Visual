/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptadorpalabras;

import java.util.Base64;
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
public class EncriptadorPalabras extends Application {
    
    //Toda la estructura de los componentes
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,400,400);
        
        Label etiqueta = new Label("Palabra");
        grid.add(etiqueta, 0, 1);
        
        Label resultado = new Label();
        grid.add(resultado,0,3);
        
        
        TextField palabra = new TextField();
        grid.add(palabra, 1, 1);
        
        Button encriptar = new Button();
        encriptar.setText("Encriptar");
        encriptar.setAlignment(Pos.BOTTOM_LEFT);
        encriptar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    //Encriptar la palabra
                    byte[] palabraIngresada = palabra.getText().getBytes();
                    String palabraEncriptada = Base64.getEncoder().encodeToString(palabraIngresada);
                    palabra.setText(palabraEncriptada);
                   
                }
                catch(Exception e){
                    System.out.println("Hubo un error.");
                }                
            }
        });
        
        Button desencriptar = new Button();
        desencriptar.setText("Desencriptar");
        desencriptar.setAlignment(Pos.BOTTOM_LEFT);
        desencriptar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    //Encriptar la palabra
                    byte[] palabraIngresada = palabra.getText().getBytes();
                    byte[] palabraDesencriptada = Base64.getDecoder().decode(palabraIngresada);
                    String palabraFinal = new String(palabraDesencriptada);
                    palabra.setText(palabraFinal);
                    
                }
                catch(Exception e){
                    System.out.println("Hubo un error.");
                }                
            }
        });
        
        
        grid.add(encriptar,1,2);
        grid.add(desencriptar,1,3);
        
        
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Desencriptador de palabras");
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
