/**
 * @author : cuipingping
 * create at:  2020/7/2
 * 
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。  
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:  给定 nums = [2, 7, 11, 15], target = 9  
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]  
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 */

import java.util.HashMap;
import java.util.Map;

public class Solution001 extends BaseSolution {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        twoSum(nums, 3);
    }

    /**
     *
     * 想用线性的时间复杂度来解决问题，就是说只能遍历一个数字，
     * 那么另一个数字呢，可以事先将其存储起来，使用一个 HashMap，
     * 来建立数字和其坐标位置之间的映射，由于 HashMap 是常数级的查找效率，
     * 这样在遍历数组的时候，用 target 减去遍历到的数字，就是另一个需要的数字了，
     * 直接在 HashMap 中查找其是否存在即可
     * 
     * 注意要判断查找到的数字不是第一个数字，比如 target 是4，
     * 遍历到了一个2，那么另外一个2不能是之前那个2
     * 
     * 整个实现步骤为：
     * 先遍历一遍数组，建立 HashMap 映射，然后再遍历一遍，
     * 开始查找，找到则记录 index。
     */
    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }

        for (int index = 0; index < nums.length; index++) {
            int result = target - nums[index];
            if (map.containsKey(result) && map.get(result) != index) {
                return new int[] { index, map.get(result) };
            }
        }
        return null;
    }
}