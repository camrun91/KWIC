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
        mainStage.setTitle("Assignment 2 - KWIC");
        controller = new Controller(this);
        setupPane();
        mainStage.show();
    }
    //Add pane for the input and the submit buttons
    private void setupPane() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setMinSize(500, 500);
        
        final Text inputText = new Text("Enter the input to be sorted. Each line will be treated as single input.");
        grid.add(inputText, 0, 0);
        //input area to allow multi line input
        final TextArea inputField = new TextArea();
        grid.add(inputField, 0, 1);
        //output area to allow multi line output
        final Text outputText = new Text("Output will show here.");
        grid.add(outputText, 0, 2);
        
       
        grid.add(outputField, 0, 3);
        //Container for the Buttons.
        final HBox buttons = new HBox();
        //setup the buttons
        final Button submitButton = new Button();
        submitButton.setText("Solution");
        submitButton.setMinWidth(180);
        submitButton.setAlignment(Pos.BOTTOM_CENTER);
        final Button clearButton = new Button();
        clearButton.setText("Clear Output");
        clearButton.setMinWidth(180);
        clearButton.setAlignment(Pos.BOTTOM_CENTER);
        //add the buttons to the grid
        buttons.getChildren().addAll(submitButton,clearButton);
        grid.add(buttons, 0, 4);
        //add the grid to the scene
        mainStage.setScene(new Scene(grid));
        
        //Button submit press action
        submitButton.setOnAction(e -> {
            process(inputField.getText());
        });
        //clear button action on press.
        clearButton.setOnAction(e -> {
            this.outputField.setText(null);
        });
        
    }
    
    //Start the processing of the input.
    private void process(String inputFilename) {
        controller.processCircularShift(inputFilename, this.outputField);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
