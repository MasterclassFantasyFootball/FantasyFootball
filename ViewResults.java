import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class ViewResults 
{
	public static void ViewResultsPlayedToDate(ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, ArrayList<ArrayList<String>> results) throws IOException
    {
		
		String message = "";
        for(int i = 0; i < results.get(0).size(); i++)
        {
            int homeTeam = Integer.parseInt(fixtures.get(1).get(i));
            int awayTeam = Integer.parseInt(fixtures.get(2).get(i));
            String homeTeamStr = teamsOrPlayers.get(1).get(homeTeam - 1);
            String awayTeamStr = teamsOrPlayers.get(1).get(awayTeam - 1);
            
            int homeResult = Integer.parseInt(results.get(1).get(i));
            int awayResult = Integer.parseInt(results.get(2).get(i));
            
            message += homeTeamStr + " " + homeResult + " - "  + awayTeamStr + " " + awayResult + "\n" + "\n"; 

        }
        JTextArea textArea = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 350,350 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "View Results", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null,message, "Results:",JOptionPane.PLAIN_MESSAGE );

       
        
    }

}
