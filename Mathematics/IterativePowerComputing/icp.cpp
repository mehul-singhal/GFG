#include<iostream>
using namespace std;

int iterativeComputation(int x, int n){
//We are using the concept that every number can have a binary representation and we can find the power of that number using 
//the 1 bit in the power's binary representation 
//5 = 0101 so finally we'll have to find 4^2 nad 4^1 to find the result and then multiple the number it self 
// for the time you don'g have a 1 bit 
//16*4*4*4 = 1024
    int res = 1; 
    while(n>0){
        if(n%2 != 0)
            res = res*x; 
        x = x*x;
        n = n>>1;
    }
    return res;
}
int main()
{
    cout<<iterativeComputation(4,5);
    return 0;
}