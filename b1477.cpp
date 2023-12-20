#include<bits/stdc++.h>
using namespace std;

vector<int> v;
int n,m;
int length;

bool solve(int x){
    int cnt = 0;
    for (int i = 1; i < v.size(); i++)
    {
        int dist = v[i] - v[i-1];
        cnt += dist / x;
        if(dist % x == 0){ //우리가 정한 길이 x와 dist가 같다는건 이미 휴게소가 있는 위치에 또 휴게소를 세운다는 의미
            cnt--;
        }
    }
    return cnt > m; // 우리가 정한 길이가 추가로 만들려는 휴게소보다 많은 경우 길이를 늘려야함
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    cin >> m;
    cin >> length;
    
    for (int i = 0; i < n; i++)
    {
        int location;
        cin >> location;
        v.push_back(location);
    }

    v.push_back(0);
    v.push_back(length);
    
    sort(v.begin(),v.end());
    int st = 1;
    int en = length;

    while (st <= en)
    {
        int mid = (st+en)/2;
        if(solve(mid)) st = mid+1;
        else en = mid - 1;
    }
    
    cout << st;
    
    return 0;
}
