import java.util.*;
class Staff{
    String name,type;
    int pay;
    Staff(String name,String type,int pay){
        this.name=name;
        this.type=type;
        this.pay=pay;
    }
    void display(){
        System.out.println("Payslip[name="+name+", type="+type+", pay="+pay+"]");
    }
}
class FullTime extends Staff{
    FullTime(String name,int salary){
        super(name,"FullTime",salary);
    }
}
class PartTime extends Staff{
    PartTime(String name,int hours,int rate){
        super(name,"PartTime",hours*rate);
    }
}
class Intern extends Staff{
    Intern(String name,int stipend){
        super(name,"Intern",stipend);
    }
}
public class PayrollRegisterSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Staff> staffList=new ArrayList<>();
        while(sc.hasNext()){
            String type=sc.next();
            String name=sc.next();
            if(type.equals("FullTime")){
                int salary=sc.nextInt();
                staffList.add(new FullTime(name,salary));
            }else if(type.equals("PartTime")){
                int hours=sc.nextInt();
                int rate=sc.nextInt();
                staffList.add(new PartTime(name,hours,rate));
            }else if(type.equals("Intern")){
                int stipend=sc.nextInt();
                staffList.add(new Intern(name,stipend));
            }
        }
        int total=0;
        int top=0;
        for(int i=0;i<staffList.size();i++){
            Staff s=staffList.get(i);
            s.display();
            total+=s.pay;
            if(s.pay>staffList.get(top).pay)
                top=i;
        }
        System.out.println("Total "+total);
        if(!staffList.isEmpty())
            System.out.println("top earner "+staffList.get(top).name);
        sc.close();
    }
}