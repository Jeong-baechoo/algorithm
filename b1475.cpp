#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    int set[10] = {};
    int num;
    int max =0;
    cin >> num;
    while (num > 0)
    {
        set[num%10]++;
        num = num /10;
    }
    int min;
    if((set[6] + set[9]) % 2 != 0){
        min = (set[6] + set[9] + 1) / 2;
    } else{
         min = ((set[6] + set[9])/2);
    }
    set[6] = min;
    set[9] = min;
    for (int i = 0; i < 10; i++)
    {  
        if(max < set[i]){
            max = set[i];
        }
    }
     cout << max;
}
