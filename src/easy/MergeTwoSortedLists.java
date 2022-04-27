package easy;

import different_classes.ListNode;

import java.util.List;

public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (list1 != null || list2 != null) {
            int valueList1 = (list1 != null) ? list1.val : ' ';
            int valueList2 = (list2 != null) ? list2.val : ' ';

            if (valueList1 <= valueList2) {
                current.next = new ListNode(valueList1);
                if (list1 != null) list1 = list1.next;
            } else {
                current.next = new ListNode(valueList2);
                if (list2 != null) list2 = list2.next;
            }

            current = current.next;

        }
        return result.next;
    }


    /*
    Optimal solution
     */

    public ListNode mergeTwoListsOptimal(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1!=null && l2!=null) {
            if (l1.val <= l2.val) {
                curr.next=l1;
                l1=l1.next;
            } else {
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next = l1 == null ? l2:l1;
        return dummy.next;
    }
}
