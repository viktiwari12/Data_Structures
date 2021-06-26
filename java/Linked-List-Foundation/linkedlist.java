import java.util.Scanner;

public class linkedlist {
    class node{
        
        int data;
        node next; 
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //int data = scn.nextInt();
        node head = createlinkedlist();
        System.out.println("Enter the element you wish to insert at the first of linkedlist");
        int data = scn.nextInt();
    
    }
    // create a linkedlist
    public static node createlinkedlist(){
        System.out.println("Enter the size of the linkedlist");
        int size = scn.nextInt();
        node head = new node(scn.nextInt()); 
        for(int i = 1; i<size; i++) head.next = new node(sc.nextInt);
        return head;
    }
}
