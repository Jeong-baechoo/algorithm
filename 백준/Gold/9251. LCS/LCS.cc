#include<bits/stdc++.h>
using namespace std;

int s[1002][1002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie();
    string A,B;

    cin >> A;
    cin >> B;

    for (int i = 1; i <= A.length(); i++)
    {
        for (int j = 1; j <= B.length(); j++)
        {
            if(A[i-1] == B[j-1]) s[i][j] = s[i-1][j-1] + 1;
            else s[i][j] = max(s[i-1][j],s[i][j-1]);
        }
        
    }
    
    
    cout << s[A.length()][B.length()];
    

    return 0;
}
