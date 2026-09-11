import java.util.Scanner;
public class AccessChecker {
    static String classifyAccess(String modifier, String context) {
        if (modifier.equals("private")) {
            if (context.equals("SAME_CLASS"))
                return "ALLOWED";
            return "DENIED";
        }
        if (modifier.equals("default")) {
            if (context.equals("SAME_CLASS")||context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            return "DENIED";
        }
        if (modifier.equals("protected")) {
            if (context.equals("SAME_CLASS")||context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            return "DENIED";
        }
        if (modifier.equals("public")) {
            return "ALLOWED";
        }
        return "DENIED";
    }
    static String summarizeBatch(String[][] attempts) {
        int allowed=0;
        int denied=0;
        for (int i=0;i<attempts.length;i++) {
            String result =classifyAccess(attempts[i][0],attempts[i][1]);
            if (result.equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }
        return "Allowed: "+allowed+" | Denied: "+denied;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter modifier: ");
        String modifier=sc.next();
        System.out.print("Enter context: ");
        String context=sc.next();
        System.out.println(classifyAccess(modifier, context));
        sc.close();
    }
}