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
	
	
	    
	    private TableView<Fixtures> table = new TableView<Fixtures>();
	    private final ObservableList<Fixtures> data =
	        FXCollections.observableArrayList(
	            new Fixtures("Southampton", "Spurs", "vs."),
	            new Fixtures("Burnley", "Leicester", "vs."),
	            new Fixtures("Crystal Palace", "Hull", "vs."),
	            new Fixtures("Newcastle", "Swansea", "vs."),
	            new Fixtures("QPR", "West Ham", "vs."),
	            new Fixtures("Stoke", "Sunderland", "vs."),
	            new Fixtures("West Brom", "Liverpool", "vs."),
	            new Fixtures("Man City", "Aston Villa", "vs."),
	            new Fixtures("Everton", "Man Utd", "vs."),
	            new Fixtures("Arsenal", "Chelsea", "vs.")
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
	 
	        final Label label = new Label("Gameweek 35 Fixtures");
	        label.setFont(new Font("Arial", 20));
	 
	       // table.setEditable(true);
	 
	        TableColumn HomeTeamCol = new TableColumn("Home Team");
	        HomeTeamCol.setMinWidth(100);
	        HomeTeamCol.setCellValueFactory(
	                new PropertyValueFactory<Fixtures, String>("HomeTeam"));
	        
	        
	        TableColumn AwayTeamCol = new TableColumn("Away Team");
	        AwayTeamCol.setMinWidth(100);
	        AwayTeamCol.setCellValueFactory(
	        		new PropertyValueFactory<Fixtures, String>("AwayTeam"));
	        
	        
	        TableColumn Vs = new TableColumn("vs");
	        Vs.setMinWidth(100);
	        Vs.setCellValueFactory(
	        		new PropertyValueFactory<Fixtures, String>("vs"));
	        

	        	
	        table.setItems(data);
	        table.getColumns().addAll(HomeTeamCol,Vs,AwayTeamCol);
	        
	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table);
	        
	 
	        ((Group) scene.getRoot()).getChildren().addAll(vbox);
	 
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    public static class Fixtures {
	    	 
	        private final SimpleStringProperty HomeTeam;
	        private final SimpleStringProperty AwayTeam;
	        private final SimpleStringProperty Vs;

	 
	        private Fixtures(String home, String away, String versus) {
	            this.HomeTeam = new SimpleStringProperty(home);
	            this.AwayTeam = new SimpleStringProperty(away);
	            this.Vs = new SimpleStringProperty(versus);

	        }
	 
	        public String getHomeTeam() {
	            return HomeTeam.get();
	        }
	 
	        public void setHomeTeam(String home) {
	            HomeTeam.set(home);
	        }
	 
	        public String getAwayTeam() {
	            return AwayTeam.get();
	        }
	 
	        public void setAwayTeam(String away) {
	            AwayTeam.set(away);
	        }
	 
	        public String getVs() {
	            return Vs.get();
	        }
	 
	        public void setVs(String versus) {
	            Vs.set(versus);
	        }

	    }

}