/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author 2y
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem openItem;

    @FXML
    private MenuItem newItem;

    @FXML
    private MenuItem saveItem;

    @FXML
    private MenuItem exit;

    @FXML
    private Menu editMenu;

    @FXML
    private MenuItem copy;

    @FXML
    private MenuItem cut;

    @FXML
    private MenuItem paste;

    @FXML
    private MenuItem selectA;

    @FXML
    private MenuItem delete;

    @FXML
    private Menu helpMenu;

    @FXML
    private MenuItem aboutItem;
    
    
    @FXML
    void open(ActionEvent event) {

    }

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
