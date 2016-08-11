package baseball_scoring;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Scoring class prompts user to enter how many batters they would like to calculate and set's their names. Then they enter how many at bats
 * to track for each batter. We then populate the results of each at bat. After all at bats are entered for all players, the individual
 * players batting averages and slugging percentages are displayed. 
 */
public class Scoring {

	public static void main(String[] args) {
		// declare variables
		String playerName;
		int numAtBats;
		ArrayList<Batter> playerList = new ArrayList<>();// arrayList to hold
															// batter objects
															// created by the
															// user and their
															// individual stats

		int numBatters = getNumBatters();// calls method to prompt user and
											// capture number of batters they
											// would like to enter, returns
											// number of batters if valid entry

		// loop to prompt user to get names for all the new batters they would
		// like to enter
		for (int i = 0; i < numBatters; i++) {
			playerName = getBatterNames();// method call to return batter's name
											// as a String
			playerList.add(new Batter(playerName));//create new player object and store in playerList arrayList
		}
		System.out.println();
		
		//loop to get number of at bats, then results for each player
		for (int i = 0; i < numBatters; i++) {
			System.out.println("Let's enter the results for " + playerList.get(i).getBatterName() + ":");
			playerList.get(i).setNumAtBats();
		}
		
		//loop to call calculate methods and display statistics
		for (int i = 0; i < numBatters; i++) {
			System.out.println();
			playerList.get(i).calcBattingAverage();
			DecimalFormat numberFormat = new DecimalFormat("#.000");
			System.out.println(playerList.get(i).getBatterName() + "'s Batting Average: "
					+ numberFormat.format(playerList.get(i).getBattingAverage()));
			playerList.get(i).calcSluggingPercentage();
			System.out.println(playerList.get(i).getBatterName() + "'s Slugging Percentage: "
					+ numberFormat.format(playerList.get(i).getSluggingPercentage()));
		}
	}
	
	//method to prompt user to enter how many batters they would like to enter statistics for. After validation the method returns
	//the number of batters.
	public static int getNumBatters() {
		int numBatters = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("How many batters would you like to enter?");
		try {
			numBatters = sc.nextInt();

			if (numBatters > 0) {
				System.out.println("Okay, let's set up " + numBatters + " batters.");
				System.out.println();
			} else {
				System.out.println("Please enter a valid number of batters.");
				main(null);
			}

		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid integer greater than 0.");
			main(null);
		}

		return numBatters;

	}
	
	//Method to prompt user to enter batter names, returns the user input as String
	public static String getBatterNames() {
		String name = null;
		Scanner sq = new Scanner(System.in);
		System.out.println("Enter batter name:");
		name = sq.nextLine();

		return name;
	}

}
