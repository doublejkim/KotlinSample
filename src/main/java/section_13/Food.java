package section_13;

public class Food {

    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return this.name; }

    public int getPrice() { return this.price; }

    @Override
    public String toString() {
        return "name : " + this.name + ", price : " + this.price;
    }
}
