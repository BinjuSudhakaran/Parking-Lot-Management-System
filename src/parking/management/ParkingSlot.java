package parking.management;

import java.util.Optional;

public class ParkingSlot 
{
	private final int slotId;
	private final String type;
	private Vehicle vehicle;
	private boolean booked=false;
	
	public ParkingSlot(int slotId, String type) 
	{
		//super();
		this.slotId = slotId;
		this.type = type;
	}
	public boolean isFree()
	{
		return vehicle== null;
	}
	public void parkVehicletoSlot(Vehicle vehicle)
	{
		this.vehicle=vehicle;
	}
	public void freeSlot()
	{
		this.vehicle=null;
	}
	public int getSlotId() 
	{
		return slotId;
	}
	public String getType()
	{
		return type;
	}
	public Optional<Vehicle> getVehicle()
	{
		return Optional.ofNullable(vehicle);
		
	}
	public void bookVehicletoSlot(Vehicle vehicle) 
	{
		this.vehicle=vehicle;
		
	}
	public void book(Vehicle vehicle)
	{
		
		
		this.booked=true;
		
		this.vehicle=vehicle;
	}
	public boolean isBooked()
	{
		return booked;
		
		
	}
public void unBook()
{
	this.booked=false;
}
}
