import java.util.*;
import java.util.regex.*;
public class ClassMarksGridAnalysis{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> names=new ArrayList<>();
        ArrayList<int[]> marksList=new ArrayList<>();
        Pattern pattern=Pattern.compile("(\\w+)\\s*\\[\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\]");
        while(sc.hasNextLine()){
            String line=sc.nextLine().trim();
            if(line.isEmpty())
                continue;
            Matcher m=pattern.matcher(line);
            if(m.matches()){
                names.add(m.group(1));
                int[] marks={
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4))
                };
                marksList.add(marks);
            }
        }
        int n=names.size();
        if(n==0){
            sc.close();
            return;
        }
        int[] total=new int[n];
        int[] subjectTotal=new int[3];
        int topper=0;
        for(int i=0;i<n;i++){
            int[] marks=marksList.get(i);
            for (int j=0;j<3;j++){
                total[i]+=marks[j];
                subjectTotal[j]+=marks[j];
            }
            if(total[i]>total[topper])
                topper=i;
        }
        System.out.print("Totals");
        for(int i=0;i<n;i++){
            System.out.print(names.get(i)+" "+total[i]);
            if(i<n-1)
                System.out.print(",");
        }
        System.out.print("\naverages");
        for (int j=0;j<3;j++){
            System.out.printf("%.2f",(double) subjectTotal[j]/n);
            if(j<2)
                System.out.print(",");
        }
        System.out.println("\ntopper "+names.get(topper)+" ("+total[topper]+")");
        sc.close();
    }
}