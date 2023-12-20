#include<bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--)
    {
        int d[10002][21] = {0,};
        int n;
        cin >> n;
        vector<int> coins;
        for(int i = 0; i < n; i++){
            int coin;
            cin >> coin;
            coins.push_back(coin);
        }

        int money;
        cin >> money;
        d[0][0] = 1;
        for (int i = 1; i <= money; i++)
        {
            for (int j = 0; j < coins.size(); j++)
            {
                if(coins[j] > i) break;
                for (int k = 0; k <= j; k++)
                {
                    d[i][j] += d[i-coins[j]][k];
                }
            }
        }

        cout << accumulate(d[money], d[money]+n,0) << '\n';   
    }

    return 0;
}
