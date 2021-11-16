#include<iostream>
using namespace std;

int maxDiffernce(int arr[], int n)
{
    int res = arr[1]-arr[0];
    int mini = arr[0];
    for(int i = 0;i<n; i++){
        res = max(res, arr[i]-mini);
        mini = min(mini, arr[i]);
    }
    return res;
}

int main()
{
    int arr[] = {2,3,10,6,4,8,1};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<maxDiffernce(arr,n);
    return 0;
}