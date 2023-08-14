#include<bits/stdc++.h>
using namespace std;

int d[41]; //각 영역의 크기에 따른 앉을수있는 사람의 수
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    vector<int> seats;
    d[0] = 1; //vip만이 있을때를 고려
    d[1] = 1;
    d[2] = 2;
    for (int i = 3; i <= n; i++)
    {
        d[i] = d[i-1] + d[i-2];
    }
    
    int vips;
    int start= 1;
    cin >> vips;
    for (int i = 0; i < vips; i++)
    {
        int vip;
        cin >> vip;
        seats.push_back(vip-start);
        start = vip + 1;
    }
    seats.push_back(n-start+1);

    int ans = 1;
    for (int i = 0; i < seats.size(); i++)
    {
        ans *= d[seats[i]];
    }
    cout << ans;
    
    return 0;
}
