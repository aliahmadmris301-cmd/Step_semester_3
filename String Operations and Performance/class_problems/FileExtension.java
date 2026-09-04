import java.util.Scanner;
public class FileExtension{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename=sc.nextLine();
        int dot=filename.lastIndexOf('.');
        if (dot==-1){
            System.out.println("Rejected - invalid file type");
        } else{
            String extension=filename.substring(dot+1);
            if (extension.equalsIgnoreCase("pdf")||extension.equalsIgnoreCase("docx")||extension.equalsIgnoreCase("zip")){
                System.out.println("Accepted");
            } else{
                System.out.println("Rejected - invalid file type");
            }
        }
        sc.close();
    }
}