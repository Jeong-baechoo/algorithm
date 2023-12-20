#include<bits/stdc++.h>
using namespace std;

int a[1002][1002];
bool isvisited[1002][1002];
int n,m;
queue<pair<int,int>> q;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

void bfs(){
    
    while (q.size())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny > m || isvisited[nx][ny]) continue;
            if(a[nx][ny] == 0) continue;
            a[nx][ny] = a[x][y] + 1;
            isvisited[nx][ny] = true; 
            q.push(make_pair(nx,ny));
        }
        
    }
    
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> a[i][j];
            if(a[i][j] == 2){
                a[i][j] = 0;
                isvisited[i][j] = true;
                q.push(make_pair(i,j));
            }
        }
        
    }
    
    bfs();

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if(a[i][j]==1 && !isvisited[i][j]){
                a[i][j] = -1;
            }
            cout << a[i][j] << " ";
        }
        cout << '\n';
    }
    

    return 0;
}
