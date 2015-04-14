import java.io.*;
import java.util.*;

public class FileManip
{
	public static ArrayList<ArrayList<String>> Read(String fileName) throws IOException
	{
		ArrayList<ArrayList<String>> twoDimArray = new ArrayList<ArrayList<String>>();

		File inputFile = new File(fileName);
		String fileLine;
		String[] lineArray;

		if (inputFile.exists())
		{
			BufferedReader tempBufferedReader = new BufferedReader(new FileReader(fileName.toLowerCase()));
			fileLine = tempBufferedReader.readLine();
			if (fileLine != null)
			{
				String[] tempArray = fileLine.split(",");
				for(int i = 0; i < tempArray.length; i++)
				{
					twoDimArray.add(new ArrayList<String>());
				}
				tempBufferedReader.close();

				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toLowerCase()));
				while((fileLine = bufferedReader.readLine()) != null)
				{
					lineArray = fileLine.split(",");
					for(int i = 0; i < tempArray.length; i++)
					{
						twoDimArray.get(i).add(lineArray[i]);
					}
				}
				bufferedReader.close();
			}
			else
			{
				System.out.print("File " + fileName + " is empty.");
			}
		}
		else
		{
			System.out.print("File " + fileName + " not found on the system.");
		}
		return twoDimArray;
	}

	public static void Write(String fileName, String message) throws IOException
	{
		try
		{
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".csv", true)));
			output.print("\n" + message);
			output.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}