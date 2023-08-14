#include<bits/stdc++.h>
using namespace std;

int Map[301][301];
int temp[301][301];
int n,m;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

int check(){

    bool isVisited[301][301] = {false};
    queue<pair<int,int>> q;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if(Map[i][j] > 0 && !isVisited[i][j]){
                isVisited[i][j] = true;
                q.push({i,j});

                while (!q.empty())
                {
                    int x,y;
                    x = q.front().first;
                    y = q.front().second;
                    q.pop();

                    for (int i = 0; i < 4; i++)
                    {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if(nx < 0 || ny <0 || nx >= n || ny >= m) continue; 
                        if(Map[nx][ny] > 0 && !isVisited[nx][ny]){
                            isVisited[nx][ny] = true;
                            q.push({nx,ny});
                        }
                    }
                    
                }
                
                count ++;
            }
        }
        
    }
    return count;
}

void count(){
    memset(temp, 0 , sizeof(temp));
    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < m; j++)
        {
            if(Map[i][j] > 0){ //빈공간 check
                for (int dir = 0; dir < 4; dir++)
                {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(nx < 0 || ny <0 || nx >= n || ny >= m) continue;
                    if(Map[nx][ny] == 0 && temp[i][j] < Map[i][j]) temp[i][j] ++;
                }
            }
        }    
    }
}

void melt(){
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            Map[i][j] -= temp[i][j];
        }
    }
}
int main(void)
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    int year = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> Map[i][j];
        }
    }
    while(true)
    {  
        int status = check();
        if(status == 0){
            cout << 0;
            return 0;
        } else if(status > 1){
            break;
        }
        year++;
        count(); //0의 개수 세기
        melt();
    }    
    cout << year;
    return 0;
}
