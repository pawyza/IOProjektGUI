package GUI;

import Model.ClientM;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

public class SearchDeleteClients implements  Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       // List temp = Main.getFacade().getClientList();
        List<String[]> helper = Main.getFacade().getClientStrings();
        List<ClientM> listHelper = new ArrayList();
        for (String[] t : helper) {
            listHelper.add(new ClientM(t[0],t[1],Integer.valueOf(t[2]),t[3]));
        }
        
        ObservableList<ClientM> list = FXCollections.observableArrayList(listHelper);
     
        ClientsTable.setItems(list);

        TableColumn ncCol = new TableColumn("Number Card");
        TableColumn loginCol = new TableColumn("Login");
        TableColumn numberCol = new TableColumn("Number");
     
        
        ncCol.prefWidthProperty().bind(ClientsTable.widthProperty().multiply(0.50));
        loginCol.prefWidthProperty().bind(ClientsTable.widthProperty().multiply(0.25));
        numberCol.prefWidthProperty().bind(ClientsTable.widthProperty().multiply(0.25));
      
        
        ncCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("numberCard")
        );
        loginCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("login")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("number")
        );
       
        

        ClientsTable.getColumns().addAll(numberCol,loginCol, ncCol);
    }
    @FXML
    private TableView<ClientM> ClientsTable;

  
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    

    @FXML
    void deleteButton(ActionEvent event) {
            int selIndex = ClientsTable.getSelectionModel().getSelectedIndex();
            Main.getFacade().deleteClient(Main.getFacade().transformClientIndexToNumber(selIndex));
           
            List<String[]> helper = Main.getFacade().getClientStrings();
            List<ClientM> listHelper = new ArrayList();
        
            for (String[] t : helper) {
                listHelper.add(new ClientM(t[0],t[1],Integer.valueOf(t[2]),t[3]));
            }
            ObservableList<ClientM> list = FXCollections.observableArrayList(listHelper);
            ClientsTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }

    

}
