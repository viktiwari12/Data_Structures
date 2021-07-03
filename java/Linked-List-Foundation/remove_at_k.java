import java.util.Scanner;
import java.io.*;
import java.util.*;

public class remove_at_k {
    public static class node{
        
        int data;
        node next; 
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        node head = createlinkedlist();
        print_linkedlist(head);
        System.out.println("Enter the index of the linkedlist at whcichyou wish to remove");
        int indexr = scn.nextInt();
        remove_at_Index(head,  indexr);

    }
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
     public static void print_linkedlist(node head){
        while(head != null){
            System.out.print(head.data + ",  ");
            head = head.next;
        }
        System.out.println();
    }
    public static void remove_at_Index(node head, int index){
        node curent = head;
        int count = 0;
        while( count < index -1 ){
            System.out.println(curent.data);  
            curent = curent.next;
            count++;
        }
        curent.next = curent.next.next;
        System.out.println("Updated linkedlist");  
        print_linkedlist(head);
    }
}
