/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.ReservationM;
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

/**
 * FXML Controller class
 *
 * @author Kuba
 */
public class SearchDeleteReservationController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<String[]> helper = Main.getFacade().getReservationStrings();
        List<ReservationM> listHelper = new ArrayList();
        for (String[] t : helper) {
            listHelper.add(new ReservationM(t[0], t[1], t[2], t[3], t[4], t[5]));
        }
        ObservableList<ReservationM> list = FXCollections.observableArrayList(listHelper);

        TableColumn idCol = new TableColumn("Client ID");
        TableColumn numberCol = new TableColumn("Number");
        TableColumn dateStartCol = new TableColumn("Date start");
        TableColumn dateEndCol = new TableColumn("Date end");
        TableColumn recordIDCol = new TableColumn("Record ID");
        TableColumn titleCol = new TableColumn("Title");

        idCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("clientID")
        );

        dateStartCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("dateStart")
        );
        dateEndCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("dateEnd")
        );
        recordIDCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("recordID")
        );
        titleCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("title")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("numberID"));

        
        idCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.10));
        numberCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.10));
        dateStartCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.20));
        dateEndCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.20));
        titleCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.20));
        recordIDCol.prefWidthProperty().bind(ReservationTable.widthProperty().multiply(0.2));
        
        ReservationTable.getColumns().addAll(idCol, numberCol, titleCol, dateStartCol, dateEndCol, recordIDCol);
        ReservationTable.setItems(list);
    }
    @FXML
    private TableView<ReservationM> ReservationTable;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    @FXML
    void deleteButton(ActionEvent event) {
        int selIndex = ReservationTable.getSelectionModel().getSelectedIndex();
        Main.getFacade().deleteReservation(Main.getFacade().transformReservationIndexToNumber(selIndex));

        List<String[]> helper = Main.getFacade().getReservationStrings();
        List<ReservationM> listHelper = new ArrayList();
        for (String[] t : helper) {
            listHelper.add(new ReservationM(t[0], t[1], t[2], t[3], t[4], t[5]));
        }
        ObservableList<ReservationM> list = FXCollections.observableArrayList(listHelper);
        ReservationTable.setItems(list);
    }

    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }

}
