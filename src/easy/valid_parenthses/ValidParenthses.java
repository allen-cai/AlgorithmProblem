package easy.valid_parenthses;

import java.util.*;

public class ValidParenthses {

    Boolean validParenthses(String value) {
        //正向匹配
        Map<Character, Character> parenthsesMap = new HashMap<>();
        parenthsesMap.put('(', ')');
        parenthsesMap.put('[', ']');
        parenthsesMap.put('{', '}');
        Set<Character> keySet = parenthsesMap.keySet();

        //若传入的值为空，直接返回false
        if (value == null || "".equals(value) || value.length() < 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < value.length(); i++) {
            Character c = value.charAt(i);
            if (keySet.contains(c)){
                stack.push(c);
            } else {
                //暂时取出栈头元素
                Character index = stack.peek();
                if (c == parenthsesMap.get(index)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
