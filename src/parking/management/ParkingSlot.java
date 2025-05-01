package parking.management;

import java.util.Optional;

public class ParkingSlot 
{
	private final int slotId;
	private final String type;
	private Vehicle vehicle;
	
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
	

}
