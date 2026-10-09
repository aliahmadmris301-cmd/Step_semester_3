public class ClassTopperFinder{
    public static void main(String[] args){
        int[][] marks={
            {78,85,90},
            {88,92,79},
            {65,70,95}
        };
        int bestRow=0;
        int bestTotal=0;
        for(int i=0;i<marks.length;i++){
            int total=0;
            for(int j=0;j<marks[i].length;j++){
                total+=marks[i][j];
            }
            if(i==0||total>bestTotal){
                bestTotal=total;
                bestRow=i;
            }
        }
        System.out.println("("+bestRow+", "+bestTotal+")");
    }
}