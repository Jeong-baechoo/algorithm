#include<bits/stdc++.h>
using namespace std;


int n;

vector<pair<int,int>> flower;

#define X first
#define Y second


int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    
    for (int i = 0; i < n; i++)
    {
        int start_m;
        int start_d;
        int end_m;
        int end_d;

        cin >> start_m >> start_d >> end_m >>end_d;
        flower.push_back({start_m*100+start_d, end_m*100+end_d});
    }
   
    int t = 301; // 현재 시간
	int ans = 0; // 선택한 꽃의 개수

    while (t < 1201)
	{
		int nxt_t = t; // 이번에 추가할 꽃으로 인해 변경된 시간
		for(int i = 0; i < n; i++)
		{
			if(flower[i].X <= t && flower[i].Y > nxt_t)
				nxt_t = flower[i].Y;
		}
		if(nxt_t == t)
		{ // 시간 t에서 더 전진이 불가능
			cout << 0;
			return 0;
		}
		ans++;
		t = nxt_t;
	}
	cout << ans << "\n";
    return 0;
}