#include<bits/stdc++.h>
using namespace std;

int n,k;
int dist[1100002];
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> k;
  int MX = 100001;
  fill(dist,dist+MX,-1);
  deque<int> dq;
  dq.push_back(n);
  dist[n]=0;
  while(!dq.empty()){
    int cur = dq.front(); dq.pop_front();
    if( 2*cur < MX && dist[2*cur] == -1){
      dist[2*cur] = dist[cur];
      dq.push_front(2*cur);
    }
    for(int nxt : {cur-1,cur+1}){
      if(nxt < 0 or nxt >= MX or dist[nxt] != -1) continue;
      dist[nxt] = dist[cur]+1;
      dq.push_back(nxt);      
    }
  } 
  cout << dist[k];
}

/*
0-1 BFS로 해결한 풀이
*/
// int area[100002];

// int dx[3] {2,-1,1};
// int main(int argc, char const *argv[])
// {
//     ios::sync_with_stdio(0);
//     cin.tie(0);
//     int a,b;
//     cin >> a >> b;
//     if(a == b){
//         cout << 0;
//         return 0;
//     }
//     for (int i = 0; i <= 100000; ++i) {
//         area[i] = INT_MAX;
//     }
//     queue<pair<int,int>> q;
//     q.push({a,0});
//     while (true)
//     {
//         int x = q.front().first;
//         int time = q.front().second;
//         q.pop();
//         if(x == b){
//             cout << area[b];
//             break;
//         }
//         for (int i = 0; i < 3; i++)
//         {
//             int nx;
//             if( i == 0){
//                 nx = 2 * x;
//             } else{
//                 nx = x + dx[i];
//             }

//             if(nx < 0 || nx > 100001) continue;
//             if(i == 0){
//                 if(area[nx] <= time) continue;//더 작은 값만 갱신가능
//                 area[nx] = time;
//                 q.push({nx,time});
//             } else{
//                 if(area[nx] <= time + 1) continue;
//                 area[nx] = time + 1;
//                 q.push({nx, time + 1});
//             }
//         }
        
//     }
    

//     return 0;
// }

