import java.util.Scanner;
public class BankReference{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter reference: ");
        String ref=sc.nextLine().trim();
        if (ref.length()!=14){
            System.out.println("Invalid: wrong length");
        } else{
            ref=ref.substring(0, 3).toUpperCase()+ref.substring(3);
            boolean letters=true;
            boolean digits=true;
            for (int i=0;i<3;i++){
                if (!Character.isLetter(ref.charAt(i))){
                    letters=false;
                }
            }
            for (int i=3;i<14;i++) {
                if (!Character.isDigit(ref.charAt(i))) {
                    digits=false;
                }
            }
            if (!letters){
                System.out.println("Invalid: bank code must be 3 letters");
            } else if (!digits){
                System.out.println("Invalid: body must contain digits");
            } else {
                String bank=ref.substring(0,3);
                String date=ref.substring(3,9);
                String seq=ref.substring(9);
                System.out.println("["+bank+"] DATE: "+date.substring(0, 2)+"/"+date.substring(2, 4)+"/" +date.substring(4)+" | SEQ: "+seq);
            }
        }
        sc.close();
    }
}