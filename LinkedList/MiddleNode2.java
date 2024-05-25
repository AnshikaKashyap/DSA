package LinkedList;
/*We have been given a linked list and we have to return the value present at the middle node.
Input: 5 → 4 → 10 → 3 → 2 → NULL
Output: 10
Input: 10 → 20 → 30 → 40 → 50 → 60 → NULL
Output: 40*/
public class MiddleNode2 {
    LinkedList list = new LinkedList();
    static int findNoOfNode(LinkedList list)
    {
        Node curr_node = list.head;
        int cnt = 1;

        while(curr_node.next !=null) {
            cnt++;
            curr_node = curr_node.next;

        }
        return cnt;
    }

    // 2 pass algorithm
    static int findMiddleNode(LinkedList list)
    {
        int n= findNoOfNode(list);
        System.out.println(n);
        Node temp_node = list.head;
        int cnt =0;
        while(cnt != (n/2))
        {
            temp_node = temp_node.next;
            cnt++;
        }
        return temp_node.data;
    }

    // 1 pass algorithm
    static int findMiddleNode2(LinkedList list)
    {
        Node slow= list.head;
        Node fast = list.head;
        while(fast != null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list,1);
        list.insert(list,2);
        list.insert(list,3);
        list.insert(list,4);
        list.insert(list,5);
        list.insert(list,6);
        System.out.println(findMiddleNode2(list));


    }

}
