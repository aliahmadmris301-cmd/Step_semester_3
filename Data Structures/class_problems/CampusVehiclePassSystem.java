import java.util.*;
interface Chargeable{
    void charge();
}
class Vehicle{
    String type,pass,owner;
    int fee;
    Vehicle(String type,String pass,String owner){
        this.type=type;
        this.pass=pass;
        this.owner=owner;
        if(type.equals("Bike")||type.equals("EBike"))
            fee=300;
        else
            fee=1000;
    }
    void display(){
        System.out.println(pass+" ("+type+") pass fee "+fee);
    }
}
class ElectricVehicle extends Vehicle implements Chargeable{
    ElectricVehicle(String type,String pass,String owner){
        super(type,pass,owner);
    }
    public void charge(){
        System.out.println(pass+" charging bay allotted");
    }
}
public class CampusVehiclePassSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Vehicle> vehicles=new HashMap<>();
        while(sc.hasNext()){
            String op=sc.next();
            if(op.equals("PASS")){
                String type=sc.next();
                String pass=sc.next();
                String owner=sc.next();
                Vehicle v;
                if(type.equals("ECar")||type.equals("EBike"))
                    v=new ElectricVehicle(type,pass,owner);
                else
                    v=new Vehicle(type,pass,owner);
                vehicles.put(pass,v);
                v.display();
            }else if(op.equals("CHARGE")){
                String pass=sc.next();
                Vehicle v=vehicles.get(pass);
                if(v==null){
                    System.out.println("Vehicle not found");
                }else if(v instanceof Chargeable){
                    ((Chargeable) v).charge();
                }else{
                    System.out.println(pass+" rejected: charging unsupported");
                }
            }
        }
        sc.close();
    }
}