#include<iostream>
using namespace std;

int lcmNormal(int a, int b){
    int result = max(a,b);
    while(result>0){
        if(result%a == 0 && result%b==0)
            return result;
        result++;
    }
}

int gcd(int a, int b){
    if(b == 0)
        return a;
    else
        return gcd(b, a%b);
}

int lcmBest(int a, int b){
    int value = gcd(a,b);
    return (a*b)/value;
}


int main()
{
    cout<<lcmNormal(4,6)<<endl;
    cout<<lcmBest(4,10)<<endl; 
    return 0;
}