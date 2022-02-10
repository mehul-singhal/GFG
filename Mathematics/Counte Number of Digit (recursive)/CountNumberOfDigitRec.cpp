#include<iostream>
using namespace std;

int countDigitRec(int n){
    if (n == 0)
        return 0;
    else
        return 1+countDigitRec(n/10);    
}
int main()
{
    cout<<countDigitRec(13245)<<endl;
    return 0;
}