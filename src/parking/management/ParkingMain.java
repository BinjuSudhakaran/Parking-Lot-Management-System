package parking.management;

import java.util.Scanner;

public class ParkingMain {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		ParkingLotManager manager=new ParkingLotManager(5,5);
		while(true)
		{
			System.out.println("--------Welcome to Parking Lot Management System---------");
			System.out.println("1.Park Vehicle");
			System.out.println("2.Leave Slot");
			System.out.println("3.View Parking Status");
			System.out.println("4.Search Vehicle");
			System.out.println("5.Group Parked Vehicle");
		    System.out.println("6.Book Slot");
			System.out.println("7.Exit");
			System.out.println("Select your choice");
			int ch=sc.nextInt();
			//try
			//{
			switch(ch)
			{
				case 1:System.out.println("Enter type of vehicle(car/bike)");
					String type=sc.next();
					System.out.println("Enter vehicle number:");
					String number=sc.next();
					Vehicle vehicle=type.equalsIgnoreCase("car")?new Car(number):new Bike(number);
					manager.parkVehicle(vehicle);
					break;
				case 2:System.out.println("EntebrVehicle number ");
					String leaveNumber=sc.next();
					manager.leaveSlot(leaveNumber);
					break;
				case 3:manager.viewParkingStatus();
					break;
				case 4:System.out.println("Enter vehicle number:");
					String vehicleNumber=sc.next();
					manager.searchVehicle(vehicleNumber);
					break;
				case 5:manager.groupParkedVehicle();
					break;
				case 6:
					System.out.println("Enter your vehicle(car/bike) ");
					String bookType=sc.next();
					System.out.println("Enter your vehicle number:");
					String bookNumber=sc.next();
					Vehicle vehicle1=bookType.equalsIgnoreCase("car")?new Car(bookNumber):new Bike(bookNumber);
					manager.bookSlot(vehicle1);
					break;
				case 7:System.out.println("Exiting...");
               			break;
                default:
                    System.out.println("Invalid option.");	
			}
			//}
//		catch(Exception e)
//			{
//			System.out.println("Error");
//			}
	}

}
}
