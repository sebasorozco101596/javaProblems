package medium;

import different_classes.ListNode;

// 19. Remove Nth Node From End of List
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(-1, head);
        ListNode main = start;
        ListNode ref = main;

        // Move ref by 'n+1' steps
        for(int i=1; i<=n+1; i++) {
            ref = ref.next;
        }

        // Move main until ref reaches end of list
        while(ref != null){
            System.out.println("ref: " + ref.val);
            ref = ref.next;
            System.out.println("main: " + main.val);
            main = main.next;
        }

        // Now main is pointing to (n-1)th node from end of list
        main.next = main.next.next;

        return start.next;
    }
}
