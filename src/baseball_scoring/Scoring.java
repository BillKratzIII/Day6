package baseball_scoring;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scoring {

	public static void main(String[] args) {
		String playerName;
		int numBatters = getNumBatters();
		ArrayList<Batter> playerList = new ArrayList<>();
		
		for(int i=0; i<numBatters; i++){
			playerName = getBatterNames();
			playerList.add(new Batter(playerName));
		}
		System.out.println();
		
		for(int i=0; i<numBatters; i++){ 
			System.out.println("Let's enter the results for " + playerList.get(i).getBatterName() + ":");
			playerList.get(i).getResults();
		}
		
		for (int i=0; i<numBatters; i++){
			System.out.println();
			playerList.get(i).calcBattingAverage();
			DecimalFormat numberFormat = new DecimalFormat("#.000");
			System.out.println(playerList.get(i).getBatterName() + "'s Batting Average: " + numberFormat.format(playerList.get(i).getBattingAverage()));
			playerList.get(i).calcSluggingPercentage();
			System.out.println(playerList.get(i).getBatterName() + "'s Slugging Percentage: " + numberFormat.format(playerList.get(i).getSluggingPercentage()));
		}
	}
	
	public static int getNumBatters(){
		int numBatters=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many batters would you like to enter?");
		try{
			numBatters = sc.nextInt();
		
			if (numBatters>0){	
				System.out.println("Okay, let's set up " + numBatters + " batters.");
				System.out.println();
			}else{
				System.out.println("Please enter a valid number of batters.");
				main(null);
			}
			
		}catch(InputMismatchException e){
			System.out.println("Please enter a valid integer greater than 0.");
			main(null);
		}
		
		return numBatters;
		
	}
	
	public static String getBatterNames(){
		String name = null;
		Scanner sq = new Scanner(System.in);
		System.out.println("Enter batter name:");
		name = sq.nextLine();
			
		return name;
	}

}
