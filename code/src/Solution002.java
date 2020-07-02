/**
 * @author : cuipingping
 * create at:  2020/7/2
 * <p>
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution002 extends BaseSolution {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = l3;
        ListNode l1 = new ListNode(2);
        l1.next = l2;

        ListNode ll3 = new ListNode(4);
        ListNode ll2 = new ListNode(6);
        ll2.next = ll3;
        ListNode ll1 = new ListNode(5);
        ll1.next = ll2;

        addTwoNumbers(l1, ll1);
    }

    /**
     * 可以理解为个十百位相加，超过10则向上进一位
     * <p>
     * 步骤如下：
     * 342 + 465
     * ->
     * 3+4=7           进位=0
     * 4+6=0           进位1
     * 5+2+1（进位）=8  进位=0
     * =708
     * <p>
     * 需注意如果最后进位了需要新增一个节点
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int carry = 0;
        //从低位到高位，遍历两个数字的个十百千...位
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;

            //同位相加，再加上前一位的进位
            int sum = d1 + d2 + carry;

            //如果当前位相加大于10，则进一位
            carry = sum >= 10 ? 1 : 0;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            //往后遍历
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //最后一位计算有进位时，需新增一个节点
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}