package LinkedList;

import java.util.ArrayList;
import java.util.List;

import static LinkedList.LinkedList.printList;

/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6*/
public class MergeKLinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        list1.insert(list1,1);
        list1.insert(list1,4);
        list1.insert(list1,5);
        list2.insert(list2,1);
        list2.insert(list2,3);
        list2.insert(list2,4);
        list3.insert(list3,2);
        list3.insert(list3,6);

        List<Node> lists = new ArrayList<>();
        lists.add(list1.head);
        lists.add(list2.head);
        lists.add(list3.head);
        Node head = MergeLists(lists);
        while(head !=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }

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
    static Node MergeLists(List<Node> lists)
    {
        if(lists.size() == 0)
            return null;
        return MergeKList(lists,0,lists.size()-1);
    }

    static Node MergeKList(List<Node> lists,int i, int j)
    {
        if(i==j)
            return lists.get(i);
        int mid = (i+j)/2;
        Node h1 = MergeKList(lists, i,mid);
        Node h2 = MergeKList(lists,mid+1,j);
        return Merge_recursive(h1,h2);

    }

}
