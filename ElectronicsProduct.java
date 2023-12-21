public class ElectronicsProduct implements Product
{
    private String name;
    private double price;
    private int quantity;
    private electronicsTYPE type;

    public ElectronicsProduct(String name, double price, int quantity, electronicsTYPE type) 
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public electronicsTYPE getType() {
        return type;
    }
}

