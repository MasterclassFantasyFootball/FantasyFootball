
public class User 
{
	protected String username;
	protected String password;
	protected int type;
	
	protected User(String username, String password, int type)
	{
		this.username = username;
		this.password = password;
		this.type = type;
	}
}