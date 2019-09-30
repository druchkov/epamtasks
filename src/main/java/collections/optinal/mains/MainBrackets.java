package collections.optinal.mains;

import collections.optinal.CheckCorrectPlacementBrackets;

public class MainBrackets {
    public static void main(String[] args) {
        String str = "(1+3){2*(4+[4/2])}";
        String str1 = "({})[)";
        String str2 = "{(})";
        String str3 = "{}[()](";

        System.out.println(CheckCorrectPlacementBrackets.isCorrectPlacementBrackets(str));
        System.out.println(CheckCorrectPlacementBrackets.isCorrectPlacementBrackets(str1));
        System.out.println(CheckCorrectPlacementBrackets.isCorrectPlacementBrackets(str2));
        System.out.println(CheckCorrectPlacementBrackets.isCorrectPlacementBrackets(str3));
    }
}
