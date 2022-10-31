/*
 * -Creator: Rafae Khan
 *
 *-Language Used: Java + JavaFX
 *
 *-Program Name: Bank ATM Transactional System Mockup
 *
 *-Program Description: This program demonstrates an ATM with a full transactional system. UI was created using JavaFX
 */
package Bank;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
    
    public class Main extends Application {
     
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("AccountFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Account");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
    launch(args);
  }
    
}
