package kwic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {
    
    Stage mainStage = new Stage();
    GridPane grid = new GridPane();
    Controller controller;
    TextArea outputField = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setTitle("Assignment 1 - KWIC");
        controller = new Controller(this);
        setupPane();
        mainStage.show();
    }
    
    private void setupPane() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setMinSize(500, 500);
        
        final Text inputText = new Text("Enter input file path");
        grid.add(inputText, 0, 0);
        
        final TextArea inputField = new TextArea();
        grid.add(inputField, 0, 1);
        
        final Text outputText = new Text("Output will show here.");
        grid.add(outputText, 0, 2);
        
       
        grid.add(outputField, 0, 3);
        
        final HBox buttons = new HBox();
        
        
        final Button submitButton = new Button();
        submitButton.setText("Solution");
        submitButton.setMinWidth(180);
        submitButton.setAlignment(Pos.BOTTOM_CENTER);
        final Button clearButton = new Button();
        clearButton.setText("Clear Output");
        clearButton.setMinWidth(180);
        clearButton.setAlignment(Pos.BOTTOM_CENTER);
        
        buttons.getChildren().addAll(submitButton,clearButton);
        grid.add(buttons, 0, 4);
        
        mainStage.setScene(new Scene(grid));
        
        
        submitButton.setOnAction(e -> {
            process(inputField.getText());
        });
        
        clearButton.setOnAction(e -> {
            this.outputField.setText(null);
        });
        
    }
    
    
    private void process(String inputFilename) {
        controller.processCircularShift(inputFilename, this.outputField);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
