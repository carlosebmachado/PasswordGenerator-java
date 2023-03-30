/*
 * MIT License
 *
 * Copyright (c) 2020 Carlos Eduardo de Borba Machado
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.carlosmachado.core;

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
            for (int i = 0; i < 10; i++) {
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
