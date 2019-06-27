package easy;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Author allen
 * @Date: 2019-06-27 09:34
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        List<Integer> result = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            //map中存在该差值，将两value按顺序保存到list当中
            if (map.containsKey(target - nums[i])) {
               return new int[] {map.get(target - nums[i]), i};
            }
            //map中不存在，则保存
            map.put(nums[i], i);
        }
        return null;
    }
}
