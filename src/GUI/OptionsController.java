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
    private JFXButton btn_searchTitleRecord;

    @FXML
    private JFXButton btn_searchClient;

    @FXML
    private JFXButton btn_searchReservation;

    @FXML
    private JFXButton btn_deleteRecord;

    @FXML
    private JFXButton btn_deleteTitleRecord;

    @FXML
    private JFXButton btn_deleteClient;

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
    void btn_addClient_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField idField = new JTextField(5);
        JPasswordField passField = new JPasswordField(5);
        String login;
        String password;
        String cardNumber;
        String id;
        String data[] = new String[4];

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("ID:"));
        myPanel.add(idField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Card Number:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Login:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Password:"));
        myPanel.add(passField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter card number and login", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            login = yField.getText();
            cardNumber = xField.getText();
            password = passField.getText();
            id = idField.getText();
            System.out.println("Login:  " + login);
            System.out.println("CardNumber: " + cardNumber);
            System.out.println("Password: "+ password);
            data[0] = cardNumber;
            data[1] = login;
            data[2] = id;
            data[3] = password;


            Main.getFacade().addClient(data);//OK

        }


    }




    @FXML
    void btn_addRecord_onAction(ActionEvent event) throws IOException {


        JTextField yField = new JTextField(5);
        JComboBox choiceBox = new JComboBox(Main.getFacade().getTitleRecordsModel().toArray());

        String number1;
        String number2;



        JPanel myPanel = new JPanel();

        myPanel.add(choiceBox);
        myPanel.add(Box.createHorizontalStrut(15));

        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Number 2 :"));
        myPanel.add(yField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter data 1 and data 2 ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = choiceBox.getSelectedIndex();
            number1 = Integer.toString(0);
            number2 = yField.getText();
            String data[] = {number1,number2};
            System.out.println("Number 1:  " + number1);//????
            System.out.println("Number 2: " + number2);//???
            System.out.println(Main.getFacade().transformTittleRecordToString(selectedIndex));
            Main.getFacade().addRecord( Main.getFacade().transformTittleRecordToString(selectedIndex), data);
        }

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
    void btn_addTitleRecord_onAction(ActionEvent event) {
        JTextField titleField = new JTextField(5);
        JTextField authorField = new JTextField(5);
        JTextField idField = new JTextField(5);
        JTextField genreField = new JTextField(5);
        JTextField castField = new JTextField(5);

        String title;
        String author;
        String id;
        String genre;
        String cast;

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Number:"));
        myPanel.add(idField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Title:"));
        myPanel.add(titleField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Author:"));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(authorField);
        myPanel.add(new JLabel("Genre:"));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(genreField);
        myPanel.add(new JLabel("Cast:"));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(castField);


        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter TitleRecord parameters", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            title = titleField.getText();
            author = authorField.getText();
            genre = genreField.getText();
            cast = castField.getText();
            id = idField.getText();

            String data[] = {"3",id,title,author,genre,cast};
            Main.getFacade().addTitleRecord(data);
            System.out.println(id + title + author + genre + cast);//???
        }

    }

    @FXML
    void btn_deleteClient_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int clientId;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Client ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter client ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            clientId = Integer.valueOf(xField.getText());
            System.out.println("ID:  " + clientId);//????
            Main.getFacade().deleteClient(clientId);


        }
    }

    @FXML
    void btn_deleteRecord_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int recordId;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Record ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter record ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            recordId = Integer.valueOf(xField.getText());

            System.out.println("ID:  " + recordId);
            Main.getFacade().deleteRecord(recordId);



        }
    }

    @FXML
    void btn_deleteReservation_onAction(ActionEvent event) {

        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        int reservationId;
        int clientId;

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Client ID:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Reservation ID:"));
        myPanel.add(yField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter reservation information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            clientId = Integer.valueOf(xField.getText());
            clientId = Integer.valueOf(xField.getText());
            //TODO GET RESERVATION




        }
    }

    @FXML
    void btn_deleteTitleRecord_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int titleRecordId;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("TitleRecord ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter title record ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            titleRecordId = Integer.valueOf(xField.getText());
            System.out.println("ID:  " + xField.getText());
            Main.getFacade().deleteTitleRecord(Integer.toString(titleRecordId));//poprawa!!!!

        }
    }

    @FXML
    void btn_searchClient_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int clientId;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Client ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter client ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            clientId = Integer.valueOf(xField.getText());
            System.out.println(Main.getFacade().searchClient(clientId).toString());///poprawa!!!

        }
    }

    @FXML
    void btn_searchRecord_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int recordId;
        JComboBox choiceBox = new JComboBox(Main.getFacade().getTitleRecordsModel().toArray());
        JPanel myPanel = new JPanel();
        myPanel.add(choiceBox);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter record ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = choiceBox.getSelectedIndex();
            String[] tittleRecord = Main.getFacade().transformTittleRecordToString(selectedIndex);
            Main.getFacade().searchRecordsOfTitle(tittleRecord);
            System.out.println(Main.getFacade().searchRecordsOfTitle(tittleRecord));
        }
    }

    @FXML
    void btn_searchReservation_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        int reservationID;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Reservation ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter reservation ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            reservationID = Integer.valueOf(xField.getText());
            System.out.println("ID:  " + reservationID);
            //TODO
        }
    }

    @FXML
    void btn_searchTitleRecord_onAction(ActionEvent event) {
        JTextField xField = new JTextField(5);
        JComboBox Box ;
        String titleRecordId;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("TitleRecord ID:"));
        myPanel.add(xField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter title record ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            titleRecordId = xField.getText();
            Box = new JComboBox();
            Box.addItem(Main.getFacade().searchTitleRecod(titleRecordId).toString());

        }
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
