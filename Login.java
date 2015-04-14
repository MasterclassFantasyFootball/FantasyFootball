import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login 
{
	public static void main(String[] args) throws IOException 
	{
		User user = getUsernamePassword();

		String menuOption = "";

		if(user.type != 0 )
		{
			while((menuOption != null) && (!(menuOption.equals("0"))))
			{
				if(user.type == 1)
				{
					menuOption = getUserSelection("You have logged in successfully!", 1);
					if (menuOption != null)
					{
						doAction(new RegisteredUser(user), Integer.parseInt(menuOption));
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
			selection = JOptionPane.showInputDialog(null, menuOption, "Please make a selection from the list below...", 3);
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
		ArrayList<ArrayList<String>> usernamePassword = FileManip.Read("users.csv");

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

	private static void doAction(RegisteredUser User, int menuChoice) throws IOException
	{
		switch(menuChoice)
		{
		// This will be where we put our use cases for our RegisteredUser.
		}
	}

	

}