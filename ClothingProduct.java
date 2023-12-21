public class ClothingProduct implements Product
{
    private String name;
    private double price;
    private int quantity;
    private clothingTYPE type;

    public ClothingProduct(String name, double price, int quantity, clothingTYPE type) 
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public clothingTYPE getType() 
    {
        return type;
    }
}