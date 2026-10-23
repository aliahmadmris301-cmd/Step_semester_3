import java.util.*;
class Student{
    String roll,name;
    Student(String roll,String name){
        this.roll=roll;
        this.name=name;
    }
}
public class StudentClubRegistration{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Student> members=new HashMap<>();
        ArrayList<Boolean> results=new ArrayList<>();
        while(sc.hasNext()){
            String op=sc.next();
            String roll=sc.next();
            String name=sc.next();
            if(op.equals("ADD")){
                if(members.containsKey(roll)){
                    System.out.println("duplicate rejected");
                }else{
                    members.put(roll,new Student(roll,name));
                    System.out.println("Added");
                }
            }else if(op.equals("CONTAINS")){
                results.add(members.containsKey(roll));
            }
        }
        System.out.println("member count "+members.size());
        for(boolean result:results){
            System.out.println("contains: "+result);
        }
        sc.close();
    }
}