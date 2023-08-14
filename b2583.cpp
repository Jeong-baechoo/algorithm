#include<bits/stdc++.h>
using namespace std;
bool isChecked[101][101];
vector<int> Arr;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
int M,N,K;

void makeSquare(int x1, int y1, int x2, int y2){

    for (int i = y1; i < y2; i++)
    {
        for (int j = x1; j < x2; j++)
        {
            isChecked[i][j] = true;
        }
        
    }
    
}
void bfs(int x, int y){
    queue<pair<int,int>> qu;
    qu.push(make_pair(x,y));
    int Count = 1;
    while (!qu.empty())
    {
        int curX = qu.front().first;
        int curY = qu.front().second;
        isChecked[x][y] = true;
        qu.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(isChecked[nx][ny]) continue;
            qu.push(make_pair(nx,ny));
            Count++;
            isChecked[nx][ny] = true;
        }
        
    }
    Arr.push_back(Count);
    
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    cin >> K;
    while (K--)
    {
        int x1,y1,x2,y2;
        cin >> x1 >> y1 >> x2 >> y2;
        makeSquare(x1,y1,x2,y2);
    }
   
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if(!isChecked[i][j]) bfs(i,j);
        }
    }
    sort(Arr.begin(), Arr.end());
    cout << Arr.size() << endl;
    for (int i = 0; i < Arr.size(); i++)
    {
        cout << Arr[i] << " ";
    }
    
    return 0;
}
