package algo_expert.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes a special array and returns its product sum. A special array
 * is a non empty array that contains either integer or other special arrays. The product
 * sum of a special array is the sum of its elements, where special arrays inside it are summed
 * themselves and then multiplied by their level of depth.
 *
 * product sum of [x, y] is x + y
 * product sum of [x, [y, z]] is x + 2y + 2z
 */
public class ProductSum {
    static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for(Object obj: array) {
            if (obj instanceof Arrays) {
                sum += productSumHelper((List<Object>) obj, multiplier + 1);
            } else {
                sum += (int) obj;
            }
        }
        return sum;
    }

}
