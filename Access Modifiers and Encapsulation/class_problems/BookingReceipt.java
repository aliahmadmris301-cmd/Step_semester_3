import java.util.Scanner;
public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    public BookingReceipt(String bookingId,String[] seatNumbers) {
        this.bookingId=bookingId;
        this.seatNumbers=seatNumbers.clone();
    }
    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }
    public BookingReceipt withUpdatedSeat(
            int index,String newSeat) {
        String[] newSeats=seatNumbers.clone();
        newSeats[index]=newSeat;
        return new BookingReceipt(
            bookingId,newSeats
        );
    }
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed=0;
        int nullSkipped=0;
        int group=0;
        int individual=0;
        for (BookingReceipt receipt:receipts) {
            if(receipt==null){
                nullSkipped++;
            }
            else{
                processed++;
                if (receipt instanceof GroupBookingReceipt) {
                    group++;
                }
                else {
                    individual++;
                }
            }
        }
        return processed+" processed | "
             +nullSkipped+" null skipped | "
             +group+" group | "
             +individual+" individual";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter booking ID: ");
        String id=sc.next();
        System.out.print("Enter number of seats: ");
        int n=sc.nextInt();
        String[] seats=new String[n];
        for (int i=0;i<n;i++) {
            System.out.print("Enter seat "+(i+1)+": ");
            seats[i]=sc.next();
        }
        BookingReceipt receipt=new BookingReceipt(id, seats);
        System.out.println("Original seats:");
        for (String seat : receipt.getSeatNumbers()) {
            System.out.print(seat+" ");
        }
        System.out.println();
        System.out.print("Enter seat index to update: ");
        int index=sc.nextInt();
        System.out.print("Enter new seat: ");
        String newSeat=sc.next();
        BookingReceipt updated=receipt.withUpdatedSeat(index, newSeat);
        System.out.println("Updated seats:");
        for (String seat : updated.getSeatNumbers()) {
            System.out.print(seat+" ");
        }
        System.out.println();
        BookingReceipt[] batch={
            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),
            null,
            receipt
        };
        System.out.println(processNightlySettlement(batch));
        sc.close();
    }
}
class GroupBookingReceipt extends BookingReceipt{
    private int groupSize;
    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize){
        super(bookingId,seatNumbers);
        this.groupSize=groupSize;
    }
}