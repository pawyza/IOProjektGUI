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
        
        List temp = Main.getFacade().getRecordsList();
        System.out.println(temp.get(0));
        ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        System.out.println(list.get(0));

        TableColumn titleRecordCol = new TableColumn("TitleRecord");
        TableColumn numberCol = new TableColumn("Number");
      


        titleRecordCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("titleRecord")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("number")
        );
       
        
        RecordTable.setItems(list);
        RecordTable.getColumns().addAll(numberCol,titleRecordCol);
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
            
              List temp = Main.getFacade().getRecordsList();
            ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        RecordTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }    
    
}
