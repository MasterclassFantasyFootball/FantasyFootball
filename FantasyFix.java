package fixturesJTable;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


	public class FantasyFix {
	  public static void main(String args[]) {
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	  /*  JPanel panel = new JPanel ();
        panel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                            "Gameweek 35 Fixtures",
                                                            TitledBorder.CENTER,
                                                            TitledBorder.TOP));
*/  //Using this JPanel code to add in border and title, bt it removes the first top column, so ignore this code
	  
	    Object rowData[][] = { { "Burnley", "vs.", "Leicester" },
	        { "Crystal Palace","vs.", "Hull"},
	        { "Newcastle", "vs.", "Swansea" },
	        { "QPR", "vs.", "West Ham" },
	        { "Stoke", "vs.", "Sunderland" },
	        { "West Brom", "vs.", "Liverpool" },
	        { "Man City", "vs.", "Aston Villa" },
	        { "Everton", "vs.", "Man Utd" },
	        { "Arsenal", "vs.", "Chelsea" },

	        };
	    Object columnNames[] = { "Home Team", "vs", "Away Team" };
	    JTable table = new JTable(rowData, columnNames);
	   // panel.add (table);
	    						//This code is also used for border/title
       // frame.add (panel);
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(750, 450);
        frame.setLocationRelativeTo (null);
        frame.pack ();
        frame.setVisible (true);
	   
	  }
	  

	  
	}

