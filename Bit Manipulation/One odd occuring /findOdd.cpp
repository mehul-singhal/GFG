//This is the code for finding the number in a given array whose frequency is odd
#include<iostream>
using namespace std;

int findOddFirst(int arr[], int n){
    int result = 0; 
    for(int i=0;i<n;i++){
        result = result ^ arr[i];
    }
    return result; 
}

int main()
{
    int arr[]= {4, 3, 4, 4, 4, 5, 5, 3, 3}, n = 9;
	
    cout<<findOddFirst(arr, n);
    return 0;
}