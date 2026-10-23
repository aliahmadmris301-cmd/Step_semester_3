import java.util.Scanner;
public class RoundRobinGameTurns{
    static class Node{
        String name;
        Node next;
        Node(String name){
            this.name=name;
            this.next=null;
        }
    }
    static class CircularList{
        Node tail;
        void addLast(String name){
            Node newNode=new Node(name);
            if(tail==null){
                tail=newNode;
                tail.next=tail;
            }else{
                newNode.next=tail.next;
                tail.next=newNode;
                tail=newNode;
            }
        }
        void printTurns(int turns){
            if(tail==null){
                return;
            }
            Node current=tail.next;
            for(int i=0;i<turns;i++){
                System.out.print(current.name);
                if(i<turns-1){
                    System.out.print(" ");
                }
                current=current.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CircularList players=new CircularList();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            players.addLast(name);
        }
        int turns=sc.nextInt();
        players.printTurns(turns);
        sc.close();
    }
}