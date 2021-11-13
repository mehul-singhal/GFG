#include<iostream>
using namespace std;

bool isArraySorted(int arr[], int n){
    for(int i = 1;i<n;i++){
        if(arr[i]<arr[i-1]){
            return false;
        }
    }
    return true;
}

int main()
{
    int arr[] = {10,7,5,2,4,4,6,6,8,9};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<isArraySorted(arr,n)<<endl;
    return 0;
}