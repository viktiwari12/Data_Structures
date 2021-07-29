public class addtwonum {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // edge cases 
            // 1- if both list doesn't exist
        if(l1 == null && l2 == null ) return l1;
            //edge case 2- if any one list doesn't exist
         if(l1 == null || l2 == null ) return l1 == null ? l2 : l1;
        
        // let's first solve it by reversing the lists 
        ListNode rl1 = reverse(l1), rl2 = reverse(l2);
        
        // now add the two nubers 
        ListNode sum = new ListNode();
        ListNode i = sum; // a itetrator for sum list 
        int carry = 0, temp = 0;
        while(rl1 != null || rl2 != null ){
            if(rl1 == null ){
                temp = carry + rl2.val;
            }else if(rl2 == null ){
                temp = carry + rl1.val;
            }else{
                temp = carry + rl1.val + rl2.val; 
            }
            carry = temp/10;
            temp = temp > 9? temp % 10: temp;
            i.next = new ListNode(temp);
            i = i.next;
        }
        if( carry > 0 ) si.next = new ListNode(carry);  
        // now first reverse the sum list and then reverse it 
        return reverse(sum.next);
    }
    // a function to reverse the linkedlist 
    public ListNode reverse(ListNode head ){
        // edge case 
        if(head== null || head.next == null) return head;
        ListNode pre = null, curr = head, frw = null;
        while(curr != null){
            frw = curr.next;
            curr.next = pre;
            pre = curr;
            curr = frw;
        }
        return pre;
    }
    
}
    
}
