import java.util.Scanner;
public class TrafficSignalStreak{
    static void findLongestStreak(String signalLog){
        int currentLength=1;
        int longestLength=1;
        char longestColor=signalLog.charAt(0);
        for (int i=1;i<signalLog.length();i++){
            if (signalLog.charAt(i)==signalLog.charAt(i-1)){
                currentLength++;
            } else{
                currentLength=1;
            }
            if(currentLength>longestLength) {
                longestLength=currentLength;
                longestColor=signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '"+longestColor+"' repeated "+longestLength+" times");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter signal log: ");
        String signalLog=sc.nextLine();
        if (signalLog.length()>0) {
            findLongestStreak(signalLog);
        } else{
            System.out.println("Signal log cannot be empty.");
        }
        sc.close();
    }
}
