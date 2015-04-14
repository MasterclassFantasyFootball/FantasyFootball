import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
public class chooseCaptainClass
{
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	public static ArrayList<String> teamName = new ArrayList<String>();
	public static ArrayList<String> onRoster = new ArrayList<String>();
	public static ArrayList<String> starPlayer = new ArrayList<String>();
	public static String details = "UsersTeams.txt";
	public static String line = "";
	public static String cvsSplitBy = ",";
	
	public void chooseCaptain(String hardCodeUserID) throws IOException
	{
		int changeNumber = 0;
		//select player to be made captain
		Object [] selection = {"Goalkeeper 1", "Goalkeeper 2", "Defender 1", "Defender 2", "Defender 3", "Defender 4", "Defender 5",
		"Midfielder 1", "Midfielder 2", "Midfielder 3", "Midfielder 4", "Midfielder 5", "Forward 1", "Forward 2", "Forward 3" };
		Object value = JOptionPane.showInputDialog(null, "Choose player to take off roster:","", 1 , null, selection, selection[0]);
		
		if(value.equals("Goalkeeper 1"))
		{
			changeNumber = 1;
		}
		else if(value.equals("Goalkeeper 2"))
		{
			changeNumber = 2;
		}
		else if(value.equals("Defender 1"))
		{
			changeNumber = 3;
		}
		else if(value.equals("Defender 2"))
		{
			changeNumber = 4;
		}
		else if(value.equals("Defender 3"))
		{
			changeNumber = 5;
		}
		else if(value.equals("Defender 4"))
		{
			changeNumber = 6;
		}
		else if(value.equals("Defender 5"))
		{
			changeNumber = 7;
		}
		else if(value.equals("Midfielder 1"))
		{
			changeNumber = 8;
		}
		else if(value.equals("Midfielder 2"))
		{
			changeNumber = 9;
		}
		else if(value.equals("Midfielder 3"))
		{
			changeNumber = 10;
		}
		else if(value.equals("Midfielder 4"))
		{
			changeNumber = 11;
		}
		else if(value.equals("Midfielder 5"))
		{
			changeNumber = 12;
		}
		else if(value.equals("Forward 1"))
		{
			changeNumber = 13;
		}
		else if(value.equals("Forward 2"))
		{
			changeNumber = 14;
		}
		else if(value.equals("Forward 3"))
		{
			changeNumber = 15;
		}
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
		for(int i = (start + 1); i < (start + 15); i++)
		{
			starPlayer.set(i, "No");
		}
		starPlayer.set((start + changeNumber), "Yes");
		
		//Prints to screen
		System.out.println(hardCodeUserID);
		for(int x = (start + 1); x < (start + 16); x++)
		{
			System.out.print(position.get(x) + ", ");
			System.out.print(playerName.get(x) + ", ");
			System.out.print(teamName.get(x) + ", ");
			System.out.print(onRoster.get(x) + ", ");
			System.out.print(starPlayer.get(x) + "\n");
		}	
		
		//Writes to file
		FileWriter fileW = new FileWriter(details);
		PrintWriter printW = new PrintWriter(fileW);
		for (int k = 0; k < (position.size()); k++)
		{
			printW.print(position.get(k) + "," + playerName.get(k) + "," + teamName.get(k) + ","
			+ onRoster.get(k) + "," + starPlayer.get(k) + "\n");
		}
		printW.close();
	}
}