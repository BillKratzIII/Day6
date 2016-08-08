package day6work;

public class Car {
	private int numWindows;
	private int numDoors;
	private boolean runs;
	private String make;
	private String model;
	private String color;


	public Car(String manufacturer, String carModel, String carColor){
		make = manufacturer;
		model = carModel;
		color = carColor;
	}
	
	public void setNumWindows(int windows){
		numWindows = windows;
	}
	
	public int getNumWindows(){
		return numWindows;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumDoors() {
		return numDoors;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	public boolean isRuns() {
		return runs;
	}

	public void setRuns(boolean runs) {
		this.runs = runs;
	}
	
	

}
