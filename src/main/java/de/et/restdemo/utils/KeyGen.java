package de.et.restdemo.utils;

/**
 * Generates Keys
 *
 * Created by Erik on 24.10.2015.
 */
public class KeyGen {

    private static int key = 0;

    public static String getKey() {
        return Integer.toString(key++);
    }
}
