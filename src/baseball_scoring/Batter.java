package baseball_scoring;

import java.util.ArrayList;
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

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	public double getSluggingPercentage() {
		return sluggingPercentage;
	}

	public void setSluggingPercentage(double sluggingPercentage) {
		this.sluggingPercentage = sluggingPercentage;
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
		int atBats;
		System.out.println("How many at bats would you like to enter for " + this.getBatterName() + ":");
		atBats = sn.nextInt();
		this.setNumAtBats(atBats);
		for(int i = 0; i<this.numAtBats; i++){
			int result;
			System.out.println("Enter the result of at bat #" + (i+1));
			result = sc.nextInt();
			this.atBatResults.add(result);
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
}
