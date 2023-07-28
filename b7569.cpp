#include<bits/stdc++.h>
using namespace std;

int M,N,H;
int tomato[101][101][101]; // N M H
queue<tuple<int,int,int,int>> qu;
int DAY;
void bfs(){
    int dx[4]={1,-1,0,0};
    int dy[4]={0,0,1,-1};
    int dz[2]={1,-1};

    while (!qu.empty())
    {
        tuple q= qu.front();
        qu.pop();
        int x = get<0>(q);
        int y = get<1>(q);
        int z = get<2>(q);
        int day = get<3>(q);

        for (int i = 0; i < 4; i++) // 수평탐색
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(tomato[nx][ny][z] == 1 || tomato[nx][ny][z] == -1) continue; //이미 익었거나 빈 공간일 경우 패스
            qu.push(make_tuple(nx,ny,z,day+1));
            tomato[nx][ny][z] = 1;
        }
        for (int i = 0; i < 2; i++) // 수직탐색
        {
            int nz = z + dz[i];
            if(nz < 0 || nz >= H) continue;
            if(tomato[x][y][nz] == 1 || tomato[x][y][nz] == -1) continue;
            qu.push(make_tuple(x,y,nz,day+1));
            tomato[x][y][nz] = 1;
        }
        DAY = day;
    }
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N >> H;
    for (int k = 0; k < H; k++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                cin >> tomato[i][j][k]; 
            }
        }
    }
    
    for (int k = 0; k < H; k++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if(tomato[i][j][k] == 1){
                    qu.push(make_tuple(i,j,k,0));
                }
            }
        }
    }
    
    bfs();

    for (int k = 0; k < H; k++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if(tomato[i][j][k] == 0){
                    cout << -1;
                    return 0;
                }
            }
        }
    }

    cout << DAY;
    return 0;
}
