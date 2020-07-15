import java.util.HashMap;
import java.util.Map;

/**
 * @author : cuipingping
 * create at:  2020/7/15
 *
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 *
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 二叉搜索树
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution96 extends BaseSolution {
    //记忆表
    private static Map<Integer, Integer> memoMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.print(numTrees(3));
    }

    /**
     * 总数=每个数字做根结点的个数累加
     * 根结点个数=左子树节点个数*右节点个数
     *
     */
    public static int numTrees(int n) {
        if (memoMap.containsKey(n)) {
            return memoMap.get(n);
        }

        //等于0为空树，等于1为根结点，递归出口
        if (n == 0 || n == 1) {
            memoMap.put(0, 1);
            memoMap.put(1, 1);
            return 1;
        }
        int sum = 0;
        //i代表以几作为根结点
        for (int i = 1; i <= n; i++) {
            //若以第i个数据为根节点，其左边数据有i-1个，右边数据有n-i个
            // 节点总个数=左子树节点个数+根结点+右子树节点个数
            //（i-1）+（1）+（n-i）=n
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            sum += leftNum * rightNum;
        }

        memoMap.put(n, sum);
        return sum;
    }
}