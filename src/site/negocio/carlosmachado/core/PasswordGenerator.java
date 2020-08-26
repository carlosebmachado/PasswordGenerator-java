package site.negocio.carlosmachado.core;

import java.util.Random;

public class PasswordGenerator {

    private static final Random rand = new Random(System.currentTimeMillis());

    public static String defaultPass() {
        String password = "";

        password += uppercase();
        password += lowercase();
        password += lowercase();
        password += symbol();
        password += number();
        password += number();
        password += number();
        password += number();

        return password;
    }

    public static String customPass(
            int lenght, boolean lowercase, boolean number,
                        boolean symbol, boolean uppercase) {
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String symbolChars = "@#$%{}[]()/~,;:.<>";

        String password = "";
        String characters = "";

        if (lowercase) {
            characters += lowerChars;
        }
        if (uppercase) {
            characters += lowerChars.toUpperCase();
        }
        if (symbol) {
            characters += symbolChars;
        }
        if (number) {
            for(int i = 0; i < 10; i++){
                characters += Integer.toString(i);
            }
        }

        for (int i = 0; i < lenght; i++) {
            password += characters.charAt(rand.nextInt(characters.length()));
        }
        return password;
    }

    public static char lowercase() {
        String c = "abcdefghijklmnopqrstuvwxyz";
        return c.charAt(rand.nextInt(c.length()));
    }

    public static char uppercase() {
        return Character.toUpperCase(lowercase());
    }

    public static char symbol() {
        String c = "@#$%{}[]()/~,;:.<>";
        return c.charAt(rand.nextInt(c.length()));
    }

    public static char number() {
        return Integer.toString(rand.nextInt(10)).charAt(0);
    }

}
