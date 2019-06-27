package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 因为输入的数组numbers是升序的
 * 所以当数组中所有的数都是正数时，那么只需要在比target值小的值里面找
 * 当存在小于0的数字时，就在整个数组里面查找
 *
 * @ClassName twoSumInputArrayIsSorted
 * @Description TODO
 * @Author allen
 * @Date: 2019-06-27 10:08
 *
 */
public class twoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        int i = 0;
        if (numbers[0] >= 0) {
            for (; i < numbers.length & numbers[i] < target; i++) {
                //map中存在该差值，将两value按顺序保存到list当中
                if (map.containsKey(target - numbers[i])) {
                    return new int[] {map.get(target - numbers[i]), i};
                }
                //map中不存在，则保存
                map.put(numbers[i], i);
            }
        } else {
            for (; i < numbers.length; i++) {
                //map中存在该差值，将两value按顺序保存到list当中
                if (map.containsKey(target - numbers[i])) {
                    return new int[] {map.get(target - numbers[i]), i};
                }
                //map中不存在，则保存
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    /**
     * 二分法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int pre = 0, la = numbers.length - 1;
        while(la > pre) {
            if (numbers[pre] + numbers[la] == target) {
                return new int[]{pre + 1, la + 1};
            } else if (numbers[pre] + numbers[la] > target) {
                la--;
            } else {
                pre++;
            }
        }
        return null;
    }
}
