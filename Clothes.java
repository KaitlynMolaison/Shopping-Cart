import java.util.*;

// Base class for Clothes
class Clothes {
    protected String type;
    protected Double price;

    public Clothes(String type, double price) {
        this.type = type;
        this.price = Double.valueOf(price);
    }

    public String getType() {
        return type;
    }

    public  Double getPrice() {
        return price;
    }
}

// Derived class for Shorts
class Shorts extends Clothes {
    private String size;

    public Shorts(String size, double v) {
        super("Shorts", 30.0);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

// Derived class for Dresses
class Dress extends Clothes {
    private String color;

    public Dress(String color, double v) {
        super("Dress", 70.0);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

// Derived class for Hats
class Hats extends Clothes {
    private String type;

    public Hats(String type, double v) {
        super("Hats", 25.0);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Class for shopping cart
class Cart {
    private HashMap<Clothes, Integer> items;

    public Cart() {
        items = new HashMap<Clothes, Integer>();
    }

    public void addItem(Clothes item) {
        Integer quantity = null;
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public void displayItems() {
        System.out.println("Items in cart:");
        for (Map.Entry<Clothes, Integer> entry : items.entrySet()) {
            Clothes item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + " x " + item.getType() + " - $" + item.getPrice());
            if (item instanceof Shorts) {
                System.out.println("Size: " + ((Shorts) item).getSize());
            } else if (item instanceof Dress) {
                System.out.println("Color: " + ((Dress) item).getColor());
            } else if (item instanceof Hats) {
                System.out.println("Type: " + ((Hats) item).getType());
            }
        }
    }


    public double getTotal() {
        double total = 0;
        int numItems = 0;
        int numShorts = 0;
        int numDresses = 0;
        int numHats = 0;

        for (Map.Entry<Clothes, Integer> entry : items.entrySet()) {
            Clothes item = entry.getKey();
            int quantity = entry.getValue();
            total = total + item.getPrice() * quantity;
            numItems += quantity;

            if (item instanceof Shorts) {
                numShorts += quantity;
            } else if (item instanceof Dress) {
                numDresses += quantity;
            } else if (item instanceof Hats) {
                numHats += quantity;
            }
        }

        // Apply discounts
        if (numShorts >= 2) {
            total -= numShorts * 0.15 * 30.0;
        }
        if (numDresses >= 2) {
            total -= numDresses * 0.25 * 70.0;
        }
        if (numHats >= 2) {
            int numHatDiscounts = numHats / 2;
            total -= numHatDiscounts * 25.0;
        }
        if (numItems >= 5) {
            total *= 0.95;
        }

        return total;
    }
}