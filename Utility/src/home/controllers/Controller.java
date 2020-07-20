package home.controllers;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    public BorderPane mainBorderPane;

    @FXML
    private void changeToChars(MouseEvent event) {
            loadUI("chars");
    }


    @FXML
    private void changeToTrasher(MouseEvent event) {
        loadUI("trasher");
    }

    private void loadUI(String ui) {
        Parent root = null;
        try{
            System.out.println("chars");
        root = FXMLLoader.load(getClass().getResource("/home/resources/fxml/"+ui+".fxml"));}
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }

        mainBorderPane.setCenter(root);
    }
    @FXML
    public void close(MouseEvent event) {
        System.out.println("Helloo");

        Stage stage = (Stage) mainBorderPane.getScene().getWindow();
        stage.close();
    }


}
