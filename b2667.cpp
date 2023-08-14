#include<bits/stdc++.h>
using namespace std;

int Map[26][26];
bool isVisited[26][26];
vector<int> Arr;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
int N;

void bfs(int x, int y){
    queue<pair<int,int>> qu;
    qu.push(make_pair(x,y));
    isVisited[x][y] = true;
    int Count = 1;
    while (!qu.empty())
    {
        int curX = qu.front().first;
        int curY = qu.front().second;
        qu.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(isVisited[nx][ny] || Map[nx][ny] == 0) continue;

            isVisited[nx][ny] = true;
            qu.push(make_pair(nx,ny));
            Count ++;
        }
        
    }
    Arr.push_back(Count);
    
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        string str;
        cin >> str;
        for (int j = 0; j < str.length(); j++)
        {
            Map[i][j] = str[j] - '0';
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if(Map[i][j] == 1 && !isVisited[i][j]) bfs(i,j);
        }
        
    }
    
    sort(Arr.begin(), Arr.end());
    cout << Arr.size() << endl;
    
    for (int i = 0; i < Arr.size(); i++)
    {
        cout << Arr[i] << endl;
    }
    
    return 0;
}
