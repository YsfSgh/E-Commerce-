public abstract class User
{
    private String username;
    private String password;
    private AuthenticationService AS;
    private boolean IsLoggedIn;
    private ProductManagement Products;
    private Cart currentCart;
    private Order clientOrder;

    public User(String username, String password, AuthenticationService AS,ProductManagement products) {
        this.username = username;
        this.password = password;
        this.IsLoggedIn=false;
        this.AS=AS;
        this.Products=products;
        this.currentCart=new Cart(this,Products);
        this.clientOrder=new Order(this);
    }

    public String getUsername() 
    {
        return username;
    }

    public Cart getCurrentCart() 
    {
        return currentCart;
    }

    public ProductManagement getProducts()
    {
        return Products;
    }

    public AuthenticationService getService()
    {
        return AS;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
    
    public void setStatus(boolean IsLoggedIn)
    {
        this.IsLoggedIn=IsLoggedIn;
    }

    public boolean getStatus()
    {
        return IsLoggedIn;
    }

    public Order getClientOrder()
    {
        return clientOrder;
    }
    public abstract String getRole();
    public abstract void displayProducts();
}