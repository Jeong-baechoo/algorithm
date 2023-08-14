#include<bits/stdc++.h>
using namespace std;

long long Combi(int m, int n)
{
    vector<int> v(m,1);
    vector<int> visit(m);
    fill(visit.end()-n,visit.end(),1);
    long long count = 0;
    do
    {
        // for (int i = 0; i < visit.size(); i++)
        // {
        //     cout << visit[i] << " ";
        // }
        count ++;
        // cout << '\n';
    } while (next_permutation(visit.begin(),visit.end()));
    
    return count;
}

int main () {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--)
    {
        int n,m;

        cin >> n >> m;

        cout << Combi(m, n); // mCn

        cout << '\n';
    }
    
    return 0;
}