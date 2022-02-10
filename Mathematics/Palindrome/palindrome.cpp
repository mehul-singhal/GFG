#include<iostream>
using namespace std;

bool palindrome(int data){
    int result = 0; 
    int n = data;
    while(n > 0){
        int temp = n%10; 
        result = result*10 + temp; 
        n = n/10;
    }
    if(data == result)
        return true; 
    else 
        return false;
}

int main()
{
    cout<<palindrome(1221)<<endl;
    return 0;
}