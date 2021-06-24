#include <iostream>element 
#include <vector>
using namespace std;
// a recursive function to check the first occurence of a target 
int first_occ(int* arr, int n, int key, int i)
{
    // base case
    if(n == 0) return -1; 
    // recursive call
    if(arr[0] == key) return i; 
    else  return first_occ(arr+1, n-1, key, i+1);  
}
// a recursive function to check the last occurence of a target
int last_occ(int* arr, int n, int key, int i)
{
    // base case
    if(n == 0) return -1; 
    // recursive call
    if(arr[i] == key) return i; 
    else  return last_occ(arr+1, n-1, key, i -1);  
}
// a recursive function to print the all occurence of a target
void all_occ(int* arr, int n, int key, int i)
{
    // base case
    if(n == 0) return; 
    // recursive call
    if(arr[0] == key) cout<<i<<endl; 
    first_occ(arr+1, n-1, key, i+1);  
}
// a recursive function to return  the all occurence of a target
int* all_occ(int* arr, int n, int key, int i,)
{
    // base case
    if(n == 0) return; 
    // recursive call
    if(arr[0] == key) cout<<i<<endl; 
    first_occ(arr+1, n-1, key, i+1);  
}
int main()
{
    //size of the array
    int n;
    cin>>n;
    // define the array 
    int arr[1000];
    // take the elements of the array as input 
    for(int i = 0; i< n; i++) cin>>arr[i];

    // key for which we want to check 
    int key;
    cin>>key;


}

