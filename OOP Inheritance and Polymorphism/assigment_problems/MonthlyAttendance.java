class GymMember{
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;
    public GymMember(String memberId,int monthlyFee){
        if(memberId==null||memberId.trim().length()<4){
            throw new IllegalArgumentException("Invalid member ID");
        }
        this.memberId=memberId;
        this.monthlyFee=monthlyFee;
    }
    public void attendSession(){
        sessionsAttended++;
    }
    public int getSessionsAttended(){
        return sessionsAttended;
    }
    public String displayInfo(){
        return "Standard | Sessions: "+sessionsAttended;
    }
}
class PremiumMember extends GymMember{
    private String trainerName;
    public PremiumMember(String memberId,int monthlyFee,String trainerName){
        super(memberId,monthlyFee);
        this.trainerName=trainerName;
    }
    public String getTrainerName(){
        return trainerName;
    }
    @Override
    public String displayInfo(){
        return "Premium | Trainer: "+trainerName+" | Sessions: "+getSessionsAttended();
    }
}
public class MonthlyAttendance{
    public static String batchPrint(GymMember[] members){
        StringBuilder result=new StringBuilder();
        for(GymMember member:members){
            result.append(member.displayInfo());
            if (member instanceof PremiumMember){
                PremiumMember p=(PremiumMember) member;
                result.append(" [Trainer via downcast: ");
                result.append(p.getTrainerName());
                result.append("]");
            }
            result.append(" | ");
        }
        return result.toString();
    }
    public static void main(String[] args){
        GymMember[] members={
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(members));
    }
}