import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.println("Welcome to the shopping cart!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add item");
            System.out.println("2. Display cart");
            System.out.println("3. Purchase");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose item:");
                    System.out.println("1. Shorts");
                    System.out.println("2. Dress");
                    System.out.println("3. Hat");

                    int itemChoice = input.nextInt();
                    Clothes item = null;

                    switch (itemChoice) {
                        case 1:
                            item = new Shorts("Shorts", 25.0);
                            break;
                        case 2:
                            item = new Dress("Dress", 50.0);
                            break;
                        case 3:
                            item = new Hats("Hat", 15.0);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }

                    cart.addItem(item);
                    System.out.println(item.getType() + " added to cart.");
                    break;

                case 2:
                    cart.displayItems();
                    System.out.println("Total: $" + cart.getTotal());
                    break;

                case 3:
                    System.out.println("Thank you for your purchase!");
                    System.out.println("Total: $" + cart.getTotal());
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}

