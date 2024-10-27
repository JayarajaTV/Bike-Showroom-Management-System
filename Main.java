import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
    }
}

abstract class Management {
    protected Scanner scanner = new Scanner(System.in);

    abstract void displayMenu();
}

class Menu {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("==============================");
        System.out.println("   BIKE SHOWROOM MANAGEMENT  ");
        System.out.println("==============================");

        System.out.println("1) Inventory Management");
        System.out.println("2) Customer Management");
        System.out.println("3) Order Bike \n");
        System.out.print("Enter your option: ");
        int userOption = scanner.nextInt();

        switch (userOption) {
            case 1:
                new InventoryManagement().displayMenu();
                break;
            case 2:
                new CustomerManagement().displayMenu();
                break;
            case 3:
                new Order().displayMenu();
                break;
            default:
                System.out.println("Enter a valid option ");
                display(); // Recursion
        }
        scanner.close();
    }
}

class InventoryManagement extends Management {
    private List<Bike> bikeList = new ArrayList<>();

    InventoryManagement() {
        initializeDefaultBikes();
    }

    void displayMenu() {
        System.out.println(" ");
        System.out.println(" ============================    ");
        System.out.println(" INVENTORY MANAGEMENT OPTIONS  ");
        System.out.println(" ============================   ");
        System.out.println("1--> Add new bikes ");
        System.out.println("2--> Update bike details");
        System.out.println("3--> Remove bikes from inventory");
        System.out.println("4--> View available bike details");
        System.out.println("5--> Back");
        System.out.println(" ");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addNewBike();
                break;
            case 2:
                updateBikeDetail();
                break;
            case 3:
                removeBike();
                break;
            case 4:
                displayDetails();
                break;
            case 5:
                new Menu().display();
                break;
            default:
                System.out.println("Enter a valid option ");
                displayMenu();
        }
    }

    void addNewBike() {
        System.out.println("Enter the bike name: ");
        String bikeName = scanner.next();

        System.out.println("Enter the bike model: ");
        String bikeModel = scanner.next();

        System.out.println("Enter the bike price: ");
        int bikePrice = scanner.nextInt();

        bikeList.add(new Bike(bikeName, bikeModel, bikePrice));
        System.out.println("<------ BIKE ADDED SUCCESSFULLY! ------>");
        displayMenu();
    }

    void updateBikeDetail() {
        System.out.println("Enter the bike name: ");
        String name = scanner.next();

        for (Bike bike : bikeList) {
            if (bike.getName().equals(name)) {
                System.out.println("Enter the new bike model: ");
                String newModelName = scanner.next();

                System.out.println("Enter the new bike price: ");
                int newBikePrice = scanner.nextInt();

                bike.setModel(newModelName);
                bike.setPrice(newBikePrice);
                System.out.println("<------ BIKE UPDATED SUCCESSFULLY ------->");
                return;
            }
        }
        System.out.println("Sorry...! -> Bike Name Not Found");
        displayMenu();
    }

    void removeBike() {
        System.out.println("Enter the bike name: ");
        String removeBikeName = scanner.next();

        bikeList.removeIf(bike -> bike.getName().equals(removeBikeName));
        System.out.println("<-------- Bike Removed Successfully ---------->");
        displayMenu();
    }

    void displayDetails() {
        System.out.println("   ");
        System.out.println(" BikeName        " + "   BikeModel     " + "    BikePrice  ");
        System.out.println(" -------------        -------------       -----------            ");
        for (Bike bike : bikeList) {
            System.out.println(bike.getName().toUpperCase() + "        " + bike.getModel().toUpperCase() + "        " + bike.getPrice());
        }
        displayMenu();
    }

    void initializeDefaultBikes() {
        bikeList.add(new Bike("Specialized Sirrus", "Hybrid Bike", 70000));
        bikeList.add(new Bike("Giant Defy Advance", "Road Bike", 90000));
        bikeList.add(new Bike("Santa Cruz Bronson", "Mountain Bike", 80000));
        bikeList.add(new Bike("Trek Domane SL 6657", "Road Bike", 120000));
    }
}

class CustomerManagement extends Management {
    private List<Customer> customerList = new ArrayList<>();

    CustomerManagement() {
        initializeDefaultCustomers();
    }

