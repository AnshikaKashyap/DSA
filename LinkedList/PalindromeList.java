package LinkedList;

import static LinkedList.ReverseLinkedList.reverseListRecursively;
/*
We have been given a linked list where every node contains a digit ∈ [0, 9]. Check whether it is a palindrome or not.
Input: 1 → 0 → 3 → 0 → 1
Output: true*/
public class PalindromeList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 3);
        list.insert(list, 2);
        list.insert(list, 1);
        System.out.println(isPalindrome(list));

    }
    static boolean isPalindrome(LinkedList list)
    {
        Node head = list.head;
        Node mid = findMiddleNode(list);
        Node reverse_head = reverseListRecursively(mid);
        while(head != null && reverse_head != null)
        {
            if(head.data != reverse_head.data)
                return false;
            else {
                head = head.next;
                reverse_head = reverse_head.next;
            }
        }
        return true;

    }

    static Node findMiddleNode(LinkedList list)
    {
        Node slow = list.head;
        Node fast = list.head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
