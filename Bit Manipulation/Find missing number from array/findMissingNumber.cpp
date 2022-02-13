#include<iostream>
using namespace std;

//You are given a list of n-1 integers and these integers are in the range of 1 to n. 
//There are no duplicates in the list. One of the integers is missing in the list. 
//Write an efficient code to find the missing integer.
int findMissing(int arr[], int n){
    int result = 0; 
    for(int i = 0;i<n-1;i++){
        result ^= arr[i];
    }
    for(int i = 1;i<=n;i++){
        result ^= i;
    }
    return result;
}

int getMissingNo(int a[], int n)
{
    // For xor of all the elements in array
    int x1 = a[0];
 
    // For xor of all the elements from 1 to n+1
    int x2 = 1;
 
    for (int i = 1; i < n; i++)
        x1 = x1 ^ a[i];
 
    for (int i = 2; i <= n + 1; i++)
        x2 = x2 ^ i;
 
    return (x1 ^ x2);
}

int main()
{
    int arr[]= {1,2,3,4}, n = 5;
    cout<<findMissing(arr,n);
    return 0;
}