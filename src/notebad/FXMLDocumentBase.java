package notebad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem openItem;
    protected final MenuItem newItem;
    protected final MenuItem saveItem;
    protected final MenuItem exit;
    protected final Menu editMenu;
    protected final MenuItem copy;
    protected final MenuItem cut;
    protected final MenuItem paste;
    protected final MenuItem selectA;
    protected final MenuItem delete;
    protected final Menu helpMenu;
    protected final MenuItem aboutItem;
    protected final TextArea textArea;
    private Stage s;

    public FXMLDocumentBase( Stage stage) {
        s=stage;
        menuBar = new MenuBar();
        fileMenu = new Menu();
        openItem = new MenuItem();
        newItem = new MenuItem();
        saveItem = new MenuItem();
        exit = new MenuItem();
        editMenu = new Menu();
        copy = new MenuItem();
        cut = new MenuItem();
        paste = new MenuItem();
        selectA = new MenuItem();
        delete = new MenuItem();
        helpMenu = new Menu();
        aboutItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        openItem.setId("Open");
        openItem.setMnemonicParsing(false);
        openItem.setText("Open");
        openItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY));

        newItem.setId("New");
        newItem.setMnemonicParsing(false);
        newItem.setText("New");
        newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY));

        saveItem.setId("Save");
        saveItem.setMnemonicParsing(false);
        saveItem.setText("Save");
        saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY));

        exit.setMnemonicParsing(false);
        exit.setText("Exit");
        exit.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_ANY));

        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        copy.setMnemonicParsing(false);
        copy.setText("Copy");
        copy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY));

        cut.setMnemonicParsing(false);
        cut.setText("Cut");
        cut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY));

        paste.setMnemonicParsing(false);
        paste.setText("Paste");
        paste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY));

        selectA.setMnemonicParsing(false);
        selectA.setText("Select All");

        delete.setMnemonicParsing(false);
        delete.setText("Delete");

        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        aboutItem.setMnemonicParsing(false);
        aboutItem.setText("About");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        fileMenu.getItems().add(openItem);
        fileMenu.getItems().add(newItem);
        fileMenu.getItems().add(saveItem);
        fileMenu.getItems().add(exit);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(copy);
        editMenu.getItems().add(cut);
        editMenu.getItems().add(paste);
        editMenu.getItems().add(selectA);
        editMenu.getItems().add(delete);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(aboutItem);
        menuBar.getMenus().add(helpMenu);
        
        saveItem.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             FileChooser fc = new FileChooser();
             File f= fc.showSaveDialog(s);
             if(f!=null)
             {
                 try {
                     FileOutputStream fos = new FileOutputStream(f);
                      fos.write(textArea.getText().getBytes());
                      fos.flush();
                      fos.close();
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 //byte[] b = textArea.getText().getBytes();
               
               
             }
            
            }
        });
        
           openItem.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             FileChooser fc = new FileChooser();
             File f= fc.showOpenDialog(s);
             if(f!=null)
             {
                 try {
                       FileInputStream fis = new FileInputStream(f);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        textArea.setText(new String(b));
                        fis.close();
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 //byte[] b = textArea.getText().getBytes();
               
               
             }
            
            }
        });
        newItem.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            textArea.clear();
            }
        });
          exit.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
            }
        });
          
         copy.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               textArea.copy();
            }
        });  
          
         cut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               textArea.cut();
            }
        }); 
         
         paste.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               textArea.paste();
            }
        });
         
           selectA.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               textArea.selectAll();
            }
        });
         
           delete.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.deleteText(textArea.getSelection());
            }
        });
           
            aboutItem.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               Alert a= new Alert(AlertType.NONE);
               a.setAlertType(AlertType.INFORMATION);
               a.show();
            }
        });
    }
    
}
