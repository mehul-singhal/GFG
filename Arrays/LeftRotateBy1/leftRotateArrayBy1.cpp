#include<iostream>
using namespace std;

void leftRotateBy1(int arr[], int n){
    int first = arr[0];
    for(int i = 0;i<n;i++){
        arr[i-1] = arr[i];
    }
    arr[n-1] = first;
}

int main()
{
    int arr[] = {1,2,3,4,5};
    int n = sizeof(arr)/sizeof(arr[0]);
    leftRotateBy1(arr,n);
    for(int i = 0;i< n ;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}