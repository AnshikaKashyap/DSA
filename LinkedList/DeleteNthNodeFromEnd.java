package LinkedList;

import static LinkedList.LinkedList.printList;
/*We have been given a linked list and an integer N (<=size of the list). We have to delete the Nth node from the end.
Eg. For list - 1 → 5 → 2 → 4 → 7 → 16, N = 3.
The modified list will be - 1 → 5 → 2 → 7 → 16
*/
public class DeleteNthNodeFromEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list,1);
        list.insert(list,2);
        list.insert(list,3);
        list.insert(list,4);
        list.insert(list,5);
        list.insert(list,6);
        printList(list);
        deleteNthNodeFromEnd(list,2);
        printList(list);

    }

    static LinkedList deleteNthNodeFromEnd(LinkedList list, int n)
    {
        Node slow = list.head;
        Node fast = list.head;
        int cnt = 0;
        // move fast pointer n unit forward
        while(cnt < n)
        {
            fast = fast.next;
            cnt++;
        }
        // if fast reaches end of list, means we need to delete head
        if(fast.next == null)
        {
            list.head = list.head.next;
        }
        // move both slow and fast by 1 unit till fast reaches end of list
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        // delete node next to slow
        slow.next = slow.next.next;
        return list;
    }
}
