import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : cuipingping
 * create at:  2020/7/13
 *
 * 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution350 extends BaseSolution {
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };

        System.out.print(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * 使用map存出现的次数
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? calculate(nums1, nums2) : calculate(nums2, nums1);

    }

    public static int[] calculate(int[] min, int[] max) {
        if (min.length == 0) {
            return new int[] {};
        }

        //塞map
        Map<Integer, Integer> map = new HashMap<>(min.length);
        for (int value : min) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int[] result = new int[min.length];
        int index = 0;
        for (int val : max) {
            if (map.containsKey(val)) {
                result[index] = val;
                index++;

                //某个值次数都抵完时remove
                if (map.get(val) <= 1) {
                    map.remove(val);
                } else {
                    map.put(val, map.get(val) - 1);
                }
            }
        }

        //需要移除0
        return Arrays.copyOf(result, index);
    }
}