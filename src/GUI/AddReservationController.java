package GUI;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.TitleRecord;



public class AddReservationController implements Initializable {

    private JFXComboBox<TitleRecord> comboBox_Record;

    private JFXComboBox<Client> comboBox_Client;

    @FXML
    private JFXDatePicker datePicker_Begin;

    @FXML
    private JFXDatePicker datePicker_End;
    private String datestringBegin;
    private String datestringEnd;
    @FXML
    private JFXTextField edit_ScreeningRoomID;
    @FXML
    private JFXTextField edit_Price;


    @FXML
    void btn_OK_OnAction(ActionEvent event) {
        
        OptionsController.recordStage.close();
        //TODO METODA TOSTRING_()
        //Main.getFacade().addReservation(comboBox_Record.getValue().toString_(),comboBox_Client.getValue().toString_(), datePicker_Begin.getValue());
    }

    @FXML
    void btn_Return_OnAction(ActionEvent event) {
        OptionsController.recordStage.close();
    }

    @FXML
    void datePicker_Begin_OnAction(ActionEvent event) {
        if(datePicker_Begin.getValue().isAfter(LocalDate.now())) {
            datestringBegin = datePicker_Begin.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        System.out.println(datestringBegin);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List temp = Main.getFacade().getClients();
        ObservableList observableArrayList = FXCollections.observableArrayList(temp);
       comboBox_Client.setItems(observableArrayList);
        temp = Main.getFacade().getTitleRecords();
        observableArrayList = FXCollections.observableArrayList(temp);
        comboBox_Record.setItems(observableArrayList);
    }

    @FXML
    private void datePicker_End_OnAction(ActionEvent event) {
        if(datePicker_End.getValue().isAfter(datePicker_Begin.getValue())){
            datestringEnd = datePicker_End.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
         System.out.println(datestringEnd);
    }



}
