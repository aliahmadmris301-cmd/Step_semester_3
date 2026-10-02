abstract class Room{
    protected String roomNumber;
    protected boolean available;
    Room(String roomNumber){
        this.roomNumber=roomNumber;
        this.available=true;
    }
    abstract double calculatePrice(int days);
}
class StandardRoom extends Room{
    StandardRoom(String roomNumber){
        super(roomNumber);
    }
    double calculatePrice(int days){
        return days*100;
    }
}
class DeluxeRoom extends Room{
    DeluxeRoom(String roomNumber){
        super(roomNumber);
    }
    double calculatePrice(int days){
        return days*150;
    }
}
class Reservation{
    private Room room;
    private String customer;
    private int days;
    Reservation(Room room,String customer,int days){
        this.room=room;
        this.customer=customer;
        this.days=days;
    }
    void book(){
        if(room.available){
            room.available=false;
            System.out.println("Reservation confirmed for "+customer);
            System.out.println("Room: "+room.roomNumber);
            System.out.println("Price: $"+room.calculatePrice(days));
        }else{
            System.out.println("Room "+room.roomNumber+" is not available.");
        }
    }
    void cancel(){
        room.available=true;
        System.out.println("Reservation for "+customer+" cancelled successfully.");
        System.out.println("Room "+room.roomNumber+" is now available.");
    }
}
public class HotelBookingSystem{
    public static void main(String[] args){
        StandardRoom room101=new StandardRoom("101");
        Reservation reservation1=new Reservation(room101, "Customer A", 4);
        reservation1.book();
        Reservation reservation2=new Reservation(room101, "Customer B", 4);
        reservation2.book();
        reservation1.cancel();
        DeluxeRoom room201=new DeluxeRoom("201");
        Reservation reservation3=new Reservation(room201, "Customer C", 2);
        reservation3.book();
    }
}