#include<iostream>
using namespace std;
long factorial(int n){

    long result = 1;
    for(long i = 2;i<=n;i++){
        result = result * i;
    }
    return result; 
}

long factorialRecursive(int n){
    if(n == 1){
        return 1;
    }
    else
        return n*factorialRecursive(n-1);
}
int main()
{
    cout<<factorial(25)<<endl;
    cout<<factorialRecursive(20)<<endl;
    return 0;
}