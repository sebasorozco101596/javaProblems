package medium;

import different_classes.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempResult = null;
        ListNode result = null;
        int temp = 0;
        boolean isFinished = false;

        while (!isFinished) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val;
                if ( (sum + temp) < 10 ){
                    if (temp > 0) {
                        System.out.print((sum + temp) + ",");
                        tempResult = new ListNode(sum + temp, tempResult);
                        temp = 0;
                    } else {
                        System.out.print(sum + ",");
                        tempResult = new ListNode(sum, tempResult);
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    int newSum = sum - 10;
                    l1 = l1.next;
                    l2 = l2.next;

                    if (temp > 0) {
                        tempResult = new ListNode(newSum + temp, tempResult);
                    } else {
                        tempResult = new ListNode(newSum, tempResult);
                    }
                    temp = 1;
                    System.out.print(newSum + ",");
                }

            } else if (l1 != null) {
                if (temp > 0) {
                    int newSum = l1.val + temp;
                    if (newSum < 10) {
                        tempResult = new ListNode(newSum, tempResult);
                        temp = 0;
                    } else {
                        tempResult = new ListNode(newSum - 10, tempResult);
                    }
                } else {
                    tempResult = new ListNode(l1.val, tempResult);
                }

                l1 = l1.next;
            } else if (l2 != null) {
                if (temp > 0) {
                    int newSum = l2.val + temp;
                    if (newSum < 10) {
                        tempResult = new ListNode(newSum, tempResult);
                        temp = 0;
                    } else {
                        tempResult = new ListNode(newSum - 10, tempResult);
                    }
                } else {
                    tempResult = new ListNode(l2.val, tempResult);
                }

                l2 = l2.next;
            } else {
                if (temp > 0) {
                    tempResult = new ListNode(temp, tempResult);
                    temp = 0;
                } else {
                    isFinished = true;
                }
            }
        }

        // Changing the position of all the numbers in the ListNode.
        while (tempResult != null) {
            result = new ListNode(tempResult.val, result);
            tempResult = tempResult.next;
        }

        return result;
    }

    public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

/*
Test cases
Optimal solution
 */







