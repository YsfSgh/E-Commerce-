import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<Product> cartItems;
    private boolean isCompleted;
    private ProductManagement Products;
    private User client;

    public Cart(User client, ProductManagement products) {
        cartItems = new ArrayList<>();
        isCompleted = false;
        this.client=client;
        this.Products=products;
    }

    public void addToCart(Product product) {
        if (product.getQuantity()>0)
        {
            cartItems.add(product);
            System.out.println("Added '" + product.getName() + "' to the cart.");
            product.setQuantity(product.getQuantity()-1);
        }
        else System.out.println("Product unavailable.");

    }

    public void removeFromCart(Product product)
    {
        cartItems.remove(product);
        product.setQuantity(product.getQuantity()+1);
    }

    public void emptyCart()
    {
        cartItems.removeAll(cartItems);
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Items:");
            for (Product product : cartItems) {
                System.out.println("Name: " + product.getName() +", Price: $" + product.getPrice() );
            }
        }
    }

    public void completeOrder(Scanner scanner)
     {
        isCompleted = true;
        client.getClientOrder().addTransaction(this,scanner);
        System.out.println("Order completed. Thank you for shopping with us!");
    }

    public Cart clone()
    {
        Cart clone=new Cart(client, Products);
        clone.cartItems=this.cartItems;
        return clone;
    }

    public double calculatePrice()
    {
        double price=0;
        for (Product p:cartItems)price+=p.getPrice();
        return price;
    }
    public boolean isCompleted() 
    {
        return isCompleted;
    }
}
