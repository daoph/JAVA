package application;
	


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	private TextField sideA;
	private TextField sideB;
	private TextField sideC;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setPadding(new Insets(10,10,10,10));
			grid.setHgap(10);
			grid.setVgap(10);
			
			Scene scene = new Scene(grid,300,200);
			
			grid.add(new Label("Side A"), 0,0);
			sideA = new TextField();
			grid.add(sideA, 1, 0);
			grid.add(new Label("Side B"), 0,1);
			sideB = new TextField();
			grid.add(sideB, 1, 1);
			grid.add(new Label("Side C"), 0,2);
			sideC = new TextField();
			grid.add(sideC, 1, 2);
			
			Button calculateButton = new Button("Calculate");
			calculateButton.setOnAction(event -> calculateButtonClicked());
			
			HBox buttonBox = new HBox(10);
			buttonBox.getChildren().add(calculateButton);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			grid.add(buttonBox, 0,4,2,1);
			
			
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private Object calculateButtonClicked() {
		double sideAD = Double.parseDouble(sideA.getText());
		double sideBD = Double.parseDouble(sideB.getText());
		double sideCAns = (sideAD*sideAD) + (sideBD*sideBD);
		sideCAns = Math.sqrt(sideCAns);
		String ansString = Double.toString(sideCAns);
		
		sideC.setText(ansString);
		
		return null;
	}



	public static void main(String[] args) {
		launch(args);
	}
}
