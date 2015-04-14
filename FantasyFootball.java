
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FantasyFootball                                                          
{
    public static void main(String [] args) throws IOException          
    {

        int sportChoice;
        int submenuChoice;
        String menuOption = "";
        while((menuOption != null) && (!(menuOption.equals("0"))))
        {
            menuOption = getUserSelection("1. Fantasy Football", 1);
            if (menuOption != null)
            {
                sportChoice = Integer.parseInt(menuOption);
                while((menuOption != null) && (!(menuOption.equals("0"))))
                {
                    menuOption = getUserSelection("1. View a list of fixtures played to date and the outcome of these fixtures.\n2. Enter the outcome for a fixture.\n3. View a list of the fixtures yet to be played.\n4. View an up-to-date leaderboard for a league.", 4);
                    if (menuOption != null)
                    {
                        String teamsFilename = "";
                        String fixturesFilename = "";
                        String resultsFilename = "";
                        
                        if(sportChoice == 1)
                        {
                            teamsFilename = "PremiershipTeamsOrPlayers.txt";
                            fixturesFilename = "PremiershipFixtures.txt";
                            resultsFilename = "PremiershipResults.txt";
                        }
                       
                        
                        ArrayList<ArrayList<String>> fixtures = fileReader(fixturesFilename);
                        ArrayList<ArrayList<String>> teamsOrPlayers = fileReader(teamsFilename);
                        ArrayList<ArrayList<String>> results = fileReader(resultsFilename);
                        
                        submenuChoice = Integer.parseInt(menuOption);
                        switch(submenuChoice)
                        {
                            // 4 Options to choose from
                            case 1: ViewResultsPlayedToDate(teamsOrPlayers, fixtures, results);
                            break;
                            case 2: EnterOutcomeOfFixture(teamsOrPlayers, fixtures, results.get(0).size(), resultsFilename);
                            break;  
                            case 3: ViewRemainingFixtures(teamsOrPlayers, fixtures, results.get(0).size());
                            break;
                            case 4: ViewLeaderBoard(sportChoice, teamsOrPlayers, fixtures, results);
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public static String getUserSelection(String menuOption, int choices)
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
    
    public static void ViewResultsPlayedToDate(ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, ArrayList<ArrayList<String>> results)
    {
        for(int i = 0; i < results.get(0).size(); i++)
        {
            int homeTeam = Integer.parseInt(fixtures.get(1).get(i));
            int awayTeam = Integer.parseInt(fixtures.get(2).get(i));
            String homeTeamStr = teamsOrPlayers.get(1).get(homeTeam - 1);
            String awayTeamStr = teamsOrPlayers.get(1).get(awayTeam - 1);
            
            int homeResult = Integer.parseInt(results.get(1).get(i));
            int awayResult = Integer.parseInt(results.get(2).get(i));
            
            System.out.printf("%s %s - %s %s\n", homeTeamStr, homeResult, awayResult, awayTeamStr); 
        }
    }
    
    public static void EnterOutcomeOfFixture(ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, Integer fixturesPlayedToDate, String resultsFilename)
    {
        if(fixturesPlayedToDate != fixtures.get(0).size())
        {
            int gameNumber = Integer.parseInt(fixtures.get(0).get(fixturesPlayedToDate));
            int homeTeam = Integer.parseInt(fixtures.get(1).get(fixturesPlayedToDate));
            int awayTeam = Integer.parseInt(fixtures.get(2).get(fixturesPlayedToDate));
            String homeTeamStr = teamsOrPlayers.get(1).get(homeTeam - 1);
            String awayTeamStr = teamsOrPlayers.get(1).get(awayTeam - 1);
            
            System.out.print("Please input the result for game " + gameNumber + ": "+ homeTeamStr + " v " + awayTeamStr + "\n");
            
            System.out.print(homeTeamStr + " score:");
            
            Scanner reader = new Scanner(System.in);
            int homeScore = reader.nextInt();
            
            System.out.print(awayTeamStr + " score:");
            int awayScore = reader.nextInt();
            
            reader.close();
            
            try {
                PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(resultsFilename, true)));
                output.print("\n" + gameNumber + "," + homeScore + "," + awayScore);
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "This league is complete!", "Notification", 2);
        }
    }
    
    public static void ViewRemainingFixtures(ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, Integer fixturesPlayedToDate)
    {
        if(fixturesPlayedToDate != fixtures.get(0).size())
        {
            for(int i = fixturesPlayedToDate; i < fixtures.get(0).size(); i++)
            {
                int homeTeam = Integer.parseInt(fixtures.get(1).get(i));
                int awayTeam = Integer.parseInt(fixtures.get(2).get(i));
                String homeTeamStr = teamsOrPlayers.get(1).get(homeTeam - 1);
                String awayTeamStr = teamsOrPlayers.get(1).get(awayTeam - 1);

                System.out.printf("%s v %s\n", homeTeamStr, awayTeamStr);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "This league is complete!", "Notification", 2);
        }
    }
    
    public static void ViewLeaderBoard(Integer sportChoice, ArrayList<ArrayList<String>> teamsOrPlayers, ArrayList<ArrayList<String>> fixtures, ArrayList<ArrayList<String>> results)
    {
        
        try
        {
            ArrayList<ArrayList<String>> leagueInfo = fileReader("General.txt");

            Formatter formatter = new Formatter();
            System.out.println(formatter.format("%20s %20s       %20s %20s %20s %20s %20s %20s %20s %20s", "Position", "Team", "Played", "Win", "Draw", "Loss", "For", "Against", "Goal Diff", "Points"));
            formatter.close();
            
            ArrayList<ArrayList<Integer>> tableData = CreateEmptyTable();

            int position;
            int teamId = 0;
            int played = 0;
            int win = 0;
            int draw = 0;
            int loss = 0;
            int goalsFor = 0;
            int goalsAgainst = 0;
            int goalDifference = 0;
            int points = 0;
            
            for(int j = 0; j < teamsOrPlayers.get(0).size(); j++)
            {
                //Calculate Team
                teamId = Integer.parseInt(teamsOrPlayers.get(0).get(j));
                
                for(int i = 0; i < results.get(0).size(); i++)
                {
                    //Calculate Played
                    if(fixtures.get(1).get(i).equals(teamsOrPlayers.get(0).get(j)))
                    {
                        played++;
                        if(Integer.parseInt(results.get(1).get(i)) > Integer.parseInt(results.get(2).get(i)))
                        {
                            win++;
                        }
                        else if(Integer.parseInt(results.get(1).get(i)) < Integer.parseInt(results.get(2).get(i)))
                        {
                            loss++;
                        }
                        else
                        {
                            draw++;
                        }
                        goalsFor += Integer.parseInt(results.get(1).get(i));
                        goalsAgainst += Integer.parseInt(results.get(2).get(i));
                    }
                    
                    if(fixtures.get(2).get(i).equals(teamsOrPlayers.get(0).get(j)))
                    {
                        played++;
                        //Calculate Win
                        if(Integer.parseInt(results.get(2).get(i)) > Integer.parseInt(results.get(1).get(i)))
                        {
                            win++;
                        }
                        //Calculate Loss
                        else if(Integer.parseInt(results.get(2).get(i)) < Integer.parseInt(results.get(1).get(i)))
                        {
                            loss++;
                        }
                        //Calculate Draw
                        else
                        {
                            draw++;
                        }
                        // Calculate For & Against
                        goalsFor += Integer.parseInt(results.get(2).get(i));
                        goalsAgainst += Integer.parseInt(results.get(1).get(i));
                    }
                }

                //Calculate Goal Diff
                goalDifference = goalsFor - goalsAgainst;
                
                //Calculate Points
                if(sportChoice == 1)
                {
                    points = (win * Integer.parseInt(leagueInfo.get(0).get(1))) + draw;
                }
                else if (sportChoice == 2)
                {
                    points = (win * Integer.parseInt(leagueInfo.get(1).get(1))) + draw;
                }
                else if (sportChoice == 3)
                {
                    points = (goalsFor + played);
                }
                
                tableData.get(0).add(teamId);
                tableData.get(1).add(played);
                tableData.get(2).add(win);
                tableData.get(3).add(draw);
                tableData.get(4).add(loss);
                tableData.get(5).add(goalsFor);
                tableData.get(6).add(goalsAgainst);
                tableData.get(7).add(goalDifference);
                tableData.get(8).add(points);
                
                //Reset for new team
                played = 0;
                win = 0;
                draw = 0;
                loss = 0;
                goalsFor = 0;
                goalsAgainst = 0;
                goalDifference = 0;
                points = 0;
            }
            
            tableData = SortTable(tableData);
            
            for (int i = 0; i < teamsOrPlayers.get(0).size(); i++) {
                formatter = new Formatter();
                position = i + 1;
                teamId = tableData.get(0).get(i);
                played = tableData.get(1).get(i);
                win = tableData.get(2).get(i);
                draw = tableData.get(3).get(i);
                loss = tableData.get(4).get(i);
                goalsFor = tableData.get(5).get(i);
                goalsAgainst = tableData.get(6).get(i);
                goalDifference = tableData.get(7).get(i);
                points = tableData.get(8).get(i);
                
                System.out.println(formatter.format("%20s      %20s %20s %20s %20s %20s %20s %20s %20s %20s", position, teamsOrPlayers.get(1).get(teamId - 1), played, win, draw, loss, goalsFor, goalsAgainst, goalDifference, points));
            }
            formatter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static ArrayList<ArrayList<Integer>> CreateEmptyTable()
    {
        //Creating an empty table
        ArrayList<ArrayList<Integer>> emptyTable = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 9; i++)
        {
            emptyTable.add(new ArrayList<Integer>());
        }
        return emptyTable;
    }
    
    public static ArrayList<ArrayList<Integer>> SortTable(ArrayList<ArrayList<Integer>> tableData)
    {
        // Getting a sorted table with info
        int highestPoints = 0;
        int teamId = 0;
        int teamsProcessed = 0;
        ArrayList<ArrayList<Integer>> sortedTable = CreateEmptyTable();
        for(int i = 0; i < tableData.get(8).size(); i++)
        {
            if(teamsProcessed >= tableData.get(8).size())
            {
                break;
            }
            i = 0;
            highestPoints = tableData.get(8).get(i);
            teamId = tableData.get(0).get(i);
            for(int j = i + 1; j < tableData.get(8).size(); j++)
            {
                if(highestPoints < tableData.get(8).get(j))
                {
                    highestPoints = tableData.get(8).get(j);
                    teamId = tableData.get(0).get(j);
                }
            }
            
            for (int k = 0; k < 9; k++)
            {
                sortedTable.get(k).add(tableData.get(k).get(teamId - 1));
                tableData.get(k).set(teamId - 1, 0);
            }
            teamsProcessed++;
        }
        
        return sortedTable;
    }
    
    public static ArrayList<ArrayList<String>> fileReader(String fileName) throws IOException
    {
        // Reading of the text files
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
}