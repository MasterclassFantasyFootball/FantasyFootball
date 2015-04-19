import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
public class makeTransferClass
{
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	public static ArrayList<String> teamName = new ArrayList<String>();
	public static ArrayList<String> onRoster = new ArrayList<String>();
	public static ArrayList<String> starPlayer = new ArrayList<String>();
	public static ArrayList<String> playerValue = new ArrayList<String>();
	public static ArrayList<String> allPosition = new ArrayList<String>();
	public static ArrayList<String> allPlayerName = new ArrayList<String>();
	public static ArrayList<String> allTeamName = new ArrayList<String>();
	public static ArrayList<Integer> allPlayerValue = new ArrayList<Integer>();
	public static ArrayList<String> choicePosition = new ArrayList<String>();
	public static ArrayList<String> choicePlayerName = new ArrayList<String>();
	public static ArrayList<String> choiceTeamName = new ArrayList<String>();
	public static ArrayList<Integer> choicePlayerValue = new ArrayList<Integer>();
	public static String details = "UsersTeams.txt";
	public static String detailsPlayers = "Players.txt";
	public static String line = "";
	public static String cvsSplitBy = ",";
	
	public void makeTransfer(String hardCodeUserID, int changeNumber, int numberPointsLeft, int start) throws IOException
	{
		String playerType = "test";
		if((changeNumber == 1) || (changeNumber == 2))
			playerType = "Goalkeeper";
		else if((changeNumber == 3) || (changeNumber == 4) || (changeNumber == 5) || (changeNumber == 6) || (changeNumber == 7))
			playerType = "Defender";
		else if((changeNumber == 8) || (changeNumber == 9) || (changeNumber == 10) || (changeNumber == 11) || (changeNumber == 12))
			playerType = "Midfielder";
		else
			playerType = "Forward";
		
		//get data from UsersTeams.txt
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
				playerValue.add(allData[5]);
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
		
		//Find out how much player was worth
		String removedPlayerValue = playerValue.get(start + changeNumber);
		int removedPlayerValueInt = Integer.parseInt(removedPlayerValue);
		int totalPointToSpend = (numberPointsLeft + removedPlayerValueInt);
		System.out.println(hardCodeUserID + " " + playerType + " " + numberPointsLeft + " " + removedPlayerValueInt);
		System.out.println("Number of points available: " + totalPointToSpend);
		
		//get data from Players.txt
		BufferedReader bl = null;
		try
		{
			bl = new BufferedReader(new FileReader(detailsPlayers));
			while ((line = bl.readLine()) != null)
			{
				String[] allData = line.split(cvsSplitBy);
				int temp = Integer.parseInt(allData[3]);
				allPosition.add(allData[0]);
				allPlayerName.add(allData[1]);
				allTeamName.add(allData[2]);
				allPlayerValue.add(temp);
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
			if (bl != null)
			{
				try
				{
					bl.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		//
		
		//adds viable choices
		for(int x = 0; x < (allPosition.size()); x++)
		{
			if((allPosition.get(x)).equals(playerType) && ((allPlayerValue.get(x)) <= totalPointToSpend))
			{
				choicePosition.add(allPosition.get(x));
				choicePlayerName.add(allPlayerName.get(x));
				choiceTeamName.add(allTeamName.get(x));
				choicePlayerValue.add(allPlayerValue.get(x));
			}
		}
		//prints to screen
		for(int x = 0; x < (choicePosition.size()); x++)
		{
			System.out.print(choicePosition.get(x) + ", ");
			System.out.print(choicePlayerName.get(x) + ", ");
			System.out.print(choiceTeamName.get(x) + ", ");
			System.out.print(choicePlayerValue.get(x) + "\n");
		}
		
		//select player to be transferred
		Object[] selection = new String[choicePosition.size()];
		for(int x = 0; x < (choicePosition.size()); x++)
		{
			selection [x] = choicePlayerName.get(x);
		}
		Object value = JOptionPane.showInputDialog(null, "Choose player to transfer to team:","", 1 , null, selection, selection[0]);
		
		//find position of new player
		int transferNumber = -1;
		for(int w = 0; w < (allPosition.size()); w++)
		{
			if (allPlayerName.get(w).equals(value))
			transferNumber = w;	
		}
		//System.out.println(value + ", " + transferNumber);
		
		//swap values
		playerName.set((start + changeNumber),allPlayerName.get(transferNumber));
		teamName.set((start + changeNumber),allTeamName.get(transferNumber));
		playerValue.set((start + changeNumber),Integer.toString(allPlayerValue.get(transferNumber)));
		
		//update how many points player has
		int pointsAfterTransfer = (totalPointToSpend - allPlayerValue.get(transferNumber));
		playerValue.set(start,Integer.toString(pointsAfterTransfer));
		
		//Writes to file
		FileWriter fileW = new FileWriter(details);
		PrintWriter printW = new PrintWriter(fileW);
		for (int k = 0; k < (position.size()); k++)
		{
			printW.print(position.get(k) + "," + playerName.get(k) + "," + teamName.get(k) + ","
			+ onRoster.get(k) + "," + starPlayer.get(k) + "," + playerValue.get(k) +  "\n");
		}
		printW.close();
	}
}