import java.io.*;
import java.util.*;

public class class001 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in); 
        int a = scn.nextInt();
        int b = scn.nextInt();

        // FOUNDATION RECURSION BASICS
        System.out.println("Prinnt Increasing ");
        printinc(a, b);
        System.out.println("Print Decreasing");
        printdec(a, b);
        System.out.println("Print increasing decreasing ");
        printincdec(a, b);
        System.out.println("Print even odd");
        printoddeven(a, b);
        System.out.println("Print Tree Path");
        printtreepath(a);
        System.out.println("Factorial ");
        System.out.println(fact(a));
        System.out.println("power ");
        System.out.println(power(a, b));

        // FOUNDATION RECURSION ARRAY 
        System.out.println("PRINT ARRAY");
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length; i++)
        {
            arr[i] = i+10;
        }
        printarray(arr, 0);
        System.out.println();
        System.out.println("PRINT ARRAY IN REVERSE");
        printarrayrev(arr, 0);
        System.out.println();
        System.out.println("Maximum number in array is   " + arrmax(arr, 0));
        System.out.println("Minimum number in array is   " + arrmin(arr, 0));
        // find element in array 
        int ansfind = arrfind(arr, 0, 13);
        if(ansfind == -1)
            System.out.println("NUMBER NOT FOUND");
        else
            System.out.println("Index of target number in array is   " + ansfind);

        // First index of a target element in an array 
        int ansfrst = arrfrst(arr, 0, 13);
        if(ansfrst == -1)
            System.out.println("NUMBER NOT FOUND");
        else
            System.out.println(" First Index of target number in array is   " + ansfrst);
        // last index of a target element in an array 
        int anslst = arrlst(arr, arr.length -1, 13);
        if(anslst == -1)
            System.out.println("NUMBER NOT FOUND");
        else
            System.out.println(" Last Index of target number in array is   " + anslst);

        // All index of a  target element in array 
        int allarr[] = findall(arr, 0, 13, 0 );
        printarray(allarr, 0);
    }

    // fuNCTIONS 

    // print increasing function from a to b 
    public static void printinc(int a, int b)
    {
        if(a > b) return;

        System.out.println(a);
        printinc(a+1, b);

    }
    // print decreasing function form b to a
    public static void printdec(int a, int b)
    {
        if(a > b) return;

        System.out.println(b);
        printdec(a, b-1);
    }
    // print increasing decreasing function 
    public static void printincdec(int a, int b)
    {
        if(a > b) return;

        System.out.println(a);
        printincdec(a+1, b);
        System.out.println(a);
    }
    // print odd even
    public static void printoddeven(int a, int b)
    {
        if(a > b) return;
        // print even while going up 
        if(a%2 ==0) System.out.println(a);
        printoddeven(a+1, b);
        //print odd while going down
        if(a%2 !=0) System.out.println(a);
    }
    // return factorial
    public static int fact(int n)
    {
        return n == 0 ? 1 :  n * fact(n-1);
    }

    // return power i.e a raised to b
    public static int power(int a, int b)
    {
        return b == 0 ? 1 : a * power(a, b-1); 
    }
    //print tree path
   public static void printtreepath(int n) 
    {
        if(n ==0) return;
        
        System.out.println("pre" + n);
        printtreepath(n-1);
        System.out.println("Inn" + n);
        printtreepath(n-1);
        System.out.println("Post" + n);
    }
    // RECURSION ARRAY

    // print array 
    public static void printarray(int arr[], int idx)
    {
        // base case
        if(idx == arr.length) return;
        // recursve call
        System.out.print(arr[idx] + ",  ");
        printarray(arr, idx +1);
    }

    // print array reverse 
    public static void printarrayrev(int arr[], int idx)
    {
        // base case
        if(idx == arr.length) return;
        // recursive call
        printarrayrev(arr, idx +1);
        System.out.print(arr[idx] + ",  ");
    }

    // maximum element in array 
    public static int  arrmax(int arr[], int idx)
    {
        // base case 
        if (idx == arr.length) return (int) -1e9;
        // recursive call
        int maxsf = arrmax(arr, idx +1);
        return  Math.max(maxsf, arr[idx]);
    }

    // minimum element in array 
    public static int  arrmin(int arr[], int idx)
    {
        // base case
        if (idx == arr.length) return (int) 1e9;
        // recursive call
        int minsf = arrmin(arr, idx +1);
        return  Math.min(minsf, arr[idx]);
    }

    // find  target element in array 
    public static int  arrfind(int arr[], int idx, int target)
    {
        // base case
        if (idx == arr.length) return  -1;

        if(arr[idx] == target) return idx; 

        int ans = arrfind(arr, idx + 1, target);
        return ans;
    }

    // first index of target elemnt in array 
    public static int  arrfrst(int arr[], int idx, int target)
    {
        // base case
        if (idx == arr.length) return  -1;

        if(arr[idx] == target) return idx; 

        int ans = arrfrst(arr, idx + 1, target);
        return ans;
    }
    // Last index of target elemnt in  array 
    public static int  arrlst(int arr[], int idx, int target)
    {
        // base case
        if (idx == -1) return  -1;

        if(arr[idx] == target) return idx; 

        int ans = arrlst(arr, idx -1, target);
        return ans;
    }
    // all index of a target element in array 
        // NOTE: Here we have to return an array which will store all the index of the target element 
    public static int[] findall(int arr[], int idx, int target, int fsf ) // fsf --> found so far
    {
        // base case 
        if( idx == arr.length) return new int[fsf] ;
        
        // recursive call 
        if(arr[idx] == target) fsf++ ;

        int ansarr[] =  findall(arr, idx + 1, target, fsf);
        if(arr[idx] == target) ansarr[fsf -1] = idx;
        return ansarr;
    }
}
