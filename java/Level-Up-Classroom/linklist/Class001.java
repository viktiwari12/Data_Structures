import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Class001 {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        
    }
    // level 2 questions 
    // middle of the question 
    public static node mid_node(node head){
        if(head == null || head.next == null) return head;
        node slow = head , fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // reverse the linked lsit (Pointer reverse)
    public static node reverse_pointer(node head){
        if(head == null || head.next == null) return head;
        node pre = null; curr = head;
        while(curr != null){
            node frd = curr.next;
            curr.next = pre;
            pre = curr;
            curr = frd;
        }
        return pre;
    }
    // is linkedlist palindrome
    public static boolean is_pallindrome(node head){
        if(head == null || head.next == null) return true;
        node start = head;
        mode mid = mid_node(head);
        node temp = mid.next;
        while(temp != null){
            if (start.data != temp.data) return false;
            start = start.next;
            temp = temp.next;
        }
        return true;
    }
    //fold a linkedliat 
    public static node fold_linkedlist(node head){
        return null;
    }
    //unfold a linkedliat 
    public static node ulfold_linkedlist(node head){
        return null;
    }


}
