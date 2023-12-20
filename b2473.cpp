#include<bits/stdc++.h>
using namespace std;

int n;
long long a[5002];
vector<int> v;
long long Min = LLONG_MAX;
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    sort(a, a+n);
    
    for (int i = 0; i < n-2; i++)
    {   
        int st = i + 1;
        int en = n - 1;

        while (st < en)
        {
            if(llabs(a[st] + a[en] + a[i]) < Min){
                Min = llabs(a[st] + a[en] + a[i]);
                v.clear();
                v.push_back(a[st]);
                v.push_back(a[en]);
                v.push_back(a[i]);
            }
            if(a[st] + a[en] + a[i] == 0){
                break;
            }
            if(a[st] + a[en] + a[i] < 0){
                st++;
            } else if(a[st] + a[en] + a[i] > 0){
                en--;
            }
        }
    }

    sort(v.begin(),v.end());
    for (int i = 0; i < 3; i++)
    {
        cout << v[i] << " ";
    }
    
    return 0;
}
