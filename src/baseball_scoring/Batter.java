package baseball_scoring;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Batter {
	double battingAverage;
	double sluggingPercentage;
	String batterName;
	int numAtBats;
	ArrayList<Integer> atBatResults = new ArrayList<>();
	
	public Batter(String name){
		batterName = name;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public double getSluggingPercentage() {
		return sluggingPercentage;
	}

	public String getBatterName() {
		return batterName;
	}

	public int getNumAtBats() {
		return numAtBats;
	}

	public void setNumAtBats(int numAtBats) {
		this.numAtBats = numAtBats;
	}
	
	public void getResults(){
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		int atBats=0;
		System.out.println("How many at bats would you like to enter for " + this.getBatterName() + ":");
		
		try{
			atBats = sn.nextInt();
		}catch(InputMismatchException d){
			System.out.println("Please enter a valid number greater than 0");
			getResults();
		}
			if (atBats>0){
				this.setNumAtBats(atBats);
				for(int i = 0; i<this.numAtBats; i++){
					int result = 0;
					System.out.println("Enter the result of at bat #" + (i+1));
					try{
					result = sc.nextInt();
					}catch(InputMismatchException f){
						System.out.println("Invalid entry, must be number. Please enter 0,1,2,3 or 4. Start over.");
						Scoring.main(null);
					}
					if(isValid(result)){
						this.atBatResults.add(result);
					}else{
						System.out.println("Invalid entry, please enter 0,1,2,3 or 4");
						i--;
					}
				}
			}else{
				System.out.println("Not a valid number of at bats");
				getResults();
			}
		
	}
	
	public void calcBattingAverage(){
		int numHits = 0;
		for(int i = 0; i<atBatResults.size(); i++){
			if(this.atBatResults.get(i)>0){
				numHits++;
			}
		}
		this.battingAverage = (((double)numHits)/((double)this.numAtBats));
	}
	
	public void calcSluggingPercentage(){
		int totalBases = 0;
		for (int i=0; i<atBatResults.size(); i++){
			totalBases = totalBases + atBatResults.get(i);
		}
		this.sluggingPercentage = (((double)totalBases)/((double)this.getNumAtBats()));
	}
	
	public static boolean isValid(int hitValue){
		boolean isValid = false;
		int[] validNums = {0,1,2,3,4};
		for (int i=0; i<validNums.length; i++){	
			if(hitValue == validNums[i]){
				isValid = true;
			}
		}
		return isValid;
	}
}
