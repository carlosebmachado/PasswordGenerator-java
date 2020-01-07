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
    
    public static String customPass(int lenght, boolean lowercase, boolean number, boolean symbol, boolean uppercase) {
        String password = "";
        for (int i = 0; i < lenght; i++) {
            boolean willChoice = false;
            while (!willChoice) {
                int selected = rand.nextInt(4);
                if (lowercase && selected == 0) {
                    password += lowercase();
                    willChoice = true;
                }
                if (number && selected == 1) {
                    password += number();
                    willChoice = true;
                }
                if (symbol && selected == 2) {
                    password += symbol();
                    willChoice = true;
                }
                if (uppercase && selected == 3) {
                    password += uppercase();
                    willChoice = true;
                }
            }
        }
        return password;
    }

    public static char lowercase() {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return c[rand.nextInt(c.length)];
    }

    public static char uppercase() {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return Character.toUpperCase(c[rand.nextInt(c.length)]);
    }

    public static char symbol() {
        char[] c = { '@', '#', '$', '%', '{', '}', '[', ']', '(', ')', '/', '~', ',', ';', ':', '.', '<', '>' };
        return c[rand.nextInt(c.length)];
    }

    public static char number() {
        return Integer.toString(rand.nextInt(10)).charAt(0);
    }
    
}
