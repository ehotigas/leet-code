class ListNode {
    ListNode next;
    int val;

    public ListNode() {

    }
    
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode[val=" + val + "]";
    }
}


class MyLinkedList {
    private ListNode root;
    private int size;
    public MyLinkedList() {
        size = 0;
    }

    public MyLinkedList(int[] list) {
        this();

        for (int number : list) {
            add(number);
        }
    }

    public MyLinkedList(ListNode listNode) {
        this();
        ListNode ref = listNode;
        while (ref != null) {
            add(ref.val);
            ref = ref.next;
        }
    }

    private ListNode findLast(ListNode ref) {
        if (ref.next == null) {
            return ref;
        }
        return findLast(ref.next);
    }

    public void add(int val) {
        ListNode instance = new ListNode(val);
        if (root == null) {
            root = instance;
        }
        else {
            findLast(root).next = instance;
        }
        size++;
    }

    public int getval(int idx) {
        if (idx >= size || idx < 0) {
            throw new IllegalArgumentException("Thats is an invalid index");
        }
        ListNode ref = root;
        for (int countIdx = 0; countIdx < idx; countIdx++) {
            ref = ref.next;
        }
        return ref.val;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        ListNode ref = root;
        while (ref != null) {
            builder.append(ref.val + ", ");
            ref = ref.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public ListNode getRoot() {
        return root;
    }
}


interface Operation {
    MyLinkedList calculate(MyLinkedList number1, MyLinkedList number2);
}

class Add implements Operation {
    public MyLinkedList calculate(MyLinkedList number1, MyLinkedList number2) {
        MyLinkedList out = new MyLinkedList();
        boolean increment = false;
        for (int index = 0; index < Integer.max(number1.getSize(), number2.getSize()); index++) {
            int opr1 = 0, opr2 = 0;
            if (index < number1.getSize()) {
                opr1 = number1.getval(index);
            }
            if (index < number2.getSize()) {
                opr2 = number2.getval(index);
            }
            int sum = increment ? opr1 + opr2 + 1 : opr1 + opr2;
            out.add(sum%10);
            increment = sum >= 10;
        }
        if (increment) {
            out.add(1);
        }
        return out;
    }


}


public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        MyLinkedList list1 = new MyLinkedList(l1);
        MyLinkedList list2 = new MyLinkedList(l2);
        return new Add().calculate(list1, list2).getRoot();
    }

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList(new int[]{ 9,9,9,9,9,9,9 });
        MyLinkedList l2 = new MyLinkedList(new int[]{ 9,9,9,9 });
        MyLinkedList result = new MyLinkedList(new Problem2().addTwoNumbers(l1.getRoot(), l2.getRoot()));
        System.out.println(result);
    }
}
