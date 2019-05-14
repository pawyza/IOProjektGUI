/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kuba
 */
public class SearchDeleteRecordController implements Initializable {

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        List temp = Main.getFacade().getRecordsModel();
        System.out.println(temp.get(0));
        ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        RecordTable.setItems(list);

        TableColumn idCol = new TableColumn("ID");
        TableColumn idTRCol = new TableColumn("ID TitleRecord");
        TableColumn titleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        TableColumn castCol = new TableColumn("Cast");
        TableColumn genreCol = new TableColumn("Genre");


        idCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("id")
        );
         idTRCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("id TitleRecord")
        );
        titleCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("title")
        );
        authorCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("author")
        );
        castCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("cast")
        );
        genreCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("genre")
        );
        

        RecordTable.getColumns().addAll(titleCol,authorCol, idCol ,idTRCol,  castCol,genreCol);
    }
    @FXML
    private TableView<String[]> RecordTable;

  
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    

    @FXML
    void deleteButton(ActionEvent event) {
            int selIndex = RecordTable.getSelectionModel().getSelectedIndex();
          
           Main.getFacade().deleteRecord(selIndex);// usuwanie record
            
                    List temp = Main.getFacade().getTitleRecords();
            ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        RecordTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }    
    
}
