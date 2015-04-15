package src;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;;




public class TableWithData extends Application {
	
	
	    
	    private TableView<Stats> table = new TableView<Stats>();
	    private final ObservableList<Stats> data =
	        FXCollections.observableArrayList(
	            new Stats("Man Utd", "68", "20", "12", "+50"),
	            new Stats("Man City", "50", "13", "13", "+40"),
	            new Stats("Chelsea", "40", "14", "9", "+10"),
	            new Stats("Tottenham", "30", "6", "12", "+5"),
	            new Stats("Hull", "12", "11", "7", "-10")
	        );

	    public static void main(String[] args) {
	        launch(args);
	    }
	    @Override
	    public void start(Stage stage) {
	        Scene scene = new Scene(new Group());
	        stage.setTitle("Fantasty Football");
	        stage.setWidth(650);
	        stage.setHeight(500);
	 
	        final Label label = new Label("Total Statistics");
	        label.setFont(new Font("Arial", 20));
	 
	       // table.setEditable(true);
	 
	        TableColumn TeamNameCol = new TableColumn("Team Name");
	        TeamNameCol.setMinWidth(100);
	        TeamNameCol.setCellValueFactory(
	                new PropertyValueFactory<Stats, String>("teamName"));
	        
	        
	        TableColumn PointsCol = new TableColumn("Points");
	        PointsCol.setMinWidth(100);
	        PointsCol.setCellValueFactory(
	        		new PropertyValueFactory<Stats, String>("points"));
	        
	        
	        TableColumn Wins = new TableColumn("Wins");
	        Wins.setMinWidth(100);
	        Wins.setCellValueFactory(
	        		new PropertyValueFactory<Stats, String>("wins"));
	        
	        
	        TableColumn Draws = new TableColumn("Draws");
	        Draws.setMinWidth(100);
	        Draws.setCellValueFactory(
	        		new PropertyValueFactory<Stats, String>("draws"));
	        
	        
	        TableColumn GoalDifferenceCol = new TableColumn("Goal Difference");
	        GoalDifferenceCol.setMinWidth(100);
	        GoalDifferenceCol.setCellValueFactory(
	        		new PropertyValueFactory<Stats, String>("goals"));
	        	
	        table.setItems(data);
	        table.getColumns().addAll(TeamNameCol,Wins, Draws, PointsCol,GoalDifferenceCol);
	        
	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table);
	        
	 
	        ((Group) scene.getRoot()).getChildren().addAll(vbox);
	 
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    public static class Stats {
	    	 
	        private final SimpleStringProperty TeamName;
	        private final SimpleStringProperty Points;
	        private final SimpleStringProperty Wins;
	        private final SimpleStringProperty Draws;
	        private final SimpleStringProperty GoalDifference;
	 
	        private Stats(String team, String points, String wins, String drAwS, String goalDif) {
	            this.TeamName = new SimpleStringProperty(team);
	            this.Points = new SimpleStringProperty(points);
	            this.Wins = new SimpleStringProperty(wins);
	            this.Draws = new SimpleStringProperty(drAwS);
	            this.GoalDifference = new SimpleStringProperty(goalDif);
	        }
	 
	        public String getTeamName() {
	            return TeamName.get();
	        }
	 
	        public void setTeamName(String team) {
	            TeamName.set(team);
	        }
	 
	        public String getPoints() {
	            return Points.get();
	        }
	 
	        public void setPoints(String points) {
	            Points.set(points);
	        }
	 
	        public String getWins() {
	            return Wins.get();
	        }
	 
	        public void setWins(String wins) {
	            Wins.set(wins);
	        }
	        public String getDraws() {
	            return Draws.get();
	        }
	 
	        public void setDraws(String drAwS) {
	            Wins.set(drAwS);
	        }
	        public String getGD(){
	        	return GoalDifference.get();
	        }
	        public void setGD(String goalDif){
	        	GoalDifference.set(goalDif);
	        }
	    }

}

