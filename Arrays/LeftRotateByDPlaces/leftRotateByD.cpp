#include<iostream>
using namespace std;

void reverseArray(int arr[], int start, int end){
    for(int i = start; i<end; i++){
        swap(arr[start], arr[end]);
    }
}

void rotateArrayByD(int arr[], int d, int n){
    reverseArray(arr, 0, d);
    reverseArray(arr, d, n-1);
    reverseArray(arr, 0, n-1);
    for(int i = 0;i< n;i++){
        cout<<arr[i]<<" ";
    }
}

int main()
{
    int arr[] = {1,2,3,4,5,6,7};
    int n = sizeof(arr)/sizeof(arr[0]);
    rotateArrayByD(arr,3,n);
    return 0;
}