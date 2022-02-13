#include<iostream>
using namespace std;

int countBitsFlip(int a, int b){
        
        // Your logic here
        int result = a ^ b;
        int answer = 0;
        while(result > 0){
            result = result & (result - 1);
            answer++;
        }
        return answer;
}
int main()
{
    cout<<countBitsFlip(10,20);
    return 0;
}