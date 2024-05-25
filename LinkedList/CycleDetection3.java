package LinkedList;
/*find first node of the loop in a linked list in o(N) time and o(1) space*/
public class CycleDetection3 {
    public static void main(String[] args) {

        // Initialize the Nodes.
                Node one = new Node(3);
        Node two = new Node(5);
        Node three = new Node(9);

// Connect nodes
        one.next = two;
        two.next = three;
        three.next = two;
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
        while(slow != p)
        {
            slow = slow.next;
            p=p.next;
        }
        return p;

    }

}
