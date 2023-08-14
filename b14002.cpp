#include<bits/stdc++.h>
using namespace std;
int a[1005];
int lis[1005];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }
    
    fill(begin(lis),end(lis),1);

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < i; j++)
        {
            if(a[i] > a[j]){
                lis[i] = max(lis[i], lis[j] + 1);
            }
        }
    }
    
    int max_length = *max_element(lis+1, lis+n+1);

    int current_length = max_length;

    vector<int> result;
    for (int i = n; i >= 1; --i) {
        if (lis[i] == current_length) {
            result.push_back(a[i]);
            --current_length;
        }
    }

    
    cout << max_length << '\n';

    for (int i = result.size()-1; i >= 0; i--)
    {
        cout << result[i] << " ";
    }
    
    
    return 0;
}
