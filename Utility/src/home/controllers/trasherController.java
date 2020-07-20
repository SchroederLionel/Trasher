package home.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class trasherController {

    public TextField word;
    public TextArea textView;
    private String pathUrl= "./src/home/resources/letters/letters.txt";
    int currentPoisiontOfPointerX = 0;

    String [][] array = new String[5][29];
    // Lol length = 29
    // Breite 5

    public void generate(MouseEvent event) throws IOException {
        String worder = word.getText().toUpperCase();
        int sum = getSumOfTheWord(worder);
        int valueToCenter = 29-sum;
        int division = valueToCenter/2;
        currentPoisiontOfPointerX = division;
        resetArray();
        if(sum > 29){
            textView.setText("Word has to many chars");
        }else {

            int currentPoisiontOfPointerY = 0;
            for (int i = 0; i < worder.length(); i++) {
                char charachter = worder.charAt((i));

                int position = getPositionInAlphabetOfLetter(charachter);
                int positionOfCharInFile = getPositionOfCharInFile(position);
                for (int j = 0; j < 5; j++) {
                    String line = Files.readAllLines(Paths.get(pathUrl)).get(positionOfCharInFile + j);
                    populateArray(line, charachter, currentPoisiontOfPointerY);
                    currentPoisiontOfPointerY++;
                }
                currentPoisiontOfPointerY = 0;
                currentPoisiontOfPointerX += getLengthOfChar(charachter) + 1;
                addHorizontalLine(currentPoisiontOfPointerX);
            }
            //displayArrax();

            textView.setText(getArrayAsString());
            StringSelection stringSelection = new StringSelection(getArrayAsString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            resetArray();
        }
    }

    private String getArrayAsString() {
        StringBuilder myFinalString =new StringBuilder("");

        for(int i =0; i <5; i++){
            for(int j=0; j< 29;j++){
                myFinalString.append(array[i][j]);
            }
            myFinalString.append("\n");
        }
        return myFinalString.toString();
    }



    public void addHorizontalLine(int startPointX) {
        if(startPointX < 29){
        for(int i =0; i< 5; i++) {
            array[i][startPointX] = "░";
        }}
    }
    public void resetArray() {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j< 29;j++){
                array[i][j] ="░";
            }
        }
    }

    public int getPositionInAlphabetOfLetter(char character){
        return (((int)character)-65);
    }

    public int getPositionOfCharInFile(int numberPositionInAlphabet) {
        if(numberPositionInAlphabet == 0){
            return 0;
        }
        return numberPositionInAlphabet*5;
    }


    public void populateArray(String line, char charachter,int currentPointerPositionY){
        int lengthOfChar = getLengthOfChar(charachter);

        for(int i = 0; i < lengthOfChar; i++ ){
            if(i < line.length()) {
                if (line.charAt(i) == ('█')) {
                    array[currentPointerPositionY][currentPoisiontOfPointerX+i] = "█";
                } else {
                    array[currentPointerPositionY][currentPoisiontOfPointerX+i] = "░";
                }
            }
        }
    }



    public void displayArrax(){
        for(int i=0;i < 5; i++){
            for(int j =0; j < 29;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }





    public int getSumOfTheWord(String word) {
        int sum = 0;
        for(int i=0; i < word.length(); i++){
            sum+=getLengthOfChar(word.charAt(i))+1;
        }
        return sum-1;
    }




    public int getLengthOfChar(char character){
        switch (character){
            case 'A':
                return 8;
            case 'D':
                return 6;
            case 'G':
                return 6;
            case 'K':
                return 7;
            case 'M':
                return 7;
            case 'N':
                return 6;
            case 'Q':
                return 7;
            case 'R':
                return 7;
            case 'V':
                return 8;
            case 'W':
                return 9;
            case 'Y':
                return 8;

        }
        return 5;
    }












}
