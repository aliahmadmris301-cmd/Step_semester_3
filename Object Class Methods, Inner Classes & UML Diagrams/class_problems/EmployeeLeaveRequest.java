abstract class Employee{
    protected String name;
    Employee(String name){
        this.name=name;
    }
    abstract boolean canTakeLeave(int days);
}
class FullTimeEmployee extends Employee{
    FullTimeEmployee(String name){
        super(name);
    }
    boolean canTakeLeave(int days){
        return days<=20;
    }
}
class PartTimeEmployee extends Employee{
    PartTimeEmployee(String name){
        super(name);
    }
    boolean canTakeLeave(int days){
        return days<=10;
    }
}
class LeaveRequest{
    private Employee employee;
    private int days;
    private String status;
    LeaveRequest(Employee employee,int days){
        this.employee=employee;
        this.days=days;
        this.status="Pending";
    }
    void approve(){
        if(status.equals("Pending")&&employee.canTakeLeave(days)){
            status="Approved";
            System.out.println(employee.name+"'s leave request approved.");
        }else{
            System.out.println("Cannot approve leave request.");
        }
    }
    void reject(){
        if(status.equals("Pending")){
            status="Rejected";
            System.out.println(employee.name+"'s leave request rejected.");
        }else{
            System.out.println("Cannot reject leave request.");
        }
    }
    void changeToPending(){
        if(!status.equals("Pending")){
            System.out.println("Cannot change leave request status from "+status+" to Pending.");
        }
    }
}
public class EmployeeLeaveRequest{
    public static void main(String[] args){
        FullTimeEmployee john=new FullTimeEmployee("John");
        PartTimeEmployee jane=new PartTimeEmployee("Jane");
        LeaveRequest request1=new LeaveRequest(john, 5);
        System.out.println("Leave request submitted for John. Status: Pending.");
        request1.approve();
        LeaveRequest request2=new LeaveRequest(jane, 2);
        System.out.println("Leave request submitted for Jane. Status: Pending.");
        request2.reject();
        request1.changeToPending();
    }
}