#include<bits/stdc++.h>
using namespace std;

using ll = long long;


ll recursive(ll a, ll b, ll c){
    if(b == 1) return a % c;
    
    ll result = recursive(a, b/2 ,c);
    result = result * result % c;
    if(b % 2==0) return result;
    return result * a % c;

}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    ll a,b,c;
    cin >> a >> b >> c;
    cout << recursive(a, b, c);
}