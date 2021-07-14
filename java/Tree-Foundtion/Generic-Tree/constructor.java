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

      // Level order traversal of generic tree
      public static void levelOrder(node root){
        // write your code here
        // edge case 
        if(root == null ) return;
        // make a queue 
        Queue<node> q = new ArrayDeque<>();
        // add the root in the queue
        q.add(root);
        // till the queue is not empty
        while(q.size() > 0){
            // remove the top of the queue
            root = q.remove();
            // print it's data
            System.out.print(root.data + " ");
            // now add all it's child to the end of the queue 
            for(node child : root.children){
                q.add(child);
            }
        }
         // print a full stop at the end 
        System.out.println(".");
    }
    // levelorder traversal of a generic tree :-> line wise 
    public static void levelOrderLinewise(node root){
        // write your code here
        // edge case 
        if(root == null) return ;
        // make two queue
        Queue<node> q = new ArrayDeque<>();
        Queue<node> cq = new ArrayDeque<>();
        // add the root node in the queue
        q.add(root);
        while(q.size() > 0){
            // remove the top of the queue
            root = q.remove();
            System.out.print(root.data + " ");
            for(node child : root.children){
                cq.add(child);
            }
            if( q.size() == 0 ){
                q = cq;
                cq =  new ArrayDeque<>();
                System.out.println();
            } 
            
        }
      }
      // level order traversal of a generic tree in zig zag mode
      public static void levelOrderLinewiseZZ(node root){
        // write your code here
        
        // edge case 
        if(root == null) return;
        // take two stack: one for storing the root nodes and other for storing the child node of that root node 
        Stack<node> ms = new Stack<>();
        Stack<node> cs = new Stack<>();
        
        // add the root node in the main stack 
        ms.add(root);
        int level = 1;
        while(ms.size() > 0 ){
            // pop the main stack 
            root = ms.pop();
            // print it's data
            System.out.print(root.data + " ");
            // now if we are on even levvel
            if(level % 2 == 0){
                // push  the clilds of the root nodes in the child stack in right to left manner 
                for(int i = root.children.size() - 1; i >= 0; i-- ){
                    cs.push(root.children.get(i));
                }
            }else{
                // push  the clilds of the root nodes in the child stack in left to right manner 
                for(node child: root.children){
                    cs.push(child);
                }
            }
            // now check if stack is empty or not? if it's empty it means now data will be fronm next level; 
            // so update the main satack and child stack and then increase the level 
            if(ms.size() == 0 ){
                ms = cs;
                cs = new Stack<>();
                System.out.println();
                level++;
            }
        }
      }
    
}
