import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
public class onRosterClass
{
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	public static ArrayList<String> teamName = new ArrayList<String>();
	public static ArrayList<String> onRoster = new ArrayList<String>();
	public static ArrayList<String> starPlayer = new ArrayList<String>();
	public static String details = "UsersTeams.txt";
	public static String line = "";
	public static String cvsSplitBy = ",";
	
	public void onRoster(String hardCodeUserID) throws IOException
	{
		List<Integer> changeNumbers = new ArrayList<>();
		ArrayList<String> list = new ArrayList<String>();
		//make 5 selections to take off roster
		Object [] selection = {"Goalkeeper 1", "Goalkeeper 2", "Defender 1", "Defender 2", "Defender 3", "Defender 4", "Defender 5",
			"Midfielder 1", "Midfielder 2", "Midfielder 3", "Midfielder 4", "Midfielder 5", "Forward 1", "Forward 2", "Forward 3" };
		for(int y = 0; y < 5; y++)
		{
			Object value = JOptionPane.showInputDialog(null, "Choose user type","", 1 , null, selection, selection[0]);
			
			if(value.equals("Goalkeeper 1"))
			{
				changeNumbers.add(1);
				//if duplicate selected puts back counter so five will be selected.
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Goalkeeper 1"))
					{
						y--;
					}
				}
				list.add("Goalkeeper 1");
			}
			else if(value.equals("Goalkeeper 2"))
			{
				changeNumbers.add(2);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Goalkeeper 2"))
					{
						y--;
					}
				}
				list.add("Goalkeeper 2");
			}
			else if(value.equals("Defender 1"))
			{
				changeNumbers.add(3);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Defender 1"))
					{
						y--;
					}
				}
				list.add("Defender 1");
			}
			else if(value.equals("Defender 2"))
			{
				changeNumbers.add(4);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Defender 2"))
					{
						y--;
					}
				}
				list.add("Defender 2");
			}
			else if(value.equals("Defender 3"))
			{
				changeNumbers.add(5);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Defender 3"))
					{
						y--;
					}
				}
				list.add("Defender 3");
			}
			else if(value.equals("Defender 4"))
			{
				changeNumbers.add(6);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Defender 4"))
					{
						y--;
					}
				}
				list.add("Defender 4");
			}
			else if(value.equals("Defender 5"))
			{
				changeNumbers.add(7);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Defender 5"))
					{
						y--;
					}
				}
				list.add("Defender 5");
			}
			else if(value.equals("Midfielder 1"))
			{
				changeNumbers.add(8);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Midfielder 1"))
					{
						y--;
					}
				}
				list.add("Midfielder 1");
			}
			else if(value.equals("Midfielder 2"))
			{
				changeNumbers.add(9);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Midfielder 2"))
					{
						y--;
					}
				}
				list.add("Midfielder 2");
			}
			else if(value.equals("Midfielder 3"))
			{
				changeNumbers.add(10);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Midfielder 3"))
					{
						y--;
					}
				}
				list.add("Midfielder 3");
			}
			else if(value.equals("Midfielder 4"))
			{
				changeNumbers.add(11);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Midfielder 4"))
					{
						y--;
					}
				}
				list.add("Midfielder 4");
			}
			else if(value.equals("Midfielder 5"))
			{
				changeNumbers.add(12);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Midfielder 5"))
					{
						y--;
					}
				}
				list.add("Midfielder 5");
			}
			else if(value.equals("Forward 1"))
			{
				changeNumbers.add(13);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Forward 1"))
					{
						y--;
					}
				}
				list.add("Forward 1");
			}
			else if(value.equals("Forward 2"))
			{
				changeNumbers.add(14);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Forward 2"))
					{
						y--;
					}
				}
				list.add("Forward 2");
			}
			else if(value.equals("Forward 3"))
			{
				changeNumbers.add(15);
				for(int t = 0; t < list.size(); t++)
				{
					String item = list.get(t);
					if (item.equals("Forward 3"))
					{
						y--;
					}
				}
				list.add("Forward 3");
			}
		}
		//gets data from file
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
		
		int start = position.indexOf(hardCodeUserID);
		for(int i = (start + 1); i < (start + 15); i++)
		{
			onRoster.set(i, "On");
		}
		for(int w = 0; w < changeNumbers.size(); w++)
		{
			onRoster.set((start + changeNumbers.get(w)), "Off");
		}
		
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