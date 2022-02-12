#include<iostream>
#include<vector>
using namespace std;

//Sieve algorithm is used to find prime numbers smaller or equal to a given number 
//the complexity of this algorithm is O(nloglogn) which is much lesser than the other knows algorithms

void sieveBasic(int n){
    vector<bool> isPrime(n+1, true);
    for(int i=2;i*i<=n; i++){
        if(isPrime[i]){
            for(int j = 2*i; j<=n; j=j+i){
                isPrime[j] = false;
            }
        }
    }
    for(int i = 2;i<=n;i++){
        if(isPrime[i])
            cout<<i<<" ";
    }
}

void sieveOptimised(int n){
    vector<bool> isPrime(n+1, true);
    for(int i = 2;i<=n; i++){
        if(isPrime[i]){
            cout<<i<<" ";
            for(int j = i*i; j<=n ;j = j+i){
                isPrime[j] = false;
            }
        }
    }
}
int main()
{
    sieveBasic(15);
    cout<<endl;
    sieveOptimised(15);
    return 0;
}