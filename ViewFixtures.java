
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ViewFixtures
{
	public static void ViewRemainingFixtures(ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, Integer fixturesPlayedToDate)
    {
        if(fixturesPlayedToDate != fixtures.get(0).size())
        {
        	String message = "";
            for(int i = fixturesPlayedToDate; i < fixtures.get(0).size(); i++)
            {
                int homeTeam = Integer.parseInt(fixtures.get(1).get(i));
                int awayTeam = Integer.parseInt(fixtures.get(2).get(i));
                String homeTeamStr = teamsOrPlayers.get(1).get(homeTeam - 1);
                String awayTeamStr = teamsOrPlayers.get(1).get(awayTeam - 1);

                message += homeTeamStr + "" + " VS " + awayTeamStr +"\n" + "\n"; 

            }
            JTextArea textArea = new JTextArea(message);
            JScrollPane scrollPane = new JScrollPane(textArea);  
            textArea.setLineWrap(true);  
            textArea.setWrapStyleWord(true); 
            scrollPane.setPreferredSize( new Dimension( 350,350 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "View Fixtures", JOptionPane.PLAIN_MESSAGE);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "This league is complete!", "Notification", 2);
        }
    }
	
}
