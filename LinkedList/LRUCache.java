package LinkedList;

import java.util.HashMap;

public class LRUCache {
    public int max_size;
    public int curr_size;
    Node head;
    Node tail;
    HashMap<Integer, Node> keyToAddress = new HashMap<>();
    LRUCache(int capacity)
    {
        max_size = capacity;
        curr_size = 0;
        head = null;
        tail = null;
    }

    Node addToTail(int key, int val)
    {
        Node n = new Node(key, val);
        if(tail == null)
        {
            head = n;
            tail = n;
         }
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        curr_size++;
        return n;
    }

    void moveToTail(Node node, int val)
    {
        node.val = val;
        if(node == tail)
            return;
        if(node == head)
        {
            head = head.next;
            head.prev = null;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    void deleteAtHead()
    {
        Node temp = head;
        head = head.next;
        if(head != null)
        {
            head.prev = null;
        }
        else tail = head;
        curr_size --;
    }

    int get (int key)
    {
        int ans;
        if(keyToAddress.get(key) == null)
            ans = -1;
        else {
            Node n = keyToAddress.get(key);
            ans = n.val;
            moveToTail(n,n.val);
        }
        return ans;
    }

    void put(int key, int val)
    {
        if(keyToAddress.get(key) != null)
        {
            moveToTail(keyToAddress.get(key),val);
            return;
        }
        if(curr_size < max_size)
        {
            keyToAddress.put(key,addToTail(key,val));
        }
        else {
            keyToAddress.remove(head.key);
            deleteAtHead();
            keyToAddress.put(key,addToTail(key,val));
        }
    }


class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val)
    {
        key = key;
        val = val;
        prev = null;
        next = null;
    }
}
}
