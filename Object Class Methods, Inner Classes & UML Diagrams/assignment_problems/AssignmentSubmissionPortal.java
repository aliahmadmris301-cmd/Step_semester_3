abstract class Assignment{
    protected String title;
    protected int maxMarks;
    protected int latePenalty;
    Assignment(String title,int maxMarks,int latePenalty){
        this.title=title;
        this.maxMarks=maxMarks;
        this.latePenalty=latePenalty;
    }
    int calculateMarks(int marks,int lateDays){
        int penalty=latePenalty*lateDays;
        int finalMarks=marks-(marks*penalty/100);
        return finalMarks;
    }
}
class CodingAssignment extends Assignment{
    CodingAssignment(String title,int maxMarks){
        super(title,maxMarks,10);
    }
}
class WrittenAssignment extends Assignment{
    WrittenAssignment(String title,int maxMarks){
        super(title,maxMarks,20);
    }
}
class Student{
    String name;
    Student(String name){
        this.name=name;
    }
}
class Submission{
    private Student student;
    private Assignment assignment;
    private int lateDays;
    private String status;
    Submission(Student student,Assignment assignment,int lateDays){
        this.student=student;
        this.assignment=assignment;
        this.lateDays=lateDays;
        status="Submitted";
    }
    void grade(int marks){
        if(!status.equals("Submitted")){
            System.out.println("Cannot grade this submission.");
            return;
        }
        int finalMarks=assignment.calculateMarks(marks,lateDays);
        status="Graded";
        System.out.println(student.name+" graded: "+finalMarks+"/"+assignment.maxMarks);
        System.out.println("Status: Graded.");
    }
    void resubmit(){
        if(status.equals("Graded")){
            System.out.println("Cannot resubmit: '"+assignment.title+"' has already been graded.");
        }else{
            System.out.println("Resubmission allowed.");
        }
    }
}
public class AssignmentSubmissionPortal{
    public static void main(String[] args){
        Student asha=new Student("Asha");
        Student ravi=new Student("Ravi");
        Assignment coding=new CodingAssignment("Linked List Lab", 50);
        Assignment written=new WrittenAssignment("Design Essay", 50);
        Submission s1=new Submission(asha,coding,0);
        System.out.println("Asha's submission for 'Linked List Lab' received (on time).");
        System.out.println("Status: Submitted.");
        Submission s2=new Submission(ravi,written,2);
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late).");
        System.out.println("Status: Submitted.");
        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}