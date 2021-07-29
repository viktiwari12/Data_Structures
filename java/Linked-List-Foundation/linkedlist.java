import java.util.Scanner;
import java.io.*;
import java.util.*;

public class linkedlist 
{
    public static class node{
        
        int data;
        node next; 
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        node head = createlinkedlist();
        print_linkedlist(head);
        System.out.println("Enter the element you wish to insert at the first of linkedlist");
        int first = scn.nextInt();
        head = add_first(head, first);
        System.out.println("Enter the element you wish to insert at the last of linkedlist");
        int last = scn.nextInt();
        add_last(head, last);
        System.out.println("Enter the element  you wish  to insert and the index of the linkedlist at whcichyou wish to enter");
        int data = scn.nextInt();
        int index = scn.nextInt();
        add_at_Index(head, data, index);
        remove_first(head);
        remove_last(head);
        System.out.println("Enter the index of the linkedlist at whcichyou wish to remove");
        int indexr = scn.nextInt();
        remove_at_Index(head,  indexr);
        System.out.println(" linkedlist with data reversed ");
        reversedata(head);
    }
    // create a linkedlist
    public static node createlinkedlist(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of the linkedlist");
        int size = scn.nextInt();
        node head = new node(scn.nextInt()); 
        node temp = head;
        for(int i = 1; i<size; i++){
            int num = scn.nextInt();
            temp.next = new node(num);
            temp = temp.next;   
            
        }  
        return head;

    }
    // size of linkedlsit 
    public static int size(node head){
        if(head == null) return 0;
        int count = 0;
        node temp = head;
        while(temp.next != null) {
            count++;
            temp = temp.next; 
        }
        return count;
    }
    // ptint the linked list 
    public static void print_linkedlist(node head){
        while(head != null){
            System.out.print(head.data + ",  ");
            head = head.next;
        }
        System.out.println();
    }
    // add an element at the first of the linkedlist 
    public static node add_first(node head, int data){
        node first = new node(data);
        first.next = head;
        head = first;
        System.out.println("Updated linkedlist");
        print_linkedlist(head);
        return head;
    }
    // add an element at the LAST of the linkedlist 
    public static void add_last(node head, int data){
        node temp = head;
        node last = new node(data);
        //node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = last;
        System.out.println("Updated linkedlist");   
        print_linkedlist(head);

    }
    // add an element at a particular index of the linkedlist 
    public static void add_at_Index(node head, int data, int index){
        if ( index == 0){
            add_first(head, data);
            return;
        }
        else if(index == size(head) -1){
            add_last(head, data);
            return;
        }
        node temp = head;
        int count = 0;
        node idx = new node(data);
        //node temp = head;
        while( count < index -1 ){
            temp = temp.next;
            count++;
        }
        idx.next = temp.next;
        temp.next = idx;
        System.out.println("Updated linkedlist");  
        print_linkedlist(head);
    }

    // remove an element at the first of the linkedlist 
    public static node remove_first(node head){
        head = head.next;
        System.out.println("Updated linkedlist");
        print_linkedlist(head);
        return head;
    }
    //remove from last 
    public static void remove_last(node head){
        node temp = head;
        while(temp.next.next != null) temp = temp.next;
        temp.next = null; 
        System.out.println("Updated linkedlist");  
        print_linkedlist(head);
    }
     // Remove an element at a particular index of the linkedlist 
     public static void remove_at_Index(node head, int index){
        if ( index == 0){
            remove_first(head);
            return;
        }
        else if(index == size(head) -1){
            remove_last(head);
            return;
        }
        node curent = head; 
        //node ahead  = curent.next;
        int count = 0;
        //node temp = head;
        while( count < index -1 ){
            curent = curent.next;
            count = count +1;
        }
        curent.next = curent.next.next;
        System.out.println("Updated linkedlist");  
        print_linkedlist(head);
    }
    // reverse the linked list ( Data reverse)
    public static void reversedata(node head){
        int sz = size(head);
        if(sz == 0){
            print_linkedlist(head);
            return;
        }
        node temp = head;
        // store all the data of linkedlist iin an array 
        int arr[] = new int [sz];
        for(int i = 0; i<sz; sz++){
            arr[i] = temp.data;
           temp =  temp.next;
        }
        // using the array store the data in linked list in reverse order
        temp = head;
        for(int j = sz -1; j>= 0; j--){
            temp.data = arr[j];
            temp = temp.next;
        }
        // now print the linkedlist
        print_linkedlist(head);
    }

}

