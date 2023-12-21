import java.util.Scanner;

public class Client extends User
{
    public Client(String username, String password,AuthenticationService AS,ProductManagement products) 
    {
        super(username, password, AS, products);
    }

    public String getRole()
    {
        return "Client";
    }
    public void displayProducts()
    {
        this.getProducts().displayProducts();
    }
    public void displayCart() {
        this.getCurrentCart().displayCart();
    }

    public void addToCart(Product product) {
        this.getCurrentCart().addToCart(product);
    }

    public void completeOrder(Scanner scanner) {
        if (!this.getCurrentCart().isCompleted()) {
            this.getCurrentCart().completeOrder(scanner);
        } else {
            System.out.println("Order has already been completed.");
        }
    }
}