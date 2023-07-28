#include<bits/stdc++.h>
using namespace std;

int N;
int Count1,Count2;

char Map[101][101];
bool isCheck[101][101];
queue<pair<int,int>> qu;
void bfs1(){
    int dx[4] = {1,-1,0,0};
    int dy[4] = {0,0,1,-1};

    while (!qu.empty())
    {
        pair p = qu.front();
        qu.pop();
        int x = p.first;
        int y = p.second;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(isCheck[nx][ny]) continue;
            if(Map[nx][ny] == Map[x][y]){
                qu.push(make_pair(nx,ny));
                isCheck[nx][ny] = true;
            }
        }   
    }
    Count1++;
}

void bfs2(){
    int dx[4] = {1,-1,0,0};
    int dy[4] = {0,0,1,-1};

    while (!qu.empty())
    {
        pair p = qu.front();
        qu.pop();
        int x = p.first;
        int y = p.second;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(isCheck[nx][ny]) continue;
            
            if(Map[x][y] == 'R'){
                if(Map[nx][ny] == 'R' || Map[nx][ny] == 'G'){
                    qu.push(make_pair(nx,ny));
                    isCheck[nx][ny] = true;        
                }
            } 
            else if (Map[x][y] == 'G')
            {
                if(Map[nx][ny] == 'R' || Map[nx][ny] == 'G'){
                    qu.push(make_pair(nx,ny));
                    isCheck[nx][ny] = true;        
                }
            }
            else if (Map[x][y] == Map[nx][ny])
            {
                qu.push(make_pair(nx,ny));
                isCheck[nx][ny] = true;  
            }
        }   
    }
    Count2++;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> Map[i][j];
        }
        
    }
    // 적록색약이 아닌 경우
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if(!isCheck[i][j]){
                qu.push(make_pair(i,j));
                isCheck[i][j] = true;
                bfs1();
            }
        }
        
    }

    memset(isCheck, false, sizeof(isCheck));
    //적록색약인 경우
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if(!isCheck[i][j]){
                qu.push(make_pair(i,j));
                isCheck[i][j] = true;
                bfs2();
            }
        }
        
    }
    cout << Count1 << " " << Count2;

    return 0;
}
