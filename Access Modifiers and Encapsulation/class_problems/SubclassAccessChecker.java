import java.util.Scanner;
public class SubclassAccessChecker {
    static String classifyAccess(String modifier, String context) {
        if (modifier.equals("protected")) {
            if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";
            if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"))
                return "DENIED";
        }
        return "DENIED";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter modifier: ");
        String modifier=sc.next();
        System.out.print("Enter context: ");
        String context=sc.next();
        System.out.println(classifyAccess(modifier,context));
        sc.close();
    }
}