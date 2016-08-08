package baseball_scoring;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Scoring {

	public static void main(String[] args) {
		int numAtBats;
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
		System.out.println(playerList.get(0).atBatResults);
		//start
		playerList.get(0).calcBattingAverage();
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		System.out.println(numberFormat.format(playerList.get(0).getBattingAverage()));
		playerList.get(0).calcSluggingPercentage();
		System.out.println(numberFormat.format(playerList.get(0).getSluggingPercentage()));
		//finish
	}
	
	public static int getNumBatters(){
		int numBatters;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many batters would you like to enter?");
		numBatters = sc.nextInt();
		System.out.println("Okay, let's set up " + numBatters + " batters.");
		System.out.println();
		
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
