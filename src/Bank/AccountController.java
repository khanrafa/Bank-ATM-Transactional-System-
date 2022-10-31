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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author jrbro
 */
public class AccountController implements Initializable {
public PrintWriter fileOut;
@FXML
private Label accResult,serResult;
@FXML
private ListView<String> lstService;
@FXML
private ComboBox<Account> accountType;
@FXML
private TextField txt1,txt2,txt3;
@FXML
private Button btn1,btn2,btn3;
 Account userAccount1 = new Account();
 Account userAccount2 = new Account();
 Account userAccount3 = new Account();

 @FXML
 private void save(ActionEvent event) throws FileNotFoundException {
        fileOut.println("Test");
    }

    @FXML
    private void exit(ActionEvent event) {
        fileOut.close();
        Stage stage = (Stage) btn2.getScene().getWindow();
        stage.close();
    }
   
        
         
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            fileOut = new PrintWriter("Assignment5.dat");
        } catch (FileNotFoundException ex) {
        }
       
        userAccount1.setId("c-500");
         userAccount1.setBalance(1000);
         userAccount1.setInterestRate(2.5); 
         userAccount2.setId("c-700");
         userAccount2.setBalance(2000);
         userAccount2.setInterestRate(3.5);
         userAccount3.setId("c-900");
         userAccount3.setBalance(3000);
         userAccount3.setInterestRate(4.5);
        Account[] strAccounts = {userAccount1, userAccount2, userAccount3};
        String[] strServices = {"Deposit", "Withdraw"};
        ObservableList obsAccounts = FXCollections.observableArrayList(strAccounts);
        ObservableList obsServices = FXCollections.observableArrayList(strServices);      
        lstService.setItems(obsServices);
        accountType.setItems(obsAccounts);
        lstService.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {  
           
                
                double t1 = Double.parseDouble(txt1.getText());
                double currentBal = accountType.getSelectionModel().getSelectedItem().getBalance();
                
               
                int service = lstService.getSelectionModel().getSelectedIndex();
                
                if (service == 0) {
                    accountType.getSelectionModel().getSelectedItem().setBalance(currentBal + t1);
                }
                else if (service == 1) {
                    accountType.getSelectionModel().getSelectedItem().setBalance(currentBal - t1);
                }
                 Account[] strAccounts2 = {userAccount1, userAccount2, userAccount3};   
                 
     
                accResult.setText(accountType.getSelectionModel().getSelectedItem().toString());
                txt1.setText("0.0");
                txt2.setText(accountType.getSelectionModel().getSelectedItem().printBalance());
                txt3.setText(accountType.getSelectionModel().getSelectedItem().printInterest());
                   
            }
        });
          
          btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {  
                 fileOut.println(userAccount1.toString() + " " + lstService.getSelectionModel().getSelectedItem());
                 fileOut.println(userAccount2.toString() + " " + lstService.getSelectionModel().getSelectedItem());
                 fileOut.println(userAccount3.toString() + " " + lstService.getSelectionModel().getSelectedItem());
             }
        });
            
           
        
        
        
        lstService.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                serResult.setText(lstService.getSelectionModel().getSelectedItem());
                
            }
        });
        accountType.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                accResult.setText(accountType.getSelectionModel().getSelectedItem().toString());
                
                txt2.setText(accountType.getSelectionModel().getSelectedItem().printBalance());
                txt3.setText(accountType.getSelectionModel().getSelectedItem().printInterest());
                
            }
        });
        
        
        
         
    }    
    
}
