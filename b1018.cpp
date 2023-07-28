#include<bits/stdc++.h>
using namespace std;

char board[51][51];
int N,M;
int Min = INFINITY;
int check(int r, int c, char color){
    int Count = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if(board[r+i][c+j] != color){
                Count++;
            }
            if(color == 'B') {
                if(j == 7) continue;
                color = 'W';
            } else {
                if(j == 7) continue;;
                color = 'B';
            }
        }
    }
    return Count;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];
        }
        
    }
    for (int i = 0; i < N-7; i++)
    {
        for (int j = 0; j < M-7; j++)
        {
            for (int C = 0; C < 2; C++)
            {  
                if(C == 0){
                    Min = min(check(i,j,'W'), Min);
                } else{
                    Min = min(check(i,j,'B'), Min);
                }
            }
        }
        
    }
    
    cout << Min;

    return 0;
}
