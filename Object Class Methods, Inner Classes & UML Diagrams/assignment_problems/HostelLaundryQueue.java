interface WashType{
    int getDuration();
    double getCharge();
    String getName();
}
class QuickWash implements WashType{
    public int getDuration(){
        return 30;
    }
    public double getCharge(){
        return 20;
    }
    public String getName(){
        return "Quick";
    }
}
class NormalWash implements WashType{
    public int getDuration(){
        return 45;
    }
    public double getCharge(){
        return 30;
    }
    public String getName(){
        return "Normal";
    }
}
class HeavyWash implements WashType{
    public int getDuration(){
        return 60;
    }
    public double getCharge(){
        return 45;
    }
    public String getName(){
        return "Heavy";
    }
}
class Student{
    String name;
    Student(String name){
        this.name=name;
    }
}
class WashingMachine{
    private String machineId;
    private boolean free;
    WashingMachine(String machineId){
        this.machineId=machineId;
        free=true;
    }
    void startWash(Student student,WashType wash){
        if(!free){
            System.out.println("Machine "+machineId+" is currently busy.");
            return;
        }
        free=false;
        System.out.println(wash.getName()+" wash started on "+machineId+" for "+student.name+" ("+wash.getDuration()+" min).");
        System.out.printf("Charge: ₹%.2f%n", wash.getCharge());
    }
    void completeWash(){
        if(!free){
            free=true;
            System.out.println(machineId+" cycle completed.");
            System.out.println(machineId+" is now free.");
        }
    }
}
public class HostelLaundryQueue{
    public static void main(String[] args){
        Student asha=new Student("Asha");
        Student ravi=new Student("Ravi");
        Student neha=new Student("Neha");
        WashingMachine m1=new WashingMachine("M1");
        WashingMachine m2=new WashingMachine("M2");
        m1.startWash(asha,new QuickWash());
        m1.startWash(ravi,new HeavyWash());
        m2.startWash(ravi,new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}