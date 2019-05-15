/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddTitleRecordController implements Initializable {

    @FXML
    private TextField numberField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField castField;
    
    @FXML
    private Text infoField;

    @FXML
    void on_Add(ActionEvent event) {
        
        String title;
        String author;
        String id;
        String genre;
        String cast;
        String type;
        
        if(genreField == null){
            type = "2";
        }else if(genreField == null && castField == null){
            type="1";
        }else if(authorField == null && genreField == null && castField == null){
            type="0";
        }else{
            type="3";
        }
        
            title = titleField.getText();
            author = authorField.getText();
            genre = genreField.getText();
            cast = castField.getText();
            id = numberField.getText();

            String data[] = {type,id,title,author,genre,cast};
            Main.getFacade().addTitleRecord(data);
            infoField.setText("Dodano TitleRecord Id: " + id + 
                    " Title: " + title + 
                    " Author: " + author + 
                    " Genre: " + genre + 
                    " Cast: " + cast);
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
