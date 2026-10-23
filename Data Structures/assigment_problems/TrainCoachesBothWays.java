import java.util.Scanner;
public class TrainCoachesBothWays{
    static class Node{
        String name;
        Node prev,next;
        Node(String name){
            this.name=name;
            this.prev=null;
            this.next=null;
        }
    }
    static class DoublyLinkedList{
        Node head,tail;
        void addLast(String name){
            Node newNode=new Node(name);
            if(head==null){
                head=tail=newNode;
            }else{
                tail.next=newNode;
                newNode.prev=tail;
                tail=newNode;
            }
        }
        void remove(String name){
            Node current=head;
            while(current!=null&&!current.name.equals(name)){
                current=current.next;
            }
            if(current==null){
                return;
            }
            if(current==head){
                head=current.next;
            }else{
                current.prev.next=current.next;
            }
            if(current==tail){
                tail=current.prev;
            }else{
                current.next.prev=current.prev;
            }
        }
        void printForward(){
            Node current=head;
            System.out.print("Forward:");
            while(current!=null){
                System.out.print(current.name);
                if(current.next!=null){
                    System.out.print("<->");
                }
                current=current.next;
            }
            System.out.println();
        }
        void printBackward(){
            Node current=tail;
            System.out.print("Backward:");
            while(current!=null){
                System.out.print(current.name);
                if(current.prev!=null){
                    System.out.print("<->");
                }
                current=current.prev;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        DoublyLinkedList train=new DoublyLinkedList();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String coach=sc.nextLine();
            train.addLast(coach);
        }
        String removeName=sc.nextLine();
        train.remove(removeName);
        train.printForward();
        train.printBackward();
        sc.close();
    }
}