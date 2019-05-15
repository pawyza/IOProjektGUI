/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.RecordM;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
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

        
public class SearchDeleteRecordController implements Initializable {

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        List temp = Main.getFacade().getRecordsList();
        ObservableList<String[]> list = FXCollections.observableArrayList(temp);
*/
        List<String[]> helper = Main.getFacade().getRecordStrings();
        List<RecordM> listHelper = new ArrayList();
       
         for (String[] t : helper) {
             System.out.println(t[0]);
             System.out.println(t[1]);
            listHelper.add(new RecordM(t[0],t[1]));
        }
         ObservableList<RecordM> list = FXCollections.observableArrayList(listHelper);
        

        TableColumn titleRecordCol = new TableColumn("TitleRecord");
        TableColumn numberCol = new TableColumn("Number");
      
        numberCol.prefWidthProperty().bind(RecordTable.widthProperty().multiply(0.20));
        titleRecordCol.prefWidthProperty().bind(RecordTable.widthProperty().multiply(0.80));

        titleRecordCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("recordTitle")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("number")
        );
       
        
        RecordTable.setItems(list);
        RecordTable.getColumns().addAll(numberCol,titleRecordCol);
    }
    @FXML
    private TableView<RecordM> RecordTable;

  
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    

    @FXML
    void deleteButton(ActionEvent event) {
            int selIndex = RecordTable.getSelectionModel().getSelectedIndex();
          
           Main.getFacade().deleteRecord(Main.getFacade().transformRecordIndexToNumber(selIndex));
            
            List<String[]>helper =  Main.getFacade().getRecordStrings();
        List<RecordM> listHelper = new ArrayList();
        
         for (String[] t : helper) {
            listHelper.add(new RecordM(t[0],t[1]));
        }
         
        ObservableList<RecordM> list = FXCollections.observableArrayList(listHelper);
        RecordTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }    
    
}
