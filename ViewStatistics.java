import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ViewStatistics 
{
	public void Statistics()
	{
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * JPanel panel = new JPanel (); panel.setBorder
		 * (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder
		 * (), "Gameweek 35 Fixtures", TitledBorder.CENTER, TitledBorder.TOP));
		 */// Using this JPanel code to add in border and title, bt it removes
			// the first top column, so ignore this code

		Object rowData[][] = { 
				{ "Chelsea", "76", "23", "7", "2", "39" },
				{ "Arsenal", "66", "20", "6", "6", "31" },
				{ "Manchester United", "65", "19", "8", "6", "28" },
				{ "Manchester City", "64", "19", "7", "7", "33" }, 
				{ "Liverpool", "57", "17", "6", "9", "11" },
				{ "Tottenham", "57", "17", "6", "10", "6" },
				{ "Southampton","56", "17", "5", "11", "21"},
				{ "Swansea", "47", "13", "8", "12", "-4" },
				{ "Stoke", "46", "13", "7", "13", "-3" },
				{ "West Ham", "43", "11", "10", "12", "0"}

		};
		Object columnNames[] = { "Team Name", "Points", "Wins", "Draws", "Losses", "Goal Diff" };
		JTable table = new JTable(rowData, columnNames);
		// panel.add (table);
		// This code is also used for border/title
		// frame.add (panel);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(750, 200);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

	}
}
