#include<iostream>
using namespace std;

void reverseArray(int arr[], int n){

    int start = 0; 
    int end = n-1;
    while(start<end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp; 
        start++;
        end--; 
    }
}

int main()
{
    int arr[] = {10,7,5,2,4,4,6,6,8,9};
    int n = sizeof(arr)/sizeof(arr[0]);
    reverseArray(arr,n);
    reverseArray(arr,n);
    for(int x: arr){
        cout<<x<<endl;
    }
    return 0;
}