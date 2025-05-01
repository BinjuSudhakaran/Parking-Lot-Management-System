package parking.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLotManager 
{
	private final List<ParkingSlot> slots;
	
	public ParkingLotManager(int carSlots,int bikeSlots)
	{
		slots=new ArrayList<>();
		
		for(int i=1;i<=carSlots;i++)
		{
			slots.add(new ParkingSlot(i,"car"));
			
		}
		for(int i=carSlots+1;i<=carSlots+bikeSlots;i++)
		{
			slots.add(new ParkingSlot(i,"bike"));
		}
	}
	public void parkVehicle(Vehicle vehicle) 
	{
		Optional <ParkingSlot>freeSlot=slots.stream().filter(v->v.getType().equals(vehicle.getType())&&v.isFree()).findFirst();

		if(freeSlot.isPresent())
		{
			freeSlot.get().parkVehicletoSlot(vehicle);
			
			System.out.println(vehicle.getType() + " parked at slot " + freeSlot.get().getSlotId());
		}
		else
		{
			System.out.println("No slots Available");
		}
		
	}
	public void leaveSlot(String leaveNumber) throws Exception
	{
		Optional <ParkingSlot> occupiedSlot=slots.stream().filter(v->v.getVehicle().get().getNumber().equals(leaveNumber)).findFirst();
		
		 if (occupiedSlot.isPresent())
		 {
	            occupiedSlot.get().freeSlot();
	            System.out.println("Slot " + occupiedSlot.get().getSlotId() + " is now free.");
		 }
		 else
		 {
			 throw new Exception("Not Found");
		 }
	}
	public void viewParkingStatus()
	{
		slots.forEach(s->{
			String status=s.isFree()?"Free":s.getVehicle().get().getNumber();
			System.out.println("Slot " + s.getSlotId() +":"+ s.getType() +":"+ status);
        });
	}
	public void searchVehicle(String vehicleNumber) throws Exception
	{
		Optional <ParkingSlot> occupiedSlot=slots.stream().filter(s->s.getVehicle().isPresent()&&s.getVehicle().get().getNumber().equals(vehicleNumber)).findFirst();
		if(occupiedSlot.isPresent())
		{
			System.out.println("Vehicle is at"+occupiedSlot.get().getSlotId());
		}
		else
		{
			throw new Exception("Not Found");
		}
		
	}
	public void groupParkedVehicle()
	{
		Map<String,List<Vehicle>> grouped=slots.stream().filter(s->s.getVehicle().isPresent()).map(s -> s.getVehicle().get()).collect(Collectors.groupingBy(s->s.getType()));
		
		grouped.forEach((type, vehicles) -> {
            System.out.println(type);
            vehicles.forEach(v -> System.out.println(" - " + v.getNumber()));
        });
		
	}
}

