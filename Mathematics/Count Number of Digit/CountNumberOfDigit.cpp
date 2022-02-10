#include<iostream>
using namespace std;

int countDigit(int n){
    int result = 0;
    while(n > 0){
        n = n/10;
        result++;
    }
    return result;
}
int main()
{
    cout<<countDigit(12345)<<endl;
    return 0;
}