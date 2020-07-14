import java.util.ArrayList;
import java.util.List;

/**
 * @author : cuipingping
 * create at:  2020/7/14
 *
 * 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * [
 *        [2],
 *       [3,4],
 *      [6,5,7],
 *     [4,1,8,3]
 * ]
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution120 extends BaseSolution {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        System.out.print(minimumTotal(triangle));
    }

    /**
     * 拿上面的例子来说
     * 对于2，下一行里3和4是相邻的；
     * 对于3来说，6和5>是相邻的；
     * 对于4来说，5和7是相邻的；
     * 对于4/1/8/3来说，没有下一行所以没有相邻数字了。
     * 
     * 如果我们把数字都对应到数据在每一行中的下标上，可以很容易发现，
     * 对于一个data[i][j]，和它相邻的数字就是data[i+1][j]和data[i+1][j+1]。
     * 
     * 假如我们用minimus[i][j]来表示从第i行第j列处的数字开始往下到最后一层的最小路径和，那么有
     * minimus[i][j]=data[i][j]+min(minimums[i+1][j]+minimums[i+1][j+1])
     * 
     * 优化：避免重复计算，把每次计算的结果保存下来，后续计算前先取值
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] memo;
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0, memo);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j, memo),
            dfs(triangle, i + 1, j + 1, memo))
                            + triangle.get(i).get(j);
    }
}