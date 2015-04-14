import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;




public class Table extends Application {
	
	 private TableView table = new TableView();
	    public static void main(String[] args) {
	        launch(args);
	    }
	    @Override
	    public void start(Stage stage) {
	        Scene scene = new Scene(new Group());
	        stage.setTitle("Fantasty Football");
	        stage.setWidth(500);
	        stage.setHeight(500);
	 
	        final Label label = new Label("Total Statistics");
	        label.setFont(new Font("Arial", 20));
	 
	        table.setEditable(true);
	 
	        TableColumn TeamNameCol = new TableColumn("Team Name");
	        TableColumn PointsCol = new TableColumn("Points");
	        TableColumn Wins = new TableColumn("Wins");
	        TableColumn Draws = new TableColumn("Draws");
	        TableColumn GoalDifferenceCol = new TableColumn("Goal Difference");
	       
	        
	        table.getColumns().addAll(TeamNameCol,Wins, Draws, GoalDifferenceCol,PointsCol);
	        
	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table);
	 
	        ((Group) scene.getRoot()).getChildren().addAll(vbox);
	 
	        stage.setScene(scene);
	        stage.show();
	    }

}
