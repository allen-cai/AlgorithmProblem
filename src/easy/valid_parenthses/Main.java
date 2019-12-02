package easy.valid_parenthses;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ValidParenthses validParenthses = new ValidParenthses();
        String value = "()[]{}";
        boolean b = validParenthses.validParenthses(value);
        System.out.println(b);
    }

}
