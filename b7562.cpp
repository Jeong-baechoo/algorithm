#include<bits/stdc++.h>
using namespace std;

int Map[301][301];

vector<pair<int, int>> Move = {
    {2, 1},
    {2, -1},
    {1, 2},
    {1, -2},
    {-2, 1},
    {-2, -1},
    {-1, 2},
    {-1, -2}
};


int Bfs(int l,int ToX, int ToY, int distX, int distY){
    bool isVisited[301][301];
    memset(isVisited, false, sizeof(isVisited));
    queue<tuple<int,int,int>> q;
    q.push(make_tuple(ToX,ToY,0));
    while(!q.empty())
    {
        tuple<int,int,int> cur = q.front();
        q.pop();
        int x = get<0>(cur);
        int y = get<1>(cur);
        int count = get<2>(cur);
        if(x == distX && y == distY){
            return count;
        }
        for (int i = 0; i < 8; i++)
        {
            int dx = x + Move[i].first;
            int dy = y + Move[i].second;
            // cout << dx << " " << dy << endl;
            if (dx >= 0 && dx < l && dy >= 0 && dy < l && !isVisited[dx][dy]) {
                    q.push(make_tuple(dx,dy,count+1));
                    isVisited[dx][dy] = true;
            }
        }
        
    }
    return -1;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
   
    int T;
    cin >> T;

    while (T--) {
        int L;
        cin >> L;
        int x,y;
        cin >> x >> y;
        int distX,distY;
        cin >> distX >> distY;
        int moves = Bfs(L,x,y,distX, distY);
        cout << moves << '\n';
    }

    return 0;
}
