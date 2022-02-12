//Find total number of set bits uptill a number 
#include<iostream>
#include<cmath>
using namespace std;

//Method 1
int findTotalSetBits(int n){
    if (n<=1)
        return n;
        //This is to find how many bits of 2 were used to create n
        //We are finding this so that we can get to the closest 2 power
    int x = (int)log2(n);

        //x*(pow(2,x-1) -> to find out all the bits from 0 - (2^x)-1
        //n-pow(2,x)+1 -> to get all the 1 in the extra 2 bit added after x
        //recursively call the same function for the remaining bits
    return (int) (x*(int)pow(2,x-1))+(n-(int)pow(2,x)+1)+findTotalSetBits(n-(int)pow(2,x));
    //alternativtely you can also return 
    //return (int) ((1<<x-1)*x)+(n-(1<<x)+1)+findTotalSetBits(n-(1<<x));
}

//Method 2 - The editorial method
int findTotalSetBits2(int n){
    //Ignore 0 as all the bits and unset.
    n++;
    //to Store the powers of 2.
    int powerOf2 = 2;

    //To store the result, it in initialized
    //with n/2 because the count of set least significant bits in the integers from 1 to n is n/2.
    int count = n/2;

    //loop for every bit required to represent n; 
    while(powerOf2<=n){
        //variable to hold to total pair of 0s and 1s
        int totalPairs = n/powerOf2;

        //totalPairs/2 gives us the total count of pair of 1s
        //Multiplying it with the current power of 2 will give the count of 1s in the current bit. 
        count += (totalPairs/2)*powerOf2;

        //if the count of pairs was odd then add the remaning 1s which not be grouped together. 
        count += (totalPairs & 1) ? (n%powerOf2):0;

        //Next power of 2
        powerOf2 <<= 1;
    }
    return count;
}

int main()
{
    cout<<findTotalSetBits2(4)<<endl;
    cout<<findTotalSetBits(4);
    return 0;
}