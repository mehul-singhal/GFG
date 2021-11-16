#include<iostream>
using namespace std;

void frequencyOfArray(int arr[], int n){
    int freq, i = 1;
    while(i<n){
        while(i<n & arr[i] == arr[i-1]){
            freq++;
            i++;
        }
        cout<<arr[i-1]<<" "<<freq<<endl;
        freq = 1;
        i++;
    }
    if(n==1 || arr[n-1]!= arr[n-2]){
        cout<<arr[n-1]<<" "<<1<<endl;
    }
}

int main()
{
    int arr[] = {2,3,10,6,4,8,1};
    int size = sizeof(arr)/sizeof(arr[0]);
    frequencyOfArray(arr,size);
    return 0;
}