import java.util.Scanner;
public class LibraryISBNValidator {
    String normalizeCode(String raw) {
        raw = raw.trim();
        if (raw.length() >= 3) {
            raw = raw.substring(0, 3).toUpperCase() + raw.substring(3);
        }
        return raw;
    }
    void validateAndFormat(String code) {
        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }
        // Check first 3 letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return;
            }
        }
        // Check remaining 10 digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Invalid: catalog/year must contain digits only");
                return;
            }
        }
        String year = code.substring(3, 7);
        String catalog = code.substring(7);
        StringBuilder output = new StringBuilder();
        output.append("[")
              .append(code.substring(0, 3))
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);
        System.out.println(output);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Code: ");
        String raw = sc.nextLine();
        LibraryISBNValidator obj = new LibraryISBNValidator();
        String code = obj.normalizeCode(raw);
        obj.validateAndFormat(code);
    }
}