interface Seat{
    String getName();
    double getPrice();
}
class RegularSeat implements Seat{
    private String name;
    RegularSeat(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return 150;
    }
}
class PremiumSeat implements Seat{
    private String name;
    PremiumSeat(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return 250;
    }
}
class ReclinerSeat implements Seat{
    private String name;
    ReclinerSeat(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return 400;
    }
}
class Customer{
    String name;
    Customer(String name){
        this.name=name;
    }
}
class Show{
    private String time;
    private java.util.ArrayList<String> bookedSeats;
    Show(String time){
        this.time=time;
        bookedSeats=new java.util.ArrayList<>();
    }
    boolean isAvailable(Seat seat){
        return !bookedSeats.contains(seat.getName());
    }
    boolean bookSeat(Seat seat){
        if(!isAvailable(seat)){
            return false;
        }
        bookedSeats.add(seat.getName());
        return true;
    }
    void releaseSeat(Seat seat){
        bookedSeats.remove(seat.getName());
    }
}
class Booking{
    private Customer customer;
    private Show show;
    private java.util.ArrayList<Seat> seats;
    Booking(Customer customer,Show show){
        this.customer=customer;
        this.show=show;
        seats=new java.util.ArrayList<>();
    }
    void book(Seat[] selectedSeats){
        if(selectedSeats.length>6){
            System.out.println("Maximum 6 seats allowed.");
            return;
        }
        for(Seat seat:selectedSeats){
            if(!show.isAvailable(seat)){
                System.out.println("Seat "+seat.getName()+" is already booked for this show.");
                return;
            }
        }
        double total=0;
        for(Seat seat:selectedSeats){
            show.bookSeat(seat);
            seats.add(seat);
            total=total+seat.getPrice();
        }
        System.out.print("Booking confirmed for "+customer.name+": ");
        for(Seat seat:seats){
            System.out.print(seat.getName()+" ");
        }
        System.out.printf("%nTotal: ₹%.2f%n",total);
    }
    void cancel(){
        for(Seat seat:seats){
            show.releaseSeat(seat);
        }
        System.out.println(customer.name+"'s booking cancelled.");
        System.out.println("Seats released.");
    }
}
public class CampusPremiereTicketCounter{
    public static void main(String[] args){
        Show show=new Show("7 PM");
        Customer asha=new Customer("Asha");
        Customer ravi=new Customer("Ravi");
        Customer neha=new Customer("Neha");
        Seat a1=new RegularSeat("A1");
        Seat a2=new RegularSeat("A2");
        Seat f5=new PremiumSeat("F5");
        Seat r1=new ReclinerSeat("R1");
        Booking booking1=new Booking(asha,show);
        booking1.book(new Seat[] {a1,a2,f5});
        Booking booking2=new Booking(ravi,show);
        booking2.book(new Seat[] {a2});
        booking2.book(new Seat[] {r1});
        booking1.cancel();
        Booking booking3=new Booking(neha,show);
        booking3.book(new Seat[] {a2});
    }
}