#include<iostream>
using namespace std;
//We are fetching zeroes for a factorial value. 
//Question - How many trailing zeroes are there in a factorial
long factorial(long n){
    if(n == 1)
        return 1;
    else
        return n*factorial(n-1);
}

int getZeroes(long n){
    long result = factorial(n);
    cout<<result<<endl;
    int numberOfZeroes = 0; 
    while(result % 10 == 0){
        numberOfZeroes++; 
        result = result/10;
    }
    return numberOfZeroes;
}

int getZeroesBest(long n){
    long result = factorial(n);
    int value = 0; 
    for(int i = 5; i<=n ;i = i*5)
        value = value + n/i;
    return value;
}
int main()
{
    cout<<getZeroesBest(20)<<endl;
    return 0;
}