package hard;

import different_classes.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

// 23. Merge k Sorted Lists
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }

        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for( int i = 2; i < lists.length ;i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    /*
    Optimal solution
     */

    public ListNode mergeKListsOptimal(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode list1 = merge(lists, start, mid);
        ListNode list2 = merge(lists, mid+1, end);

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    pointer.next = list1;
                    list1 = list1.next;
                } else {
                    pointer.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }

            pointer = pointer.next;
        }

        return dummy.next;
    }


    /*
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int y = 0, lastList = 0;

        if (lists.length > 1) {

            int minValue = ' ';
            int indexList = 0;
            boolean isFinished = false;

            while (!isFinished) {

                if (lists[y] != null) {

                    if (lists[y].val == ' ') lists[y] = lists[y].next;
                    int valueList = (lists[y] != null) ? lists[y].val : ' ';

                    if (valueList < minValue) {
                        minValue = lists[y].val;
                        indexList = y;
                    } else lastList = y;

                    y++;

                    if (y == (lists.length)) {
                        current.next = new ListNode(minValue);
                        System.out.print(minValue + " -> ");

                        current = current.next;

                        minValue = ' ';
                        if (lists[indexList] != null) lists[indexList] =  lists[indexList].next;
                        y = 0;
                    }

                    if (lists[lastList] == null) isFinished = true;
                } else if ( y > (lists.length)) {
                    y = 0;
                }
                else {
                    y++;
                }

            }
        } else if (lists.length == 1){
            return lists[0];
        } else {
            return new ListNode().next;
        }

        return dummy.next;
    }
     */
}
