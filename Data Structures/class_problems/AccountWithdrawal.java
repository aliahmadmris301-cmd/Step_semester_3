import java.util.*;
class Account{
    String id;
    int balance;
    Account(String id,int balance){
        this.id=id;
        this.balance=balance;
    }
    void withdraw(int amount){
    }
}
class Savings extends Account{
    Savings(String id,int balance){
        super(id,balance);
    }
    void withdraw(int amount){
        if(balance-amount<1000){
            System.out.println(id+" rejected: minimum balance 1000");
        }else{
            balance-=amount;
            System.out.println(id+" balance "+balance);
        }
    }
}
class Current extends Account{
    Current(String id,int balance){
        super(id,balance);
    }
    void withdraw(int amount){
        if(balance-amount<-5000){
            System.out.println(id+" rejected: overdraft limit 5000");
        }else{
            balance-=amount;
            System.out.println(id+" balance "+balance);
        }
    }
}
public class AccountWithdrawal{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Account> accounts=new HashMap<>();
        while(sc.hasNext()){
            String op=sc.next();
            if(op.equals("Savings")){
                String id=sc.next();
                int balance=sc.nextInt();
                accounts.put(id,new Savings(id,balance));
            } else if(op.equals("Current")){
                String id=sc.next();
                int balance=sc.nextInt();
                accounts.put(id,new Current(id,balance));
            } else if(op.equals("WITHDRAW")){
                String id=sc.next();
                int amount=sc.nextInt();
                if(accounts.containsKey(id)){
                    accounts.get(id).withdraw(amount);
                }else{
                    System.out.println("Account not found");
                }
            }
        }
        sc.close();
    }
}