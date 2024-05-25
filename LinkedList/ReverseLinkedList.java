package LinkedList;

import static LinkedList.LinkedList.printList;
/*We have been given a linked list and we have to reverse it.*/
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);
        list.insert(list, 6);
        printList(list);
        Node head = reverseListRecursively(list.head);
        // print list

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (head != null) {
            // Print the data at current node
            System.out.print(head.data + " ");

            // Go to next node
            head = head.next;
        }
    }

    static LinkedList reverseListIteratively(LinkedList list) {
        Node temp;
        Node curr = list.head;
        Node prev = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            System.out.println();

        }
        list.head = prev;
        return list;
    }

    static Node reverseListRecursively(Node head) {
        // last node or only one node
        if (head == null) return null;
        if (head.next == null)
            return head;

            Node temp = head.next;  //2
            head.next = null; // detach 1
            Node newHeadNode = reverseListRecursively(temp);  // reverse(2)
            temp.next = head;
            return newHeadNode;
            // send back new head node in every recursion



    }
}
