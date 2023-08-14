#include <bits/stdc++.h>
using namespace std;


int area[101][101];
int isVisitd[101][101];
int cost[101][101];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int n;

void number()
{
    int num = 1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (area[i][j] > 0 && !isVisitd[i][j])
            {
                queue<pair<int, int>> q;
                q.push({i, j});
                area[i][j] = num;
                isVisitd[i][j] = true;
                while (!q.empty())
                {
                    int x = q.front().first;
                    int y = q.front().second;
                    q.pop();
                    for (int dir = 0; dir < 4; dir++)
                    {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                            continue;
                        if (area[nx][ny] == 0 || isVisitd[nx][ny])
                            continue;
                        area[nx][ny] = num;
                        isVisitd[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
                num++;
            }
        }
    }
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> area[i][j];
        }
    }

    number(); //각 섬을 구분지어준다.
    queue<pair<int,int>> q;
    for(int i = 0; i < n; i++){ // 모든 육지를 큐에 삽입
        for(int j = 0; j < n; j++){
            if(area[i][j] != 0){
                cost[i][j] = 0;
                q.push({i,j});
            }
        }
    }
    int ans = INT_MAX;
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int dir = 0; dir < 4; dir++)
        {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(area[nx][ny] == area[x][y]) continue; //같은 땅일 경우
            if(area[nx][ny] != 0){ // 인접한 곳이 다른 섬일 경우
                ans = min(ans,cost[nx][ny]+cost[x][y]); // nx, ny는 1번땅 x,y는 2번땅의 좌표라고 했을때 두 거리의 합은 두 섬간의 거리가 된다.
            }
            else{ //바다일 경우
                area[nx][ny] = area[x][y];
                cost[nx][ny] = cost[x][y] + 1;
                q.push({nx,ny});
            }

        }
        
    }
    
    cout << ans;
    return 0;
}
