package section_7;

public abstract class JavaAnimal {

    protected final String name;
    protected final int legCount;

    public JavaAnimal(String name, int legCount) {
        this.name = name;
        this.legCount = legCount;
    }

    abstract public void speak();

    public String getName() { return this.name; }

    public int getLegCount() { return this.legCount; }
}
