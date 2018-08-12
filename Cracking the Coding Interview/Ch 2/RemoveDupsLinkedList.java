public class RemoveDupsLinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        Node head = new Node(0, null);
        Node tail = head;
        int i = 1;
        for (; i < 10; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
        for (i = 1; i < 10; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
        System.out.println("Initial  List ..");
        printLinkedList(head);
        removeDups(head);
        System.out.println("After Remove..");
        printLinkedList(head);
    }

    public static Node removeDups(Node node) {
        if (node == null) return node;
        Node current = node;
        Node cursor = current;
        while (current != null) {
            cursor = current;
            while (cursor != null && cursor.next != null) {
                if (current.val == cursor.next.val) {
                    cursor.next = cursor.next.next;
                }
                cursor = cursor.next;
            }
            current = current.next;
        }

        return node;
    }

    static void printLinkedList(Node node) {
        Node cursor = node;
        while (cursor != null) {
            System.out.print("Val: " + cursor.val +" - >");
            cursor = cursor.next;
        }
        System.out.println("END");
    }

}