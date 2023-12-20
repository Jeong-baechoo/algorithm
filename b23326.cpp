#include<bits/stdc++.h>
using namespace std;

int n,q;
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> q;

    set<int> a;
    for (int i = 1; i <= n; i++)
    {
        int x;
        cin >> x;
        if(x == 1) a.insert(i);
    }
    int x = 1;
    while (q--)
    {
        int com;
        cin >> com;
        if(com == 1){
            int num;
            cin >> num;

            if(a.find(num) == a.end()){
                a.insert(num);
            } else{
                a.erase(num);
            }
        } else if (com == 2)
        {
            int dx;
            cin >> dx;

            x = (x + dx - 1) % n + 1;
        } else{
            if(a.empty()) cout << -1 <<'\n';
            else{
                auto lower = a.lower_bound(x);
                if(lower != a.end()) {
                    cout << *lower - x << '\n';
                } else{
                    cout << n - x + *a.begin() <<'\n';
                }   
            }
        }
        
    }
    
    return 0;
}
