#include <bits/stdc++.h>
using namespace std;
/*
처음에는 단순하게 o(n^2)로 풀었는데 문제 조건을 보니까 시간복잡도가 초과하므로 이렇게하면 안된다는 것을 알았음
자연수 x를 ai로 뺀 aj가 수열에 존재하면 별다른 탐색없이 조건이 만족함으로 o(n)으로 통과할 수 있다.

*/
int a[1000001]={};
// 각 자연수의 존재 여부를 저장하는 배열
bool occur[2000001];
int n, x;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
     int ans = 0;
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    cin >> x;

    for (int i = 0; i < n; i++) {
    // x-a[i]가 존재하는지 확인
    if(x-a[i] > 0 && occur[x-a[i]]) ans++;
    occur[a[i]] = true;
  }
  cout << ans;
}
