public class Admin extends User 
{
    public Admin(String username, String password, AuthenticationService AS, ProductManagement products) 
    {
        super(username, password, AS, products);
    }

    public String getRole() 
    {
        return "Admin";
    }

    public void addProduct(Product produit)
    {
        this.getProducts().addProduct(produit);
    }

    public void removeProduct(Product product)
    {
        this.getProducts().removeProduct(product);
    }

    public void addProductQuantity(Product product, int Quantity)
    {
        this.getProducts().addProductQuantity(product, Quantity);
    }

    public void displayProducts()
    {
        this.getProducts().displayProducts();
    }
}