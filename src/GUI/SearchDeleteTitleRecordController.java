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
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class SearchDeleteTitleRecordController implements  Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        List temp = Main.getFacade().getTitleRecordsList();
        ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        
        TableColumn idCol = new TableColumn("ID");
        TableColumn titleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        TableColumn castCol = new TableColumn("Cast");
        TableColumn genreCol = new TableColumn("Genre");

        
        idCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("id")
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
        
        TitleRecordTable.setItems(list);
        TitleRecordTable.getColumns().addAll(titleCol,authorCol, idCol ,  castCol,genreCol);
       
    }
    @FXML
    private TableView<String[]> TitleRecordTable;

  
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    

    @FXML
    void deleteButton(ActionEvent event) {
            int selIndex = TitleRecordTable.getSelectionModel().getSelectedIndex();
            Main.getFacade().deleteTitleRecord(Main.getFacade().transformTitleRecordIndexToString(selIndex));
            
                    List temp = Main.getFacade().getTitleRecordsList();
            ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        TitleRecordTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }    
    
}
