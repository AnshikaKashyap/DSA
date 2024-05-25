package LinkedList;

import java.util.Objects;

public class LinkedList {
    Node head;


    public static LinkedList insert(LinkedList list,int data)
    {
        Node new_node = new Node(data);
        // check if given list is empty
        if(list.head == null)
        {
            list.head = new_node;
        }
        else {
            // traverse the list to find the last element
            Node last_node = list.head;
            while(last_node.next != null)
            {
                last_node = last_node.next;
            }
            // insert element at the end of the list
            last_node.next = new_node;

        }
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static LinkedList insertAtGivenPos(LinkedList list,int pos,int data)
    {
        Node new_node = new Node(data);
        //to insert node at nth pos, we need reference to n-1 node, for which we'll require n-2 hops
        if(pos == 1)
        {
            new_node.next = list.head;
            list.head = new_node;
            return list;

        }
        int cnt = 0;
        Node curr_node = list.head;
        while(cnt<pos-2)
        {
            curr_node = curr_node.next;
            cnt++;
        }

        // insert new node at given pos
        new_node.next = curr_node.next;
        curr_node.next = new_node;

        return list;
    }

    public static LinkedList deleteAtGivenPos(LinkedList list,int pos)
    {
        //to delete node at nth pos, we need reference to n-1 node, for which we'll require n-2 hops
        if(pos == 1)
        {
            Node temp = list.head;
            list.head = temp.next;
            return list;

        }
        int cnt = 0;
        Node curr_node = list.head;
        while(cnt<pos-2)
        {
            curr_node = curr_node.next;
            cnt++;
        }

        // delete node at given pos
        Node temp = curr_node.next;
        curr_node.next = temp.next;

        return list;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        insert(list,1);
        insert(list,2);
        insert(list,3);
        insert(list,4);
        printList(list);
        deleteAtGivenPos(list,1);
        printList(list);


    }


}
 class Node{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Node)) return false;
         Node node = (Node) o;
         return data == node.data && Objects.equals(next, node.next);
     }


 }
