package LinkedList;

import java.util.HashMap;

/*Given a linked list that contains a next pointer and a unique pointer called a random pointer.
You will have to make a deep copy of the given linked list. You have to initialise the same set of nodes at another
 memory location and they should organise in the same manner.

 */
public class ClonelinkedList {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {

        HashMap<Node,Node> map = new HashMap<>();
        Node cloneHead = null;
        Node prev = null;
        Node temp = null;
        Node curr = head;
        while(curr != null)
        {
            temp = new Node(curr.val);
            map.put(curr,temp);
            if(prev == null)
            {
                cloneHead = temp;
                prev = temp;
            }
            else {
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }

        Node curr1 = head;
        Node curr2 = cloneHead;
        while(curr2 != null)
        {
            if(curr1.random != null)
            {
                curr2.random = map.get(curr1.random);
            }
            else curr2.random = null;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return cloneHead;

    }



    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


