import java.util.Scanner;
public class InventoryCSVParser {
    void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",");
        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + data[0]);
            System.out.println("SKU: " + data[1]);
            System.out.println("Qty: " + data[2]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV Record: ");
        String csv = sc.nextLine();
        InventoryCSVParser obj = new InventoryCSVParser();
        obj.parseInventoryRecord(csv);
    }
}