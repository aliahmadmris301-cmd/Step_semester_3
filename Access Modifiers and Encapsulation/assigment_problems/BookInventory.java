import java.util.Scanner;
public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;
    public BookInventory(int copiesTotal) {
        if (copiesTotal<= 0||copiesTotal>500) {
            throw new IllegalArgumentException("Invalid number of copies");
        }
        this.copiesTotal=copiesTotal;
        this.copiesAvailable=copiesTotal;
    }
    public void checkOut() {
        if (copiesAvailable>0) {
            copiesAvailable--;
        }
    }
    public void checkIn() {
        if (copiesAvailable<copiesTotal) {
            copiesAvailable++;
        }
    }
    public int getCopiesAvailable() {
        return copiesAvailable;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter total copies: ");
        int total=sc.nextInt();
        BookInventory book=new BookInventory(total);
        System.out.print("Enter number of check-outs: ");
        int out=sc.nextInt();
        for (int i=0;i<out;i++) {
            book.checkOut();
        }
        System.out.println("Copies available: " + book.getCopiesAvailable());
        System.out.print("Enter number of check-ins: ");
        int in = sc.nextInt();
        for (int i = 0; i < in; i++) {
            book.checkIn();
        }
        System.out.println(
                "Copies available: "+book.getCopiesAvailable());
        sc.close();
    }
}