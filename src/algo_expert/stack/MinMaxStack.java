package algo_expert.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a MinMaxStack class for a Min Max Stack. The class should support:
 *  - Pushing and popping values on and off the stack.
 *  - Peeking at the values at the top of the stack.
 *  - Getting both the minimum and maximum values in the stack at any given point in time.
 *
 *  All class methods, when considered independently should run in constant time and with
 *  constant space.
 */
public class MinMaxStack {
    /**
     * You should be able to push values on, pop values off and peek at values on top of the stack
     * at any time and in constant time, using constant space.
     *
     * What data-structure maintains order and would allow you do to this?
     *
     * You should be able to get the minimum and maximum values in the stack at any time and in
     * constant time, using constant space.
     *
     * What data-structure would allow you to do this?
     *
     * Since the minimum and maximum values in the stack can change with every push and pop, you will
     * likely to keep track of all time mins and maxes at every values in the stack.
     */
    static class MinMaxStackProgram {
        List<Integer> stack = new ArrayList<>();
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();

        public int peek () {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() -1);
            return stack.remove(stack.size() - 1);
        }

        public void push(int number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
