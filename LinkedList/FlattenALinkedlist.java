package LinkedList;
/*https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/*/
public class FlattenALinkedlist {
    public static void main(String[] args) {
        Node ten = new Node(10);
        Node two = new Node(2);
        Node five = new Node(5);
        Node twenty = new Node(20);
        Node thirty = new Node(30);
        Node three = new Node(3);
        Node four = new Node(4);

        ten.next = twenty;
        twenty.next = thirty;
        ten.down = two;
        two.down = five;
        two.next = three;
        three.next = four;
//        Node head = flatten(ten);
        Node head = flattenWithOrder(ten);
        while(head != null)
        {
            System.out.print(head.data+"--- ");
            head = head.next;
        }


    }


    public static Node flatten(Node head) {
        Node curr = head;
        Node tail = head;
        // find tail of the list
        while(tail.next != null)
        {
            tail = tail.next;
        }
        System.out.println("tail data: "+ tail.data);
        Node temp;
        while(curr != null) {
          if (curr.down != null) {
                temp = curr.down;  //2
                curr.down = null;
                tail.next = temp;

                // update tail pointer
                while(tail.next != null)
                {
                    tail = tail.next;
                }


            }
            curr = curr.next;
        }

        return head;
    }
    public static Node flattenWithOrder(Node head) {
        Node curr = head;
        Node temp_down;
        Node temp_next;
        while(curr != null) {
            if (curr.down != null) {
                temp_down = curr.down;
                temp_next = curr.next;
                curr.down = null;

                // insert curr.down element between curr and temp_next element
                // traverse temp_down till it reaches tail
//                temp_down.next = temp_next;
                curr.next = temp_down;
                while(temp_down.next != null) {
                    temp_down = temp_down.next;
                }
                temp_down.next = temp_next;

            }
            curr = curr.next;
        }

        return head;
    }
    static class Node{
        int data;
        Node next;
        Node down;

        public Node (int val)
        {
            this.data = val;
            this.next = null;
            this.down = null;
        }
    }
}
