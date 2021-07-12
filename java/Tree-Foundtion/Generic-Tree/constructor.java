import java.util.*;
import java.util.ArrayList;
import java.util.Stack;


public class constructor {
    // make a node class
    public static class node{
        int data ;
        // an arraylist to store all the children 
        ArrayList<node> children = new ArrayList<>();
        // a consturctor   
        node(int data){
            this.data = data;
        }  
    }
        public static void main(String[] args) {
            // the input data 
            int arr [] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, -1, -1, -1};

            // declear a node that point to the root of the tree
            node root = null;
            // take a stack 
            Stack<node> st = new Stack<>();
            for(int i = 0; i< arr.length ; i++){
                // if the no is -1 then pop the stack;
                if(arr[i] == -1){
                    st.pop();
                } else{
                    node t = new node(arr[i]);
                    // if stack is empty then make the root
                    if(st.size() == 0){
                        root = t;
                    } 
                    /* now if the next no is not -1 then make a node 
                    and make it the children of the node present on the top of the stack  */               
                    else {
                        st.peek().children.add(t);
                    }
                    st.push(t);
                }
            }
            // display the tree
            display(root);
    }
    // a function to display the tree
    public static void display(node root){
        // first display the root and it's children 

        // take a string and store the root data in it 
        String st = root.data + ",  ->  ";
        // add the data of all the children of the root to the string 
        for(node c : root.children){
            st += c.data + ", ";
        }
        // now print the string 
        System.out.println(st + ".");

        // now recursively print  the data of all the children of the root
        for(node rc : root.children){
            display(rc);
        }
    }
}
