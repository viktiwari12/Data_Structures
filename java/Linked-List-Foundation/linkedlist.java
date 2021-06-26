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
        System.out.println("Enter the element  you wish c to insert and the index of the linkedlist at whcichyou wish to enter");
        int data = scn.nextInt();
        int index = scn.nextInt();
        add_at_Index(head, data, index);
        remove_first(head);
        remove_last(head);
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
        node temp = head;
        int count = 1;
        node idx = new node(data);
        //node temp = head;
        while(count < index -1){
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
    //
    


}
