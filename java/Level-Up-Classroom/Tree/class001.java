import java.util.ArrayList;
import java.util.Scanner;

public class class001 {
    class treenode{
        int val;
        treenode left = null;
        treenode right = null;
        treenode(int val)
        {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        treenode root = new treenode(num);  
        
    }
    // find the size of the tree 
    public static int size(treenode root)
    {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }
    //find the depth of the tree
    public static int depth(treenode root)
    {
        return root == null ? 0 : Math.max(depth(root.left), Math.max(depth(root.right) , (root.val)));
    }
    // check weatrher  an element is present in the tree or not 
    public static boolean find(treenode root, int data)
    {
        if (root == null)return false; 
        if (root.val == data) return true;
        else return find(root.left, data) || find(root.right, data);
    }
    public static ArrayList<treenode> roottonode(treenode root,int data )
    {
        ArrayList<Integer> path = new ArrayList<>();
        if(find(root, data) == true)
        {
            while(root.val != data) path.add(root.val);
            roottonode(root.left,data );
            roottonode(root.right, data); 
        }


    }
    
}
