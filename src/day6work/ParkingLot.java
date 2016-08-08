package day6work;

public class ParkingLot {

	public static void main(String[] args) {
		Car myCar = new Car("Chevy", "Impala", "Silver");
		myCar.setNumWindows(6);
		myCar.setNumDoors(4);
		myCar.setRuns(true);
		System.out.println(myCar.getColor() + " " + myCar.getMake() + " " + myCar.getModel());
		System.out.println(myCar.getNumWindows() + " windows");
		System.out.println(myCar.getNumDoors() + " doors");
		System.out.println("The statement my car runs is " + myCar.isRuns());
		
		Car car2 = new Car("Toyota", "Corolla", "Blue");
		car2.setNumDoors(2);
		car2.setNumWindows(4);
		car2.setRuns(false);
		System.out.println(car2.getColor() + " " + car2.getMake() + " " + car2.getModel());
		System.out.println(car2.getNumWindows() + " windows");
		System.out.println(car2.getNumDoors() + " doors");
		System.out.println("The statement this car runs is " + car2.isRuns());
	}

}