    void displayMenu() {
        System.out.println(" ");
        System.out.println(" ============================    ");
        System.out.println("  CUSTOMER MANAGEMENT OPTIONS  ");
        System.out.println(" ============================   ");
        System.out.println("1--> Add new customers ");
        System.out.println("2--> Remove customers");
        System.out.println("3--> Update customer details");
        System.out.println("4--> View customer details");
        System.out.println("5--> Back");
        System.out.println(" ");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addNewCustomer();
                break;
            case 2:
                removeCustomerDetail();
                break;
            case 3:
                updateCustomerDetail();
                break;
            case 4:
                displayCustomerDetails();
                break;
            case 5:
                new Menu().display();
                break;
            default:
                System.out.println("Enter a valid option ");
                displayMenu();
        }
    }

    void addNewCustomer() {
        System.out.println("Enter the customer name: ");
        String name = scanner.next();

        System.out.println("Enter the customer contact number: ");
        String contact = scanner.next();

        customerList.add(new Customer(name, contact));
        System.out.println("<---- New Customer Added Successfully ---->");
        displayMenu();
    }

    void removeCustomerDetail() {
        System.out.println("Enter the customer name: ");
        String customerName = scanner.next();

        customerList.removeIf(customer -> customer.getName().equals(customerName));
        System.out.println("<------ CUSTOMER REMOVED SUCCESSFULLY ------->");
        displayMenu();
    }

    void updateCustomerDetail() {
        System.out.println("Enter The Customer Name: ");
        String name = scanner.next();

        for (Customer customer : customerList) {
            if (customer.getName().equals(name)) {
                System.out.println("Enter The New Customer Name: ");
                String newName = scanner.next();

                System.out.println("Enter The New Contact Number: ");
                String newContact = scanner.next();

                customer.setName(newName);
                customer.setContact(newContact);
                System.out.println("<------ CUSTOMER DETAILS UPDATED SUCCESSFULLY ------->");
                return;
            }
        }
        System.out.println("Sorry...! -> Customer Name Not Found");
        displayMenu();
    }

    void displayCustomerDetails() {
        System.out.println("   ");
        System.out.println(" CustomerName        " + "      Contact Number     ");
        System.out.println(" -------------             -------------          ");
        for (Customer customer : customerList) {
            System.out.println(customer.getName().toUpperCase() + "                      " + customer.getContact().toUpperCase());
        }
        displayMenu();
    }

    void initializeDefaultCustomers() {
        customerList.add(new Customer("Sai", "6873479964"));
        customerList.add(new Customer("Kishor", "9150456788"));
        customerList.add(new Customer("Harish", "6366879945"));
        customerList.add(new Customer("Jacky", "6578443987"));
    }
}

class Order extends Management {
    private List<Ordering> orderList = new ArrayList<>();

    void displayMenu() {
        System.out.println("1--> Order Bike");
        System.out.println("2--> View Order Details");
        System.out.println("3--> Back");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                orderFunction();
                break;
            case 2:
                displayOrderDetails();
                break;
            case 3:
                new Menu().display();
                break;
            default:
                System.out.println("Enter a valid option ");
                displayMenu();
        }
    }

    void orderFunction() {
        System.out.println("Enter the bike name: ");
        String bikeName = scanner.next();

        System.out.println("Enter the bike model: ");
        String model = scanner.next();

        orderList.add(new Ordering(bikeName, model));
        System.out.println("Your bike is ordered!!!");
        System.out.println("------ Bike Details ------");
        System.out.println("Bike Name: " + bikeName);
        System.out.println("Bike Model: " + model);
        displayMenu();
    }

    void displayOrderDetails() {
        if (orderList.isEmpty()) {
            System.out.println("Oops... No Bike Orders..!");
        } else {
            for (Ordering order : orderList) {
                System.out.println("Bike Name: " + order.getBikeName() + " | Bike Model: " + order.getBikeModel());
            }
        }
        displayMenu();
    }
}

class Bike {
    private String name;
    private String model;
    private int price;

    public Bike(String name, String model, int price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

class Ordering {
    private String bikeName;
    private String bikeModel;

    public Ordering(String bikeName, String bikeModel) {
        this.bikeName = bikeName;
        this.bikeModel = bikeModel;
    }

    public String getBikeName() {
        return bikeName;
    }

    public String getBikeModel() {
        return bikeModel;
    }
}
