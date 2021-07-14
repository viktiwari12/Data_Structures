import java.util.*;
import java.lang.*;
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
            // print the size of the tree
            System.out.println(size(root));
            // print the maximum node of the tree
            System.out.println(max(root));
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
    // a function to return the size of the generic tree
    public static int size(node root){
        if(root == null ) return 0;
        // root node 
        int sz = 1; 

        // size will be size of the root node + size of the each child node 
        for(node child : root.children){
            sz += size(child);
        }
        return sz;
    }
    // a function to return the maximum node of the  of the generic tree
    public static int max(node root){
        if(root == null ) return 0;
        // root node 
        int ans = root.data; 

        // size will be size of the root node + size of the each child node 
        for(node child : root.children){
            ans  = Math.max(ans, max(child));
        }
        return ans;
    }
    // a function to return the hight of the  of the generic tree
    public static int height(node root) {
        // write your code here
        if(root == null ) return 0;
        
        int hgt = -1;
        for (node child : root.children){
            hgt = Math.max(height(child), hgt);
        }
        return ++hgt;
      }
      // pre and post order traversal of generic tree
    public static void traversals(node root){
        // write your code here
        // edge case 
        if(root == null )return ;
        // node pre area
        System.out.println("Node Pre " + root.data);
        for(node child : root.children ){
            // edge pre area  
            System.out.println("Edge Pre " + root.data  + "--" + child.data);
            // go to the next node 
            traversals(child);
            // edge post area
            System.out.println("Edge Post " + root.data  + "--" + child.data);
        }
        // node post area
        System.out.println("Node Post " + root.data);
      }
    
}
