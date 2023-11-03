package com.jay.leetcode.editor.cn;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
public class NodeTest {
     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
        public static ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode tmp = head;
                    while (tmp != slow) {
                        tmp = tmp.next;
                        slow = slow.next;
                    }
                    return tmp;
                }
            }
            return null;
        }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
