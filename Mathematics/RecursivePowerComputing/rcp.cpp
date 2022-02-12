#include<iostream>
using namespace std;

int recComputingPower(int x,int n){
    if (n == 0)
        return 1; 
    int temp = recComputingPower(x,n/2);
    temp = temp*temp;
    if(n%2 == 0)
        return temp; 
    else 
        return temp * x;
}


int main()
{
    cout<<recComputingPower(4,2);
    return 0;
}