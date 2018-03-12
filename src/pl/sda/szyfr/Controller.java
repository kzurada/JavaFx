package pl.sda.szyfr;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    private Button changeDigitOne;
    @FXML
    private Button changeDigitTwo;
    @FXML
    private Button changeDigitThree;
    @FXML
    private Button checkQuantityOfLeftTries;
    @FXML
    private Label digitOne;
    @FXML
    private Label digitTwo;
    @FXML
    private Label digitThree;
    @FXML
    private Label quantityOfLeftTries;

    private Integer triesCount = 3;
    private Integer digitOneValue = 0, digitTwoValue = 0, digitThreeValue = 0;



    public void initialize() {
        digitOne.setText(digitOneValue.toString());
        digitTwo.setText(digitTwoValue.toString());
        digitThree.setText(digitThreeValue.toString());

        quantityOfLeftTries.setText("Pozostało prób: " + triesCount.toString());

        checkQuantityOfLeftTries.setOnAction(event -> {
            triesCount--;
            quantityOfLeftTries.setText("Pozostało prób: " + triesCount.toString());
            if (triesCount == 0) {
                quantityOfLeftTries.setText("Nie masz już więcej prób!");
                checkQuantityOfLeftTries.setDisable(true);
            }
            if (digitOneValue == 1 && digitTwoValue == 2 && digitThreeValue == 3) {
                quantityOfLeftTries.setText("Zgadles!");
                checkQuantityOfLeftTries.setDisable(true);
            }
        });

        changeDigitOne.setOnAction(event -> {
            digitOneValue++;
            digitOne.setText(digitOneValue.toString());
            if (digitOneValue == 5) {
                digitOneValue = 0;
            }
        });

        changeDigitTwo.setOnAction(event -> {
            digitTwoValue++;
            digitTwo.setText(digitTwoValue.toString());
            if (digitTwoValue == 5) {
                digitTwoValue = 0;
            }
        });

        changeDigitThree.setOnAction(event ->{
            digitThreeValue++;
            digitThree.setText(digitThreeValue.toString());
            if (digitThreeValue == 5) {
                digitThreeValue = 0;
            }
        });

        List<Button> listOfButtons = Arrays.asList(changeDigitOne, changeDigitTwo, changeDigitThree);
        List<Label> listOfLabels = Arrays.asList(digitOne, digitTwo, digitThree);

    }

}
