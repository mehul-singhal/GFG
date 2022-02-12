#include<iostream>
using namespace std;

void isKthBitSetLeft(int n, int k){
    if((n>>(k-1)&1) != 0)
        cout<<"Yes"<<endl;
    else
        cout<<"No"<<endl;
}

void isKthBitSetRight(int n, int k){
    if((n&(1<<(k-1))) != 0)
    {
        cout<<"Yes"<<endl; 
    }
    else 
        cout<<"No"<<endl;
}

int main()
{
    isKthBitSetRight(5,3);
    isKthBitSetLeft(5,1);
    return 0;
}