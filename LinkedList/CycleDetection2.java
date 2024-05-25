package LinkedList;
/*Given a linked list. Find the first node of the loop in the linked list. Return NULL if there is no loop in the linked list.
* Time complexity:-  O(L * (N-L)), where L is the length of the list from where the loop is starting.
Space complexity:- O(1)*/
public class CycleDetection2 {
    public static void main(String[] args) {

        // Initialize the Nodes.
        Node one = new Node(3);
        Node two = new Node(5);
        Node three = new Node(9);

// Connect nodes
        one.next = two;
        two.next = three;
        three.next = one;
        System.out.println(isCyclic(one).data);


    }

    static Node isCyclic(Node head)
    {
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
             if(!hasCycle)
                return null;
            Node p =head;
            while(true)
            {
                Node temp = slow;
                while (temp != p)
                {
                    temp = temp.next;
                    if(temp == slow)
                        break;
                }
                if(temp == p)
                    return temp;
                p=p.next;
            }


    }
}
