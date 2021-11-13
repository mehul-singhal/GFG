#include<iostream>
using namespace std;

void leader(int arr[], int n){

    int leader = arr[n-1];
    int count = 0;
    int *temp = new int(n);
    temp[0] = count;
    for(int i = n-2; i>=0; i--){
        if(leader < arr[i]){
            count++;
            leader = arr[i]; 
            temp[count] = leader;
        }
    }
    int tempSize = sizeof(temp)/sizeof(temp[0]);
    for(int i =0;i<tempSize; i++){
        cout<<temp[i]<<" ";
    }
}

int main()
{
    int arr[] = {2,10,4,10,6,5,2};
    int n = sizeof(arr)/sizeof(arr[0]);
    leader(arr,n);
    return 0;
}