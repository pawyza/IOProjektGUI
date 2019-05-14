package GUI;

import com.jfoenix.controls.JFXButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import subbusinesstier.entities.Client;

public class SearchDeleteClients implements  Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List temp = Main.getFacade().getClientList();

        ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        ClientsTable.setItems(list);

        TableColumn ncCol = new TableColumn("Number Card");
        TableColumn loginCol = new TableColumn("Login");
        TableColumn numberCol = new TableColumn("Number");
        TableColumn passwordCol = new TableColumn("Password");

        ncCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("numberCard")
        );
        loginCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("login")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("number")
        );
        passwordCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("password")
        );
        

        ClientsTable.getColumns().addAll(ncCol , loginCol, numberCol,passwordCol);
    }
    @FXML
    private TableView<String[]> ClientsTable;

  
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    

    @FXML
    void deleteButton(ActionEvent event) {
            int selIndex = ClientsTable.getSelectionModel().getSelectedIndex();
            Main.getFacade().deleteClient(Main.getFacade().transformClientIndexToNumber(selIndex));
            
                    List temp = Main.getFacade().getClientList();
            ObservableList<String[]> list = FXCollections.observableArrayList(temp);
        ClientsTable.setItems(list);
    }
    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }

    

}
