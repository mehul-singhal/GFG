#include<iostream>
using namespace std;

int largest(int arr[], int n){
    int largest = 0;
    for(int i = 1;i<n;i++){
        if(arr[i]>arr[largest]){
            largest = i; 
        }
    }
    return largest;
}

int secondBetter(int arr[], int n){
    int second = -1;
    int lar = largest(arr,n);
    for(int i = 0; i<n; i++){
        if(arr[i] != arr[lar]){
            if(second == -1){
                second = i;
            }
            else if(arr[i]>arr[second]){
                second = i;
            }
        }
    }
    return second;
}

int secondBetter(int arr[], int n){
    int second = -1; 
    int lar = largest(arr,n);
    for(int i = 1;i<n;i++){
        if(arr[i] > arr[lar]){
            second = lar;
            lar = i;
        }
        else if(arr[i]!=arr[lar]){
            if(second == -1 || arr[i]>arr[second]){
                second = i;

            }
        }
    }
    return second;
}

int main()
{
    return 0;
}