abstract class Vehicle{
    protected String name;
    protected boolean available;
    Vehicle(String name){
        this.name=name;
        this.available=true;
    }
    abstract double calculateCharge(int days);
    void rent(){
        if(available){
            available=false;
            System.out.println(name+" rented successfully.");
        }else{
            System.out.println(name+" is currently unavailable.");
        }
    }
    void returnVehicle(){
        available=true;
        System.out.println(name+" returned successfully.");
    }
}
class Sedan extends Vehicle{
    Sedan(String name){
        super(name);
    }
    double calculateCharge(int days){
        return days*40;
    }
}
class SUV extends Vehicle{
    SUV(String name){
        super(name);
    }
    double calculateCharge(int days){
        return days*75;
    }
}
class Truck extends Vehicle{
    Truck(String name){
        super(name);
    }
    double calculateCharge(int days){
        return days*110;
    }
}
public class VehicleRentalSystem{
    public static void main(String[] args){
        Sedan sedan=new Sedan("Sedan A");
        SUV suv=new SUV("SUV B");
        sedan.rent();
        System.out.println("Rental charge: $"+sedan.calculateCharge(3));
        sedan.rent();
        sedan.returnVehicle();
        suv.rent();
        System.out.println("Rental charge: $"+suv.calculateCharge(5));
    }
}