package LinkedList;
/*Merge Linked List:-
Given two sorted linked lists. We have to merge the links in such a way that the resultant linked list is also a sorted linked list and contains all the elements of list1 and list2.
Eg. List1 = [ 1, 2, 5,6]
List2 = [ 2 , 3, 5]
Result  = [1, 2, 2, 3, 5, 5, 6] .*/
public class MergeLinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(list1,1);
        list1.insert(list1,2);
        list1.insert(list1,5);
        list1.insert(list1,6);

        LinkedList list2 = new LinkedList();
        list2.insert(list2,2);
        list2.insert(list2,3);
        list2.insert(list2,5);
        Node head = Merge_recursive(list1.head,list2.head);
        // Traverse through the LinkedList
        while (head != null) {
            // Print the data at current node
            System.out.print(head.data + " ");

            // Go to next node
            head = head.next;
        }



    }
    static Node Merge_iterative(Node h1, Node h2)
    {
        if(h1 == null) {
            return h2;
        }
        if(h2 == null) {
            return h1;
        }
        Node head;
        Node tail;
        Node p1 = h1;
        Node p2 = h2;

        if(h1.data <= h2.data)
        {
            head = h1;
            tail = h1;
            p1 = p1.next;
        }
        else {
            head = h2;
            tail = h2;
            p2 = p2.next;
        }
        while(p1 != null && p2 != null)
        {
            if(p1.data <= p2.data)
            {
                tail.next = p1;
                p1 = p1.next;
            }
            else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
            if(p1 != null)
            {
                tail.next = p1;
            }
            if(p2 !=null)
            {
                tail.next = p2;
            }
        }
        return head;
    }

    static Node Merge_recursive(Node l1, Node l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        Node head;
        Node temp;
        if(l1.data <= l2.data)
        {
            head = l1;
            temp = head.next;
            head.next = null;
            head.next = Merge_recursive(temp,l2);

        }
        else {
            head = l2;
            temp = head.next;
            head.next = null;
            head.next = Merge_recursive(l1,temp);

        }
        return head;

    }
}
