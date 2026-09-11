import java.util.Scanner;
public class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    public LibraryMember() {
    }
    public String getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(String id) {
        if (membershipId==null) {
            membershipId=id;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public boolean isPremiumMember() {
        return premiumMember;
    }
    public void setPremiumMember(boolean premium) {
        premiumMember=premium;
    }
    public void setSecurityAnswer(String answer) {
        if (answer!=null){
            securityAnswer=Integer.toHexString(answer.hashCode());
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LibraryMember member=new LibraryMember();
        System.out.print("Enter membership ID: ");
        String id=sc.nextLine();
        member.setMembershipId(id);
        System.out.print("Enter name: ");
        String name=sc.nextLine();
        member.setName(name);
        System.out.print("Is premium member? (true/false): ");
        boolean premium=sc.nextBoolean();
        member.setPremiumMember(premium);
        sc.nextLine();
        System.out.print("Enter security answer: ");
        String answer=sc.nextLine();
        member.setSecurityAnswer(answer);
        System.out.println("Membership ID: "+member.getMembershipId());
        System.out.println("Name: "+member.getName());
        System.out.println("Premium Member: "+member.isPremiumMember());
        sc.close();
    }
}