import java.util.Scanner;
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId=memberId;
        this.bookIds=bookIds.clone();
    }
    public String[] getBookIds() {
        return bookIds.clone();
    }
    public LoanReceipt withCorrectedBookId(
            int index, String newId) {
        String[] newBookIds=bookIds.clone();
        newBookIds[index]=newId;
        return new LoanReceipt(memberId, newBookIds);
    }
    public static String processNightlyCirculation(
            LoanReceipt[] receipts) {
        int processed=0;
        int nullSkipped=0;
        int referenceOnly=0;
        int regular=0;
        for (LoanReceipt receipt:receipts) {
            if (receipt==null){
                nullSkipped++;
               continue;
            }
            processed++;
            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }
        return processed+" processed | "+nullSkipped+" null skipped | "+referenceOnly+" reference-only | "+regular+" regular";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter number of books: ");
        int count = sc.nextInt();
        sc.nextLine();
        String[] books=new String[count];
        for (int i=0;i<count;i++) {
            System.out.print("Enter book ID "+(i+1)+": ");
            books[i]=sc.nextLine();
        }
        LoanReceipt receipt=new LoanReceipt(memberId, books);
        System.out.println("\nOriginal book IDs:");
        for (String id : receipt.getBookIds()) {
            System.out.println(id);
        }
        System.out.print("\nEnter index to correct: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new book ID: ");
        String newId = sc.nextLine();
        LoanReceipt corrected=receipt.withCorrectedBookId(index, newId);
        System.out.println("\nOriginal receipt:");
        for (String id:receipt.getBookIds()) {
            System.out.println(id);
        }
        System.out.println("\nCorrected receipt:");
        for (String id : corrected.getBookIds()) {
            System.out.println(id);
        }
        LoanReceipt[] receipts={
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };
        System.out.println("\nNightly circulation:");
        System.out.println(processNightlyCirculation(receipts));
        sc.close();
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt{
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}