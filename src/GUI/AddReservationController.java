package GUI;


import Model.ClientM;
import Model.TitleRecordM;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;




public class AddReservationController implements Initializable {
    @FXML
    private JFXComboBox<TitleRecordM> comboBox_Record;
    @FXML
    private JFXComboBox<ClientM> comboBox_Client;

    @FXML
    private JFXDatePicker datePicker_Begin;

    @FXML
    private JFXTextField numberOfReservation;
    @FXML
    private JFXDatePicker datePicker_End;
    private String datestringBegin;
    private String datestringEnd;
    private String[] titleRecordHelper;
    private String[] clientHelper;


    @FXML
    void btn_OK_OnAction(ActionEvent event) {
   
       
        OptionsController.recordStage.close();
        
        /*
        String recordStr = comboBox_Record.getValue().toString();
        recordStr=recordStr.replace("[","");
        recordStr=recordStr.replace("]","");
        String[] record = recordStr.split(",");
        String clientStr = comboBox_Client.getValue().toString();
        clientStr=clientStr.replace("[","");
        clientStr=clientStr.replace("]","");
        String[] client = clientStr.split(",");
        System.out.println(client);
        */
        
        Main.getFacade().addReservation(titleRecordHelper,clientHelper,Integer.parseInt(numberOfReservation.getText()),datePicker_Begin.getValue(),datePicker_End.getValue());
    }


    @FXML
    void btn_Return_OnAction(ActionEvent event) {
        OptionsController.recordStage.close();
    }

    @FXML
    void datePicker_Begin_OnAction(ActionEvent event) {
        if(datePicker_Begin.getValue().isAfter(LocalDate.now())) {
            datestringBegin = datePicker_Begin.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }else
            datePicker_Begin.setValue(LocalDate.now());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        
        List temp = Main.getFacade().getClientsModelString();
        ObservableList observableArrayList = FXCollections.observableArrayList(temp);
        
        
        List<String[]> helper = Main.getFacade().getClientStrings();
        List<ClientM> listHelper = new ArrayList();
        for (String[] t : helper) {
            listHelper.add(new ClientM(t[0],t[1],Integer.valueOf(t[2]),t[3]));
        }
        
        ObservableList<ClientM> list = FXCollections.observableArrayList(listHelper);
        comboBox_Client.setItems(list);

        helper = Main.getFacade().getTitleRecordStrings();
        List<TitleRecordM> listHelper2 = new ArrayList();
        
        for (String[] t : helper) {
             System.out.println(t[0]);
             System.out.println(t[1]);
             System.out.println(t[2]);
             System.out.println(t[3]);
             System.out.println(t[4]);
            listHelper2.add(new TitleRecordM(t[0],t[1],t[2],t[3],t[4]));
        }
            
       ObservableList<TitleRecordM> list2 = FXCollections.observableArrayList(listHelper2);
       comboBox_Record.setItems(list2);
        
      
        
    }

    @FXML
    private void datePicker_End_OnAction(ActionEvent event) {
        LocalDate help = datePicker_Begin.getValue();
        System.out.println(help.toString());
        if(datePicker_End.getValue().isAfter(help)){
            datestringEnd = datePicker_End.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }else
             datePicker_End.setValue(help);
    }

    @FXML
    private void recordOnAction(ActionEvent event){

        TitleRecordM help = comboBox_Record.getSelectionModel().getSelectedItem();
        titleRecordHelper = new String[]{help.getId(),help.getTitle(),help.getAuthor(),help.getGenre(),help.getCast()};
        System.out.println("ID: " +help.getId());
        System.out.println(help.getTitle());
        System.out.println(help.getAuthor());
        System.out.println(help.getGenre());
        System.out.println(help.getCast());
        
    }
    
    @FXML
    private void clientOnAction(ActionEvent event){

        ClientM help = comboBox_Client.getSelectionModel().getSelectedItem();
        clientHelper = new String[]{help.getNumberCard(),help.getLogin(),String.valueOf(help.getNumber()),help.getPassword()};
        System.out.println(help.getNumberCard());
        System.out.println(help.getLogin());
        System.out.println(String.valueOf(help.getNumber()));
        System.out.println(help.getPassword());
        
    }
    
    

}
