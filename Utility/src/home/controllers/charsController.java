package home.controllers;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class charsController {

    /**
     * Function which allows to copy the text from a button into the clipboard.
     * @param event
     */
    public void copyToClickBoard(MouseEvent event) {
        Object node = event.getSource();
        Button button = (Button) node;
        String valueFromButton = button.getText();
        StringSelection stringSelection = new StringSelection(valueFromButton);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
