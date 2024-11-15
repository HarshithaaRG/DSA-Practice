//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
        }
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(fast.data!=slow.data){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
        
    }
    static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node nextnode=head;
        while(curr!=null){
            nextnode=nextnode.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;
    }
    
}
