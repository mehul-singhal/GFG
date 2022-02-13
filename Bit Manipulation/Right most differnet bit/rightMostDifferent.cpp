//The code to find the right most different bit in 2 numbers
#include<iostream>
#include<cmath>
using namespace std;

int findRightDifferentBit(int m, int n){
    int result = m^n;
    if(result == 0)
        return -1;
    //This code is used for getting the position of right most bit of a number
    return log2(result & -result) + 1; 
}

int main()
{
    cout<<findRightDifferentBit(9,5);
    return 0;
}