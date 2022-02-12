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
        n = (n & (n-1));
        result++;
    }
    return result;
}


//The look up table method
int table[256];

void initialize(){
    table[0] = 0; 
    for(int i = 0;i<256;i++){
        table[i] = (i&1) + table[i/2];
    }
}

int countSetBitsUsingLookUpTable(int n){
    initialize();
    return table[n & 0xff] + table[(n>>8) & 0xff] +table[(n>>16) & 0xff] + table[n>>24];
}

int main()
{
    cout<<countSetBitBasic(5)<<endl;
    cout<<countSetBitsOptimised(7)<<endl;
    cout<<countSetBitsUsingLookUpTable(9)<<endl;
    return 0;
}