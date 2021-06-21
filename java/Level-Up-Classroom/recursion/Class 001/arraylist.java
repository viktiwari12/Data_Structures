import java.io.*;
import java.util.*;
public class arraylist 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> sbsq = getsubsequence(str);
        for(String i: sbsq)
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

}
