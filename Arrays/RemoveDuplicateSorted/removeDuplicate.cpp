#include<iostream>
using namespace std;

void removeDuplicate(int arr[], int n){

    int res = 1;
    for(int i = 0;i<n;i++){
        if(arr[i]!=arr[res-1]){
            arr[res]= arr[i];
            res++;
        }
    }

    for(int i = 0;i<n; i++){
        cout<<arr[i]<<endl;
    }
}

int main()
{
    int arr[] = {1,1,2,2,2,2,2,2,3,4,5,6,7,8,8,8,8,8,8,8,8};
    int n = sizeof(arr)/sizeof(arr[0]);
    removeDuplicate(arr,n);
    return 0;
}