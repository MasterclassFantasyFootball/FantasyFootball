import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
public class manageTransfersClass
{
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	public static ArrayList<String> teamName = new ArrayList<String>();
	public static ArrayList<String> playerValue = new ArrayList<String>();
	public static String details = "UsersTeams.txt";
	public static String line = "";
	public static String cvsSplitBy = ",";
	
	public void manageTransfers(String hardCodeUserID) throws IOException
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
		int length = position.size();
		int start = position.indexOf(hardCodeUserID);
		//Prints to screen
		System.out.println(hardCodeUserID);
		for(int x = (start + 1); x < (start + 16); x++)
		{
			System.out.print(position.get(x) + ", ");
			System.out.print(playerName.get(x) + ", ");
			System.out.print(teamName.get(x) + "- Player is worth: ");
			System.out.print(playerValue.get(x) + " points\n");
		}
	
		//Choose player to take off
		int numberPointsLeft = Integer.parseInt(playerValue.get(start));
		int changeNumber = 0;
		Object [] selection = {"Goalkeeper 1", "Goalkeeper 2", "Defender 1", "Defender 2", "Defender 3", "Defender 4", "Defender 5",
		"Midfielder 1", "Midfielder 2", "Midfielder 3", "Midfielder 4", "Midfielder 5", "Forward 1", "Forward 2", "Forward 3" };
		Object value = JOptionPane.showInputDialog(null, "Choose player to take off team:","", 1 , null, selection, selection[0]);
		
		if(value.equals("Goalkeeper 1"))
		{
			changeNumber = 1;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Goalkeeper 2"))
		{
			changeNumber = 2;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Defender 1"))
		{
			changeNumber = 3;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Defender 2"))
		{
			changeNumber = 4;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Defender 3"))
		{
			changeNumber = 5;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Defender 4"))
		{
			changeNumber = 6;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Defender 5"))
		{
			changeNumber = 7;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Midfielder 1"))
		{
			changeNumber = 8;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Midfielder 2"))
		{
			changeNumber = 9;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Midfielder 3"))
		{
			changeNumber = 10;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Midfielder 4"))
		{
			changeNumber = 11;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Midfielder 5"))
		{
			changeNumber = 12;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Forward 1"))
		{
			changeNumber = 13;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Forward 2"))
		{
			changeNumber = 14;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		else if(value.equals("Forward 3"))
		{
			changeNumber = 15;
			makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
		}
		
		
	}
	
	public static void makeTransfer(String hardCodeUserID, int changeNumber, int numberPointsLeft, int start) throws IOException
	{
		makeTransferClass execute = new makeTransferClass();
		execute.makeTransfer(hardCodeUserID, changeNumber, numberPointsLeft, start);
	}
}