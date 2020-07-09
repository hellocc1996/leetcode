/**
 * @author : cuipingping
 * create at:  2020/7/9
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution003 extends BaseSolution {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.print(findMaxLength(str));
    }

    /**
     * 遍历字符串
     * 判断链表中是否包含该字符
     * 
     * 不包含则将其加入链表并更新最大值
     * 包含则移除链表中该字符
     */
    private static int findMaxLength(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        //坐标
        int left = 0, right = 0, length = -1;
        while (right < str.length()) {
            //若不存在，则加入list并更新最大值，继续往后遍历
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                right++;
                length = Math.max(length, set.size());
            } else {
                //若存在，则只需移除重复的值，然后右移left
                //注意，right不用+1，因为再往后会走不包含的流程
                set.remove(str.charAt(left));
                left++;
            }
        }
        return length;
    }
}