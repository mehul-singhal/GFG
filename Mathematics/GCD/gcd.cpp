#include<iostream>
#include<cmath>
using namespace std;

int gcd(int a, int b){
    if(a == 0 || b == 0){
        return 0;
    }
    int result = min(a,b);
    while(result > 0){
        if(a%result ==0 && b%result == 0){
            break;
        }
        result--;
    }
    return result;
}

int gcdBetter(int a, int b){
    while(a!=b){
        if(a>b)
            a = a-b;
        else
            b = b-a;
    }
    return a;
}

int gcdBest (int a, int b){
    if (b == 0)
        return a;
    else
        return gcdBest(b,a%b);
}
int main()
{
    cout<<gcd(24,16)<<endl;
    cout<<gcdBetter(24,16)<<endl;
    cout<<gcdBest(24,16)<<endl; 
    return 0;
}