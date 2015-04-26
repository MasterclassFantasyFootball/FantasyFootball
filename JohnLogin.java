import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JohnLogin 
{
	public static void main(String[] args) throws IOException 
	{
		User user = getUsernamePassword();
		//JOHN EDIT passes correct user to classes
		String hardCodeUserID = user.username;
		String menuOption = "";
		if(user.type != 0 )
		{
			while((menuOption != null) && (!(menuOption.equals("0"))))
			{
				if(user.type == 1)
				{
					menuOption = getUserSelection( "Please make a selection from the list below...\n\n"+ "1. View Remaining League Fixtures\n" + "2. View League Statistics\n" + "3. View Previous Results\n" + "4. Manage Team\n" + "5. Make Transfer", 5);
					if (menuOption != null)
					{
						doAction(new RegisteredUser(user), Integer.parseInt(menuOption), hardCodeUserID);
					}
					
				}
			}		
		}
	}

	private static String getUserSelection(String menuOption, int choices)
	{
		menuOption += "\n\n0. Exit application.\n\n";

		boolean validInput = false;

		String selection = "";
		String menuChoicePattern = "[0-" + choices + "]{1}";
		String errorMessage = "Invalid menu selection.";
		errorMessage += "\n\nValid options are 0 to " + choices + " inclusive.";
		errorMessage += "\nSelect OK to retry";

		while(!(validInput))
		{
			selection = JOptionPane.showInputDialog(null, menuOption, "Master Class Fantasy Football", 3);
			if(selection == null || selection.matches(menuChoicePattern))
			{
				validInput = true;
			} 
			else
			{
				JOptionPane.showMessageDialog(null, errorMessage, "Error in user input", 2);
			}
		}
		return selection;
	}

	private static User getUsernamePassword() throws IOException 
	{
		int type = 0;
		String username = "";
		String password = "";
		boolean loggedIn = false;
		ArrayList<ArrayList<String>> usernamePassword = FileManip.Read("users.txt");

		JTextField usernameField = new JTextField();
		JTextField passwordField = new JPasswordField();

		Object[] message = {"Username:", usernameField, "Password:", passwordField};

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
			for(int i = 0; i < usernamePassword.get(0).size(); i++)
			{
				username = usernamePassword.get(0).get(i);
				password = usernamePassword.get(1).get(i);

				if (usernameField.getText().equals(username) && passwordField.getText().equals(password))
				{
					type = Integer.parseInt(usernamePassword.get(2).get(i));
					loggedIn = true;
					break;
				}
				
			}
			if (loggedIn)
			{
				System.out.println("Successfully logged in as " + getType(type));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Username or Password, please try again.");
			}
		}
		else
		{
			System.out.println("Login cancelled");
		}
		return new User(username, password, type);
	}

	private static String getType(int type)
	{
		switch(type)
		{
		case 1:
			return "RegisteredUser";
		case 2: 
			return "Admin";
		default:
			return "";
		}
	}

	private static void doAction(RegisteredUser user, int menuChoice, String hardCodeUserID) throws IOException
	{
		switch(menuChoice)
		{
		case 1: viewFixtures();
		break;
		
		case 2: viewStatistics();
		break;
		
		case 3: viewResults();
		break;
			
		case 4: manageTeam(hardCodeUserID);
		break;

		case 5: manageTransfers(hardCodeUserID);
		break;
		}
	}
	
	public static void manageTeam(String hardCodeUserID) throws IOException
	{
		manageTeamClass execute = new manageTeamClass();
		execute.manageTeam(hardCodeUserID);
	}
	
	public static void manageTransfers(String hardCodeUserID) throws IOException
	{
		manageTransfersClass execute = new manageTransfersClass();
		execute.manageTransfers(hardCodeUserID);
	}
	
	
	
	public static void viewStatistics() throws IOException
	{
		ViewStatistics execute = new ViewStatistics();
		execute.Statistics();
	}
	
	public static void viewResults() throws IOException
	{
		ArrayList<ArrayList<String>> teamsOrPlayers = FileManip.Read("PremiershipTeamsOrPlayers.txt");
		ArrayList<ArrayList<String>> fixtures = FileManip.Read("PremiershipFixtures.txt");
		ArrayList<ArrayList<String>> results = FileManip.Read("PremiershipResults.txt");
		
		ViewResults execute = new ViewResults();
		execute.ViewResultsPlayedToDate(teamsOrPlayers, fixtures, results);
	}
	
	public static void viewFixtures() throws IOException
	{
		ArrayList<ArrayList<String>> fixtures = FileManip.Read("PremiershipFixtures.txt");
		ArrayList<ArrayList<String>> teamsOrPlayers = FileManip.Read("PremiershipTeamsOrPlayers.txt");
		int fixturesPlayedToDate = 0;
		
		ViewFixtures execute = new ViewFixtures();
		execute.ViewRemainingFixtures(teamsOrPlayers,fixtures, fixturesPlayedToDate);
	}
}

	
	
