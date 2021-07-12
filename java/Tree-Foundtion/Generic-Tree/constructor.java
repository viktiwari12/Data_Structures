package Generic

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.traversal.NodeIterator;

-Tree;

public class constructor {
    // make a node class
    public class node{
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
            node root;
            // take a stack 
            Stack<node> st = new Stack<>();
            for(int i = 0; i< arr.length; i++){
                // if stack is empty then make the root 
                if(st.empty()){
                    root = new node(arr[i]);
                    st.push(root);
                } 

                // if the no is -1 then pop the stack;
                if(arr[i] == -1) st.pop();

                //  now if the next no is not -1 then make a node and make it the children of the node present on the top of the stack 
                st.peek().children.add(new node(arr[i]));
            }
    }
}
