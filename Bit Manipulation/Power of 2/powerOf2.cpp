//Check whether the given number is power of 2 or not 
#include<iostream>
using namespace std;

//This is a noob approach
bool isPow2(int n)
{
    if(n == 0)
        return true;
    
    while(n != 1)
    {
        if(n % 2 != 0)
            return false;
        
        n = n / 2;
    }
    
    return true;
}

bool isPow2Eff(int n)
{
    if(n == 0)
        return true;
    
    return ((n & (n - 1)) == 0);
}

int main()
{
    cout<<(isPow2(4)?"Yes":"No")<<endl;
    cout<<(isPow2Eff(12)?"Yes":"No")<<endl;
    return 0;
}