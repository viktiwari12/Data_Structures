import java.io.*;
import java.io.ObjectOutputStream.PutField;
import java.util.*;
public class arraylist 
{
    // we are declearing a global variable, for get kpc queston 
    static String keys[] =  {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println("GET SUBSEQUENCE ANSWERS");
        ArrayList<String> sbsq = getsubsequence(str);
        for(String i: sbsq)
        {
            System.out.println(i);
        }
        System.out.println("GET KPC ANSWERS");
        ArrayList<String> kpc = getkpc("478");
        for(String i: kpc)
        {
            System.out.println(i);
        }
    }
    public static ArrayList<String> getsubsequence(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> ans1 = new ArrayList<>();
            ans1.add("");
            return ans1;
        }

        String ch = str.charAt(0) + "";
        ArrayList<String> temp = getsubsequence(str.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for(String  i : temp)
        {
            ans.add(i);
            ans.add(ch +i);
        }
        return ans; 
    }
    public static ArrayList<String> getkpc(String str) 
    {
        // base case
        if(str.length() == 0)
        {
            ArrayList<String> brs = new ArrayList<>();
            brs.add("");
            return brs;
        }
        // store the first character of string 
        char ch = str.charAt(0);
        // get all the keys assigned to that no
        String avlkey = keys[ch - '0']; // avlkeys --> available keys
        // break the string from first character
        String mdfstr = str.substring(1);
        // A temperoary arraylist to store the kpc of the modified string 
        ArrayList<String> temp = getkpc(mdfstr);
        
        // A new Arraylist to store all the possible kpc
        ArrayList<String> ans = new ArrayList<>();
        // for each string in arraylist temp
        for(String i : temp)
        {
            // for each character of the available keys 
            for(int j = 0; j< avlkey.length(); j++)
            {
                String s = avlkey.charAt(j) + "";
                // add each character to the string simuntaneously 
                ans.add(s + i);
            }
        }
        // return the ans arraylist 
        return ans; 
    }

}
