package parking.management;

public abstract class Vehicle 
{
	private String number;
	public Vehicle(String number)
	{
		//super();
		this.number = number;
	}
	public String getNumber() {
        return number;
    }
	abstract String getType();
}
class Car extends Vehicle
{

	public Car(String number) 
	{
		super(number);
	}

	@Override
	String getType() 
	{
		return "car";
	}
	
}
class Bike extends Vehicle
{

	public Bike(String number) 
	{
		super(number);
	}

	@Override
	String getType() 
	{
		return "bike";
	}
	
}

