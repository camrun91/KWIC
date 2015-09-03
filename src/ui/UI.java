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
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setTitle("CS3219 Assignment 1 - KWIK");
        controllerHJ = new hyungjon.Controller(this);
        setupPane();
        mainStage.show();
    }
    
    private void setupPane() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setMinSize(360, 180);
        
        final Text filenameText = new Text("Enter input file path and choose method");
        grid.add(filenameText, 0, 0);
        
        final TextField filenameField = new TextField();
        grid.add(filenameField, 0, 1);
        
        final Text instructionText = new Text("First line contains words to ignore, separated by whitespace\n"
                + "Second line onwards contain titles");
        grid.add(instructionText, 0, 2);
        
        final TextField outputFilenameField = new TextField("output.txt");
        grid.add(outputFilenameField, 0, 3);
        
        final HBox buttons = new HBox();
        
        final Button submitButton1 = new Button();
        submitButton1.setText("Hyung Jon's method");
        submitButton1.setMinWidth(180);
        submitButton1.setAlignment(Pos.BOTTOM_CENTER);
        
        final Button submitButton2 = new Button();
        submitButton2.setText("Jerrold's method");
        submitButton2.setMinWidth(180);
        submitButton2.setAlignment(Pos.BOTTOM_CENTER);
        
        buttons.getChildren().addAll(submitButton1, submitButton2);
        grid.add(buttons, 0, 4);
        
        mainStage.setScene(new Scene(grid));
        
        submitButton1.setOnAction(e -> {
            processHJ(filenameField.getText(), outputFilenameField.getText());
        });
        
        submitButton2.setOnAction(e -> {
            // Jerrold's controller
        });
        
    }
    
    private void processHJ(String inputFilename, String outputFilename) {
        controllerHJ.processCircularShift(inputFilename, outputFilename);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
