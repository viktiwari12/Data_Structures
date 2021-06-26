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
        //int data = scn.nextInt();
        node head = createlinkedlist();
        print_linkedlist(head);
        System.out.println("Enter the element you wish to insert at the first of linkedlist");
        int first = scn.nextInt();
        head = add_first(head, first);
        print_linkedlist(head);
        System.out.println("Enter the element you wish to insert at the last of linkedlist");
        int last = scn.nextInt();
        add_last(head, last);
        print_linkedlist(head);

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
    // ptint the linked list 
    public static void print_linkedlist(node head){
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    // add an element at the first of the linkedlist 
    public static node add_first(node head, int data){
        node first = new node(data);
        first.next = head;
        head = first;
        return head;
    }
    // add an element at the LAST of the linkedlist 
    public static void add_last(node head, int data){
        node last = new node(data);
        //node temp = head;
        while(head.next != null) head = head.next;
        head.next = last;
        
    }
}
