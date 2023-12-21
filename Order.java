import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order 
{
    private User client;
    private List<Cart> Transactions;
    
    public Order(User user)
    {
        client=user;
        Transactions=new ArrayList<Cart>();
    }

    public List<Cart> getTransactions()
    {
        return Transactions;
    }

    public User getUser()
    {
        return client;
    }

    public void addTransaction(Cart completedOrder,Scanner scanner)
    {
        System.out.println("===== Payment =====");
        System.out.println("Total amount to pay: "+completedOrder.calculatePrice());

        System.out.print("Enter the amount to pay: $");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine();

        double totalAmountToPay = completedOrder.calculatePrice();
        if (paymentAmount >= totalAmountToPay) {
            double change = paymentAmount - totalAmountToPay;
            System.out.println("Payment successful!");
            if (change > 0) {
                System.out.println("Change: $" + change);
            }
            Cart transaction=completedOrder.clone();
            Transactions.add(transaction);
            completedOrder.emptyCart();
            
        } else {
            System.out.println("Insufficient payment. Please enter the correct amount.");
        }
    }
}
