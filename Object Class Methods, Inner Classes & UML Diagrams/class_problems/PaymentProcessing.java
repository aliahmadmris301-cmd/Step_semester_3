interface PaymentMethod{
    boolean processPayment();
}
class CreditCardPayment implements PaymentMethod{
    public boolean processPayment(){
        System.out.println("Credit Card payment successful.");
        return true;
    }
}
class PayPalPayment implements PaymentMethod{
    public boolean processPayment(){
        System.out.println("PayPal payment failed.");
        return false;
    }
}
class Product{
    String name;
    int price;
    Product(String name,int price){
        this.name=name;
        this.price=price;
    }
}
class Order{
    private String customer;
    private int total;
    private String status;
    Order(String customer){
        this.customer=customer;
        this.total=0;
        this.status="Pending";
    }
    void addProduct(Product product,int quantity){
        total=total+product.price*quantity;
    }
    void pay(PaymentMethod payment){
        if (total==0){
            System.out.println("Cannot process payment for an empty order.");
            return;
        }
        System.out.println("Payment initiated for "+customer);
        boolean success=payment.processPayment();
        if(success){
            status="Paid";
        }
        System.out.println("Order status: "+status);
    }
}
public class PaymentProcessing{
    public static void main(String[] args){
        Product productA=new Product("Product A", 100);
        Product productB=new Product("Product B", 200);
        Order order1=new Order("Customer X");
        order1.addProduct(productA,2);
        order1.addProduct(productB,1);
        order1.pay(new CreditCardPayment());
        Order order2=new Order("Customer Y");
        order2.pay(new CreditCardPayment());
        Product productC=new Product("Product C",300);
        Order order3=new Order("Customer Z");
        order3.addProduct(productC,1);
        order3.pay(new PayPalPayment());
    }
}