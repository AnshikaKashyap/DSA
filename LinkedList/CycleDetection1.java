package LinkedList;

import java.util.HashMap;
/*Detect if given linkedlist is cyclic or not*/
public class CycleDetection1 {
    public static void main(String[] args) {
        // Initialize the Nodes.
        Node one = new Node(3);
        Node two = new Node(5);
        Node three = new Node(9);

// Connect nodes
        one.next = two;
        two.next = three;
        three.next = one;
        System.out.println(isCyclicUsing2Pointers(one));

    }
    // approach using hash map
    static boolean isCyclic(Node head)
    {
        HashMap<Node, Boolean> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
//            System.out.println("curr: "+curr.data+" map.get(curr): "+map.get(curr));
            if (map.get(curr) != null)
                return true;
            map.put(curr,true);
            curr = curr.next;
        }

        return false;
    }

    // approach using slow and fast pointer

    static boolean isCyclicUsing2Pointers(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return  false;
    }

}
