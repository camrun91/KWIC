package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {
    
    Stage mainStage = new Stage();
    GridPane grid = new GridPane();
    hyungjon.Controller controllerHJ;
    jerrold.Controller controllerJerrold;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setTitle("CS3219 Assignment 1 - KWIK");
        controllerHJ = new hyungjon.Controller(this);
        controllerJerrold = new jerrold.Controller(this);
        setupPane();
        mainStage.show();
    }
    
    private void setupPane() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setMinSize(360, 180);
        
        final Text inputFilenameText = new Text("Enter input file path");
        grid.add(inputFilenameText, 0, 0);
        
        final TextField inputFilenameField = new TextField();
        grid.add(inputFilenameField, 0, 1);
        
        final Text outputFilenameText = new Text("Enter the output file path and choose method");
        grid.add(outputFilenameText, 0, 2);
        
        final TextField outputFilenameField = new TextField("output.txt");
        grid.add(outputFilenameField, 0, 3);
        
        final HBox buttons = new HBox();
        
        final Button submitButton1 = new Button();
        submitButton1.setText("Solution 1: Jerrold");
        submitButton1.setMinWidth(180);
        submitButton1.setAlignment(Pos.BOTTOM_CENTER);
        
        final Button submitButton2 = new Button();
        submitButton2.setText("Solution 2: Hyung Jon");
        submitButton2.setMinWidth(180);
        submitButton2.setAlignment(Pos.BOTTOM_CENTER);
        
        buttons.getChildren().addAll(submitButton1, submitButton2);
        grid.add(buttons, 0, 4);
        
        final Text instructions = new Text("Input format: \n"
                + "First line contains all words to ignore\n"
                + "Second line onwards each contain one title");
        grid.add(instructions, 0, 5);
        
        mainStage.setScene(new Scene(grid));
        
        submitButton1.setOnAction(e -> {
            processJerrold(inputFilenameField.getText(), outputFilenameField.getText());
        });
        
        submitButton2.setOnAction(e -> {
            processHJ(inputFilenameField.getText(), outputFilenameField.getText());
        });
        
    }
    
    private void processJerrold(String inputFilename, String outputFilename) {
        controllerJerrold.processCircularShift(inputFilename, outputFilename);
    }
    
    private void processHJ(String inputFilename, String outputFilename) {
        controllerHJ.processCircularShift(inputFilename, outputFilename);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
