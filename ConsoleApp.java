import java.util.Scanner;

public class ConsoleApp 
{
    private static ProductManagement productManagement = new ProductManagement();
    private static AuthenticationService authenticationService = new AuthenticationService();
    
    public void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        addSampleProducts();
        while (true) {
            System.out.println("===== Welcome to Youssef Sghairi's Virtu-Cart! =====");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginMenu(scanner);
                    break;
                case 2:
                    signupMenu(scanner);
                    break;
                case 3:
                    System.out.println("Thanks For Your Visit!\n Come Again Soon!\n===Exiting the application.===");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void loginMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== Login Menu =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Client Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin(scanner);
                    break;
                case 2:
                    clientLogin(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void adminLogin(Scanner scanner) {
        System.out.println("Admin Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User admin = authenticationService.login(username, password);

        if (admin != null && admin instanceof Admin) {
            adminMenu(scanner, (Admin) admin);
        } else {
            System.out.println("Invalid UserName/Password.");
        }
    }

    private static void clientLogin(Scanner scanner) {
        System.out.println("Client Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User client = authenticationService.login(username, password);

        if (client != null && client instanceof Client) {
            clientMenu(scanner, (Client) client);
        } else {
            System.out.println("Invalid UserName/Password.");
        }
    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Add Product Quantity");
            System.out.println("4. Display Products");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner, admin);
                    break;
                case 2:
                    removeProduct(scanner, admin);
                    break;
                case 3:
                    addProductQuantity(scanner, admin);
                    break;
                case 4:
                    admin.displayProducts();
                    break;
                case 5:
                    authenticationService.logout(admin);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void clientMenu(Scanner scanner, Client client) {
        while (true) {
            System.out.println("===== Client Menu =====");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Add to Cart");
            System.out.println("4. Complete Order");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterProductsByType(scanner);
                    break;
                case 2:
                    client.displayCart();
                    break;
                case 3:
                    addToCart(scanner, client);
                    break;
                case 4:
                    client.completeOrder(scanner);
                    break;
                case 5:
                    authenticationService.logout(client);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void addProduct(Scanner scanner, Admin admin) {
        System.out.println("Enter product details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product newProduct = new ClothingProduct(name, price, quantity, clothingTYPE.OTHER);
        admin.addProduct(newProduct);
    }

    private static void removeProduct(Scanner scanner, Admin admin) {
        System.out.print("Enter the name of the product to remove: ");
        String productName = scanner.nextLine();

        Product productToRemove = productManagement.findProductByName(productName);
        if (productToRemove != null) {
            admin.removeProduct(productToRemove);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addProductQuantity(Scanner scanner, Admin admin) {
        System.out.print("Enter the name of the product: ");
        String productName = scanner.nextLine();
        System.out.print("Enter quantity to add: ");
        int quantityToAdd = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = productManagement.findProductByName(productName);
        if (product != null) {
            admin.addProductQuantity(product, quantityToAdd);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addToCart(Scanner scanner, Client client) {
        System.out.print("Enter the name of the product to add to cart: ");
        String productName = scanner.nextLine();

        Product productToAdd = productManagement.findProductByName(productName);
        if (productToAdd != null) {
            client.addToCart(productToAdd);
        } else {
            System.out.println("Product not found.");
        }
    }
    private static void signupMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== Signup Menu =====");
            System.out.println("1. Admin Signup");
            System.out.println("2. Client Signup");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminSignup(scanner);
                    break;
                case 2:
                    clientSignup(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void adminSignup(Scanner scanner) {
        System.out.println("===== Admin Signup =====");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newAdmin = new Admin(username, password, authenticationService, productManagement);
        authenticationService.addUser(newAdmin);
    }

    private static void clientSignup(Scanner scanner) {
        System.out.println("===== Client Signup =====");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newClient = new Client(username, password, authenticationService, productManagement);
        authenticationService.addUser(newClient);
    }

   /*  private static void searchProductsByName(Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        Product foundProduct = productManagement.findProductByName(searchName);
        if (foundProduct != null) {
            System.out.println("Product found:");
            System.out.println("Name: " + foundProduct.getName() +
                    ", Price: $" + foundProduct.getPrice() +
                    ", Quantity: " + foundProduct.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }*/

    private static void filterProductsByType(Scanner scanner) {
        System.out.println("Filter products by type:");
        System.out.println("1. Clothing");
        System.out.println("2. Electronics");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                filterClothingProducts(scanner);
                break;
            case 2:
                filterElectronicsProducts(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void filterClothingProducts(Scanner scanner) {
        System.out.println("===== Clothing Products =====");
        System.out.println("Available Clothing Types:");
        for (clothingTYPE type : clothingTYPE.values()) {
            System.out.println(type.name());
        }
        System.out.print("Enter clothing type to filter: ");
        String inputType = scanner.nextLine();

        clothingTYPE selectedType;
        try {
            selectedType = clothingTYPE.valueOf(inputType.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid clothing type.");
            return;
        }
        System.out.println("Filtered Clothing Products - " + selectedType.name());
        for (Product product : productManagement.getProducts()) {
            if (product instanceof ClothingProduct) {
                ClothingProduct clothingProduct = (ClothingProduct) product;
                if (clothingProduct.getType() == selectedType) {
                    System.out.println("Name: " + clothingProduct.getName() +
                            ", Price: $" + clothingProduct.getPrice() +
                            ", Quantity: " + clothingProduct.getQuantity() +
                            ", Type: " + clothingProduct.getType());
                }
            }
        }
    }

    private static void filterElectronicsProducts(Scanner scanner) {
        System.out.println("===== Electronics Products =====");
    System.out.println("Available Electronics Types:");
    for (electronicsTYPE type : electronicsTYPE.values()) {
        System.out.println(type.name());
    }
    System.out.print("Enter electronics type to filter: ");
    String inputType = scanner.nextLine();

    electronicsTYPE selectedType;
    try {
        selectedType = electronicsTYPE.valueOf(inputType.toUpperCase());
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid electronics type.");
        return;
    }

    System.out.println("Filtered Electronics Products - " + selectedType.name());
    for (Product product : productManagement.getProducts()) {
        if (product instanceof ElectronicsProduct) {
            ElectronicsProduct electronicsProduct = (ElectronicsProduct) product;
            if (electronicsProduct.getType() == selectedType) {
                System.out.println("Name: " + electronicsProduct.getName() +
                        ", Price: $" + electronicsProduct.getPrice() +
                        ", Quantity: " + electronicsProduct.getQuantity() +
                        ", Type: " + electronicsProduct.getType());
            }
        }
    }
    }

    private static void addSampleProducts() {
        productManagement.addProduct(new ClothingProduct("Shirt", 25.99, 10, clothingTYPE.SHIRT));
        productManagement.addProduct(new ElectronicsProduct("Laptop", 899.99, 5, electronicsTYPE.LAPTOP));
        // Add more sample products as needed
    }
}
