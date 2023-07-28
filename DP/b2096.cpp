#include <bits/stdc++.h>
using namespace std;

int stair[100001][3];
int Min[100001][3];
int Max[100001][3];
int N;


int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    cout << min({1,2,3});
    for (int i = 1; i <= N; i++)
    {
        for (int j = 0; j < 3; j++)
        {
           cin >> stair[i][j]; 
        }
        
    }
    
    return 0;
}
