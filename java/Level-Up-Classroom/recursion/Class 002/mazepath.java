import java.io.*;
import java.util.*;
import java.io.ObjectOutputStream.PutField;
public class mazepath 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        // get stair path for single jump 
        ArrayList<String> mazpth = mazepath_HVD(0, 0, row -1, col - 1);
        System.out.println(mazpth);
        // printstair path for single jump 

        System.out.println("Now Print path");
        mazepath(0, 0, row -1, col - 1, "");
    }
    // 
    public static ArrayList<String> mazepath_HVD(int sr, int sc, int er, int ec)
    {
        // base case 
        if( sr == er  && sc == ec )
        {
            ArrayList<String> base_path= new ArrayList<>();
            base_path.add("");
            return base_path;
        }
        // handling of of box index
        else if(sr > er || sc > ec)
        {
            ArrayList<String> base_path= new ArrayList<>();
            return base_path; 
        }

        // horizontal move
        ArrayList<String> hori = mazepath_HVD(sr, sc+ 1, er, ec);
        // vertical move
        ArrayList<String> vertical = mazepath_HVD(sr +1, sc, er, ec);
        // diagonal move
        ArrayList<String> diagonal = mazepath_HVD(sr+1, sc+1, er, ec);
        
        // An arraylist to store all the paths
        ArrayList<String> HVD_path = new ArrayList<>();
        //  updating paths found from horizontal moves
        for(String i : hori)
        {
            HVD_path.add("h" + i);
        }
        //  updating paths found from vertical moves
        for(String i : vertical)
        {
            HVD_path.add("v" + i);
        }
        //  updating paths found from diagonal moves
        for(String i : diagonal)
        {
            HVD_path.add("d" + i);
        }
        return HVD_path;
    }
    public static void mazepath(int sr, int sc, int er, int ec, String path)
    {
        // base case 
        if(sr == er && sc == ec) System.out.println(path);
        // handeling out of box index
        if(sr > er || sc > ec) return;
        // horizontal jumps
        mazepath(sr, sc+ 1, er, ec, path + "h");
        // vertical jumps
        mazepath(sr +1, sc, er, ec, path+ "v");
        // diagonal jumps
        mazepath(sr + 1, sc+ 1, er, ec, path + "d");
    }

}
