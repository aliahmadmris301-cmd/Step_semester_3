class LibraryMember{
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;
    public LibraryMember(String memberId,int borrowLimit){
        if(memberId==null||memberId.trim().length()<4){
            throw new IllegalArgumentException("Invalid member ID");
        }
        this.memberId=memberId;
        this.borrowLimit=borrowLimit;
    }
    public void borrowBook(){
        booksBorrowed++;
    }
    public int getBooksBorrowed(){
        return booksBorrowed;
    }
    public void displayInfo(){
        System.out.println("General Member | Books Borrowed: "+booksBorrowed);
    }
}
class StudentMember extends LibraryMember{
    private String course;
    public StudentMember(String memberId,int borrowLimit,String course){
        super(memberId,borrowLimit);
        this.course=course;
    }
    public String getCourse(){
        return course;
    }
    @Override
    public void displayInfo(){
        System.out.println("Student Member | Course: "+course+" | Books Borrowed: "+getBooksBorrowed());
    }
}
class HonorsStudentMember extends StudentMember{
    private int bonusLimit;
    public HonorsStudentMember(String memberId,int borrowLimit,String course,int bonusLimit) {
        super(memberId,borrowLimit,course);
        this.bonusLimit=bonusLimit;
    }
    @Override
    public void displayInfo() {
        System.out.println("Honors Student Member | Course: "
                +getCourse()+" | Bonus Limit: "
                +bonusLimit+" | Books Borrowed: "
                +getBooksBorrowed());
    }
}
class FacultyMember extends LibraryMember{
    private String department;
    public FacultyMember(String memberId,int borrowLimit,String department){
        super(memberId,borrowLimit);
        this.department=department;
    }
    @Override
    public void displayInfo(){
        System.out.println("Faculty Member | Department: "
                +department+" | Books Borrowed: "
                +getBooksBorrowed());
    }
}
public class ThreeTiers{
    public static String classifyGeneration(LibraryMember member){
        if(member instanceof HonorsStudentMember){
            return "Multilevel descendant (3 generations deep)";
        }
        if(member instanceof FacultyMember){
            return "Hierarchical sibling (independent branch)";
        }
        return "Other";
    }
    public static int getTotalBooksBorrowed(LibraryMember[] members){
        int total=0;
        for(LibraryMember member:members){
            total+=member.getBooksBorrowed();
        }
        return total;
    }
    public static void main(String[] args){
        LibraryMember m1=new LibraryMember("STU1",3);
        StudentMember m2=new StudentMember("STU2",3,"CSE");
        HonorsStudentMember m3=new HonorsStudentMember("STU3",3,"ECE",2);
        FacultyMember m4 =new FacultyMember("STU4",5,"Physics");
        m1.displayInfo();
        m2.displayInfo();
        m3.displayInfo();
        m4.displayInfo();
        System.out.println(classifyGeneration(m3));
        System.out.println(classifyGeneration(m4));
        m2.borrowBook();
        m2.borrowBook();
        m3.borrowBook();
        m4.borrowBook();
        m4.borrowBook();
        m4.borrowBook();
        LibraryMember[] members={m2, m3, m4};
        System.out.println(getTotalBooksBorrowed(members));
    }
}