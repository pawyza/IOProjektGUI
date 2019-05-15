package GUI;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class OptionsController extends JPanel implements ActionListener, Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private MenuItem menuItem_Close;

    @FXML
    private MenuItem menuItem_About;

    @FXML
    private JFXButton btn_addRecord;

    @FXML
    private JFXButton btn_addTitleRecord;

    @FXML
    private JFXButton btn_addClient;

    @FXML
    private JFXButton btn_addReservation;

    @FXML
    private JFXButton btn_searchRecord;

    @FXML
    private JFXButton btn_searchDeleteTitleRecord;

    @FXML
    private JFXButton btn_searchDeleteClient;

    @FXML
    private JFXButton btn_searchReservation;

    @FXML
    private JFXButton btn_deleteRecord;


    @FXML
    private JFXButton btn_deleteReservation;

    @FXML
    private JFXButton btn_Return;
    static Stage recordStage;

    @FXML
    void btn_Return_onAction(ActionEvent event) {
        Main.stg.show();
        MainController.stg.close();

    }


    @FXML
    void btn_addClient_onAction(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(AddClientController.class.getResource("AddClient.fxml"));
         Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;
    }




    @FXML
    void btn_addRecord_onAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddRecordController.class.getResource("addRecord.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Record");
        stage.setResizable(false);
        this.recordStage = stage;
    }

    @FXML
    void btn_addReservation_onAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddReservationController.class.getResource("addReservation.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;
    }


    @FXML
    void btn_addTitleRecord_onAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddTitleRecordController.class.getResource("addTitleRecord.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Title record");
        stage.setResizable(false);
        this.recordStage = stage;

    }

    
 

    @FXML
    void btn_searchDeleteTitleRecord_onAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddReservationController.class.getResource("SearchDeleteTitleRecord.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;

        
    }

    @FXML
    void btn_searchDeleteClient_onAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddReservationController.class.getResource("SearchDeleteClients.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;
    }

    @FXML
    void btn_searchDeleteRecord_onAction(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(AddReservationController.class.getResource("SearchDeleteRecord.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;

    }

    @FXML
    void btn_searchDeleteReservation_onAction(ActionEvent event) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(AddReservationController.class.getResource("SearchDeleteReservation.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Rental");
        stage.setResizable(false);
        this.recordStage = stage;

    }

    

    @FXML
    void menuItem_About_OnAction(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL("http://zofia.kruczkiewicz.staff.iiar.pwr.wroc.pl/").toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void menuItem_Close_OnAction(ActionEvent event) {
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Close application", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) System.exit(0);
    }


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
