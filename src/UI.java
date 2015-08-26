
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {
    
    Stage mainstage = new Stage();
    GridPane grid = new GridPane();
    Controller controller;
    TextArea resultArea;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CS3219 Assignment 1 - Circular Shift");
        controller = new Controller(this);
        resultArea = new TextArea();
        setupPane();
    }
    
    public void setupPane() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(5);
        grid.setHgap(5);
        
        final Text filenameText = new Text("Enter input text file path");
        grid.add(filenameText, 0, 0);
        
        final TextField filenameField = new TextField();
        grid.add(filenameField, 0, 1);
        
        final Text instructionText = new Text("First line contains words to ignore, separated by whitespace\n"
                + "Second line onwards contain titles");
        grid.add(instructionText, 0, 2);
        
        final HBox buttons = new HBox();
        
        final Button submitButton = new Button();
        submitButton.setText("Submit");
        submitButton.setAlignment(Pos.BOTTOM_RIGHT);
        
        buttons.getChildren().add(submitButton);
        grid.add(buttons, 0, 3);
        
        grid.add(resultArea, 0, 4);
        
        mainstage.setScene(new Scene(grid));
        mainstage.show();
        
        filenameField.setOnAction(e -> {
            process(filenameField.getText());
        });
        
        submitButton.setOnAction(e -> {
            process(filenameField.getText());
        });
        
        // Add indicator of how long the prog ran
        
    }
    
    public void process(String filename) {
        if (filename.length() > 4 && filename.substring(filename.length() - 4).equals(".txt")) {
            controller.processCircularShift(filename);
        } else {
            resultArea.setText("Not a text file");
        }
        
        File file = new File(filename);
        if (!file.exists()) {
            resultArea.setText("File does not exist");
        }
    }
    
    public void displayResult(String result) {
        resultArea.setText(result);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
