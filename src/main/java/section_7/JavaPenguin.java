package section_7;

public class JavaPenguin extends JavaAnimal implements JavaFlyable, JavaSwimmable {

    private final int wingCount;

    public JavaPenguin(String name) {
        super(name, 2);
        this.wingCount = 2;
    }

    @Override
    public void speak() { System.out.println("짹~"); }

    @Override
    public int getLegCount() {
        return super.legCount + this.wingCount;
    }

    @Override
    public void doIt() {
        JavaFlyable.super.doIt();
        JavaSwimmable.super.doIt();
    }
}
