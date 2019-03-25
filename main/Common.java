package main;

import java.awt.*;

public class Common {

    public static Color def = Color.darkGray; //sets a default bg and border colour
    public static String font = "Segoe UI";

    public static String getArticle(String word){

        char letter = word.charAt(0);

        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
            return "an";
        else
            return "a";

    }

    public static int round(int num) {
        int temp = num % 5;
        if (temp < 3)
            return num - temp;
        else
            return num + 5 - temp;
    }

}
