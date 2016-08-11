package baseball_scoring;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Class batter holds individual record of at bats and methods for objects of Batter class
 */
public class Batter {
	//declare variables
	double battingAverage;
	double sluggingPercentage;
	String batterName;
	int numAtBats;
	ArrayList<Integer> atBatResults = new ArrayList<>();//ArrayList to store each at bat result
	
	//Batter constructor
	public Batter(String name){
		batterName = name;
	}
	
	//method to return Batter's batting average
	public double getBattingAverage() {
		return battingAverage;
	}

	//method to return Batter's slugging percentage
	public double getSluggingPercentage() {
		return sluggingPercentage;
	}

	//method to return Batter's name
	public String getBatterName() {
		return batterName;
	}

	//method to prompt user and store number of at bats to get results for
	public void setNumAtBats() {
		Scanner sn = new Scanner(System.in);
		System.out.println("How many at bats would you like to enter for " + this.getBatterName() + ":");
		
		try{	//try to take in user input as an integer
			numAtBats = sn.nextInt();
		}catch(InputMismatchException d){	//catch error if user enters a non-integer, re-starts method
			System.out.println("Please enter a valid number greater than 0");
			setNumAtBats();
		}
		if (numAtBats>0){	//ensures user enters a valid number of at bats to track
			getResults(numAtBats);
		}else{
			System.out.println("Not a valid number of at bats");
			setNumAtBats();
		}
	}
	
	//method to return number of at bats for the Batter
	public int getNumAtBats() {
		return numAtBats;
	}
	
	//method to take in number of at bats for the Batter and collect the result of each individual at bat
	public void getResults(int atBats){
		Scanner sc = new Scanner(System.in);
		
		
			for(int i = 0; i<atBats; i++){
				String userInput = null;
				int result = 0;
				System.out.println("Enter the result of at bat #" + (i+1));
				userInput = sc.nextLine();
					
				if(isValid(userInput)){	//call method isValid to check that the user entered a valid result for that at bat
					result = Integer.parseInt(userInput);
					this.atBatResults.add(result);
				}else{	//if invalid entry, loop at same iteration until valid entry is received
					System.out.println("Invalid entry, please enter 0,1,2,3 or 4");
					i--;
				}
			}
		
	}
	
	//method to calculate batting average based on user inputed at bat results
	public void calcBattingAverage(){
		int numHits = 0;
		for(int i = 0; i<atBatResults.size(); i++){
			if(this.atBatResults.get(i)>0){
				numHits++;
			}
		}
		this.battingAverage = (((double)numHits)/((double)this.numAtBats));
	}
	
	//method to calculate slugging percentage based on user inputed at bat results
	public void calcSluggingPercentage(){
		int totalBases = 0;
		for (int i=0; i<atBatResults.size(); i++){
			totalBases = totalBases + atBatResults.get(i);
		}
		this.sluggingPercentage = (((double)totalBases)/((double)this.getNumAtBats()));
	}
	
	//method to check that an at bat entry is valid. First checks that an integer was entered, then compares the 
	//entry to a array of valid entries. Returns true of false.
	public static boolean isValid(String input){
		boolean isValid = false;
		int[] validNums = {0,1,2,3,4};
		int hitValue;
		
		try{
			hitValue = Integer.parseInt(input);
			for (int i=0; i<validNums.length; i++){	
				if(hitValue == validNums[i]){
					isValid = true;
				}
			}
		}catch (NumberFormatException e){
			
		}
		
		return isValid;
	}
}
