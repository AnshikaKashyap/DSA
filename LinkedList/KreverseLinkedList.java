package LinkedList;

import static LinkedList.LinkedList.printList;
/*We have to k-reverse a linked list. k-reverse means that we have to reverse the chunks of size k in the linked list.
Input: 1 → 9 → 3 → 7 → 4 → 6 ; k = 2
Output: 9 → 1 → 7 → 3 → 6 → 4
Input: 2 → 5 → 4 → 6 → 8 → 10 → 3 → 1 ; k=3
Output: 4 → 5 → 2 → 10 → 8 → 6 → 3 → 1
Note: Do not reverse a chunk if its size is smaller than k. In cases where N%k!=0.
*/
public class KreverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);
        list.insert(list, 6);
        Node node = KreverseList(list.head, 2);
        while (node != null) {
            // Print the data at current node
            System.out.print(node.data + " ");

            // Go to next node
            node = node.next;
        }


    }

    static Node KreverseList(Node head, int k)
    {
        int cnt = 0;
        Node curr = head;
        while(curr !=null && cnt < k)
        {
            cnt++;
            curr = curr.next;
        }
        if(cnt < k) return head;
        // iteratively reverse first k element of list
        curr = head;
        Node prev = null;
        Node temp;
        cnt = 0;
        while(cnt < k)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt++;
        }


        head.next = KreverseList(curr,k);
        return prev;

    }

}
