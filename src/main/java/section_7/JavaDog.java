package section_7;

public class JavaDog extends JavaAnimal{

    public JavaDog(String name) {
        super(name, 4);
    }

    @Override
    public void speak() { System.out.println("멍멍"); }
}
