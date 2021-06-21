import java.io.*;
import java.util.*;

public class floodfill 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        // no of rows 
        int n = scn.nextInt();
        //no of columns 
        int m = scn.nextInt();
        // a matrix
        int[][] arr = new int[n][m];
        // data in the matrix (Note- it can only be 1 and 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // calling the function floodfill
        floodfill(arr, 0, 0, "");
    }
    // a function to print the path 
    public static void floodfill(int[][] maze, int sr, int sc, String path) 
    {
        // base case 
        // base case 1:  return if index out of bound 
        if(sr < 0 || sc < 0  || sr > maze.length -1 ||  sc > maze[0].length -1 || maze[sr][sc] == 1)
        {
            return;
        }
        // base case 2 : prtint the path if reached at last index print the path
        if(sr == maze.length -1 && sc == maze[0].length -1)
        {
            System.out.println(path);
            return;
        }
        maze[sr][sc] = 1;
        floodfill(maze, sr -1, sc,   path + "t");
        floodfill(maze, sr, sc -1,  path + "l");
        floodfill(maze, sr +1 , sc,  path + "d");
        floodfill(maze, sr, sc +1,  path + "r");
        maze[sr][sc] = 0;

    }
    
}
