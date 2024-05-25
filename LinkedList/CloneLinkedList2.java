package LinkedList;
/* In the previous solution, we solve this problem using O(N) extra space . here we will solve this problem using constant extra space.*/
public class CloneLinkedList2 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
    Node clone_head = null;
    Node temp = null;
    Node curr = head;
    while(curr != null)
    {
        temp = new Node(curr.val);
        if(curr == head)
        {
            clone_head = temp;
        }
       Node t = curr.next;
        curr.next = temp;
        temp.next = t;
        curr = t;

    }

    curr = head;
    while(curr != null)
    {
        if(curr.random != null)
            curr.next.random = curr.random.next;
        else
            curr.next.random = null;
        curr = curr.next.next;
    }

    // detach cloned list
        curr = clone_head;
    Node curr1 = head;
    while(curr != null && curr.next != null)
    {
        Node t = curr.next;
        curr.next = curr.next.next;
        curr = curr.next;
        curr1.next = t;
        curr1 = curr1.next;
    }
    if(curr1 != null)
    {
        curr1.next = null;
    }

    return clone_head;

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
