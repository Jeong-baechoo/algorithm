#include<bits/stdc++.h>
using namespace std;

long long a,b;
long long Min = 1000000000;
void func(long k,long cnt){
    if(k == b){
        if(cnt < Min) Min = cnt;
        return;
    }
    if(k > b){
        return;
    }
    func(k*2,cnt + 1);
    func(k*10 + 1, cnt + 1);

}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> a >> b;
    func(a,1);
    if(Min == 1000000000)cout << -1;
    else
    {
        cout << Min;
    }
    
    return 0;
}
