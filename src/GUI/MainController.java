package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainController {
    static Stage stg;
    @FXML
    private MenuItem menuItem_Close;

    @FXML
    private MenuItem menuItem_About;

    @FXML
    private JFXButton btn_Login;

    @FXML
    private JFXTextField txt_Login;

    @FXML
    private JFXPasswordField txt_Password;

    @FXML
    void btn_Login_onAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("options.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Rental");
            stage.setResizable(false);
            this.stg = stage;
            Main.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
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

}
