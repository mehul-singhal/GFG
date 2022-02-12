#include<iostream>
using namespace std;

int countSetBitBasic(int n){
    int result = 0; 
    while(n>0){
        if(n&1 != 0)
            result++;
        n = n>>1;  
    }
    return result;
}

//This method is implemented using the brian kerningam's algorithm
//The algorithm specifys that if you take binary and of n and n-1 it will return a number 
//which has all the bits 0 except the right most one 
//Keep doing this until you get zero.
int countSetBitsOptimised(int n){
    int result = 0; 
    while(n>0){
        n = (n&(n-1));
        result++;
    }
    return result;
}

int main()
{
    cout<<countSetBitBasic(5)<<endl;
    cout<<countSetBitsOptimised(7)<<endl;
    return 0;
}