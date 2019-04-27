package GUI;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.TitleRecord;



public class AddReservationController implements Initializable {
     ///static Facade f = OptionsController.f; 

     @FXML
    private JFXComboBox<TitleRecord> comboBox_Record;

    @FXML
    private JFXComboBox<Client> comboBox_Client;

    @FXML
    private JFXDatePicker datePicker_Begin;

    @FXML
    private JFXDatePicker datePicker_End;
    private String datestringBegin;
    private String datestringEnd;


    @FXML
    void btn_OK_OnAction(ActionEvent event) {
        
        OptionsController.recordStage.close();
        //TODO METODA TOSTRING_()
        //f.addReservation(comboBox_Record.getValue().toString_(),comboBox_Client.getValue().toString_(), datePicker_Begin.getValue());
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
        ObservableList temp = (ObservableList)OptionsController.getF().getClients();
     
       comboBox_Client.setItems(temp);
        temp = (ObservableList)OptionsController.getF().getTitleRecords();
        comboBox_Record.setItems(temp);
    }



}
