/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.TitleRecordM;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchDeleteTitleRecordController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<String[]> helper = Main.getFacade().getTitleRecordStrings();
        List<TitleRecordM> listHelper = new ArrayList();

        for (String[] t : helper) {
            System.out.println(t[0]);
            System.out.println(t[1]);
            System.out.println(t[2]);
            System.out.println(t[3]);
            System.out.println(t[4]);
            listHelper.add(new TitleRecordM(t[0], t[1], t[2], t[3], t[4]));
        }
        ObservableList<TitleRecordM> list = FXCollections.observableArrayList(listHelper);

        TableColumn idCol = new TableColumn("ID");
        TableColumn titleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        TableColumn castCol = new TableColumn("Cast");
        TableColumn genreCol = new TableColumn("Genre");

        idCol.prefWidthProperty().bind(TitleRecordTable.widthProperty().multiply(0.10));
        titleCol.prefWidthProperty().bind(TitleRecordTable.widthProperty().multiply(0.25));
        authorCol.prefWidthProperty().bind(TitleRecordTable.widthProperty().multiply(0.20));
        castCol.prefWidthProperty().bind(TitleRecordTable.widthProperty().multiply(0.25));
        genreCol.prefWidthProperty().bind(TitleRecordTable.widthProperty().multiply(0.20));

        idCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("id")
        );
        titleCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("title")
        );
        authorCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("author")
        );
        castCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("cast")
        );
        genreCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("genre")
        );

        TitleRecordTable.setItems(list);
        TitleRecordTable.getColumns().addAll(idCol, titleCol, authorCol, castCol, genreCol);

    }
    @FXML
    private TableView<TitleRecordM> TitleRecordTable;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton backButton;

    @FXML
    void deleteButton(ActionEvent event) {
        int selIndex = TitleRecordTable.getSelectionModel().getSelectedIndex();
        Main.getFacade().deleteTitleRecord(Main.getFacade().transformTitleRecordIndexToString(selIndex));

        List<String[]> helper = Main.getFacade().getTitleRecordStrings();
        List<TitleRecordM> listHelper = new ArrayList();

        for (String[] t : helper) {
            listHelper.add(new TitleRecordM(t[0], t[1], t[2], t[3], t[4]));
        }
        ObservableList<TitleRecordM> list = FXCollections.observableArrayList(listHelper);
        TitleRecordTable.setItems(list);
    }

    @FXML
    void backButton(ActionEvent event) {
        OptionsController.recordStage.close();
    }

}
