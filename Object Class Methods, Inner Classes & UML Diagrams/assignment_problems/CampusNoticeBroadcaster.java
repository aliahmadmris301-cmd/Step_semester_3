interface NotificationChannel{
    void send(String studentName,String message);
}
class EmailChannel implements NotificationChannel{
    public void send(String studentName,String message){
        System.out.println("[Email → "+studentName+"] "+message);
    }
}
class SmsChannel implements NotificationChannel{
    public void send(String studentName,String message){
        System.out.println("[SMS → "+studentName + "] "+message);
    }
}
class AppChannel implements NotificationChannel{
    public void send(String studentName,String message){
        System.out.println("[App → "+studentName+"] "+message);
    }
}
class Student{
    String name;
    String department;
    java.util.ArrayList<NotificationChannel> channels;
    Student(String name,String department){
        this.name=name;
        this.department=department;
        channels=new java.util.ArrayList<>();
    }
    void addChannel(NotificationChannel channel){
        channels.add(channel);
    }
}
class Notice{
    String title;
    java.util.ArrayList<String> departments;
    Notice(String title,java.util.ArrayList<String> departments){
        if(title==null||title.isEmpty()){
            throw new IllegalArgumentException("Notice title is required.");
        }
        if(departments==null||departments.size()==0){
            throw new IllegalArgumentException("At least one target department is required.");
        }
        this.title=title;
        this.departments=departments;
    }
}
class NoticeBoard{
    private java.util.ArrayList<Student> students;
    NoticeBoard(){
        students=new java.util.ArrayList<>();
    }
    void addStudent(Student student){
        students.add(student);
    }
    void postNotice(Notice notice){
        System.out.println("Notice '"+notice.title+"' posted.");
        for(Student student:students){
            if(notice.departments.contains(student.department)){
                for (NotificationChannel channel:student.channels){
                    channel.send(student.name,notice.title);
                }
            }
        }
    }
}
public class CampusNoticeBroadcaster{
    public static void main(String[] args){
        Student asha=new Student("Asha","CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());
        Student ravi=new Student("Ravi","ECE");
        ravi.addChannel(new SmsChannel());
        NoticeBoard board=new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);
        java.util.ArrayList<String> cse=new java.util.ArrayList<>();
        cse.add("CSE");
        Notice notice1=new Notice("Lab Closed Tomorrow",cse);
        board.postNotice(notice1);
        java.util.ArrayList<String> departments=new java.util.ArrayList<>();
        departments.add("CSE");
        departments.add("ECE");
        Notice notice2=new Notice("Fee Deadline Extended",departments);
        board.postNotice(notice2);
        try{
            java.util.ArrayList<String> empty=new java.util.ArrayList<>();
            Notice notice3=new Notice("Sports Day",empty);
            board.postNotice(notice3);
        }catch(IllegalArgumentException e){
            System.out.println("Cannot post notice: "+e.getMessage());
        }
    }
}