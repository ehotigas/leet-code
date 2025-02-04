class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ref = head;
        while (ref != null && ref.next != null) {
            if (ref.val == ref.next.val) {
                ref.next = ref.next.next;
                continue;
            }
            ref = ref.next;
        }
        return head;
    }
}
