#include<iostream>
#include<cmath>
using namespace std;

int countDigitBest(int n){
    return floor(log10(n)+1);
}
int main()
{
    cout<<countDigitBest(1235345)<<endl;
    return 0;
}