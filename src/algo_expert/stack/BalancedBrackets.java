package algo_expert.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function that taken in a string made up of bracket ( ( [ { ) } & ) ) and other
 * optional characters. The function should return a boolean representing whether the
 * string is balanced with regards to brackets.
 */
public class BalancedBrackets {

    static boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingCharacter = new HashMap<>();
        matchingCharacter.put(')', '(');
        matchingCharacter.put(']', '[');
        matchingCharacter.put('}', '{');

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (openingBrackets.indexOf(letter) != -1)
                stack.add(letter);
            else if (closingBrackets.indexOf(letter) != -1) {
                if (stack.size() == 0)
                    return false;
                if (stack.get(stack.size() - 1) == matchingCharacter.get(letter))
                    stack.remove(stack.size() - 1);
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
