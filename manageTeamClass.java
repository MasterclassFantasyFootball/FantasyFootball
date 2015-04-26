import java.awt.Dimension;
import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.util.*;
public class manageTeamClass
{
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	public static ArrayList<String> teamName = new ArrayList<String>();
	public static ArrayList<String> onRoster = new ArrayList<String>();
	public static ArrayList<String> starPlayer = new ArrayList<String>();
	public static String details = "UsersTeams.txt";
	public static String line = "";
	public static String cvsSplitBy = ",";
	
	public void manageTeam(String hardCodeUserID) throws IOException
	{
		//get data from file
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(details));
			while ((line = br.readLine()) != null)
			{
				String[] allData = line.split(cvsSplitBy);
				position.add(allData[0]);
				playerName.add(allData[1]);
				teamName.add(allData[2]);
				onRoster.add(allData[3]);
				starPlayer.add(allData[4]);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		int length = position.size();
		int start = position.indexOf(hardCodeUserID);
		//Prints to screen
		System.out.println(hardCodeUserID);
		String message = "";
		System.out.print("Position      Name        Team    Starting  Captain\n");
		for(int x = (start + 1); x < (start + 16); x++)
		{
			message += position.get(x) + ", " + playerName.get(x) + ", " + teamName.get(x) + ", " + onRoster.get(x) + ", " + starPlayer.get(x) + "\n\n";
			System.out.print(position.get(x) + ", ");
			System.out.print(playerName.get(x) + ", ");
			System.out.print(teamName.get(x) + ", ");
			System.out.print(onRoster.get(x) + ", ");
			System.out.print(starPlayer.get(x) + "\n");
		}
		JTextArea textArea = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 400,400 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "Team Management", JOptionPane.PLAIN_MESSAGE);
		
		//Go to other classes
		Object [] selection = {"Choose Captain", "Place Player On/Off Bench"};
		Object value = JOptionPane.showInputDialog(null, "Make a choice from the following:","", 1 , null, selection, selection[0]);
		
		if(value.equals("Choose Captain"))
		{
			chooseCaptain(hardCodeUserID);
		}
		else if(value.equals("Place Player On/Off Bench"))
		{
			onRoster(hardCodeUserID);
		}
		
	}
	
	public static void chooseCaptain(String hardCodeUserID) throws IOException
	{
		chooseCaptainClass execute = new chooseCaptainClass();
		execute.chooseCaptain(hardCodeUserID);
	}
	
	public static void onRoster(String hardCodeUserID) throws IOException
	{
		onRosterClass execute = new onRosterClass();
		execute.onRoster(hardCodeUserID);
	}
}