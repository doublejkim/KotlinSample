package section_9;

public class JavaCharacter {

    private static final int MIN_LEVEL = 1;

    public static JavaCharacter newCharacter(String name) {
        return new JavaCharacter(name, MIN_LEVEL);
    }

    private String name;

    private int level;

     private JavaCharacter(String name, int level) {
         this.name = name;
         this.level = level;
     }

}
