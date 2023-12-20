#include<bits/stdc++.h>
using namespace std;
string op;
int N, M, L, P, x;
int probLevel[100'002];     // 이 문제가 어느 난이도였는지 저장
multiset<pair<int,int>> problems;  // 난이도별로 문제 저장

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    while (N--) {
        cin >> P >> L;
        probLevel[P] = L;
        problems.insert({L,P});
    }
    
    cin >> M;
    while (M--) {
    cin >> op;
    if (op == "recommend") {
      cin >> x;
      if (x == 1) {
        cout << prev(problems.end())->second << '\n';
      } else {
        cout << problems.begin()->second << '\n';
      }
    } else if (op == "add") {
      cin >> P >> L;
      probLevel[P] = L;
      problems.insert({L,P});
    } else if (op == "solved") {
      cin >> P;
      problems.erase({probLevel[P],P});
    }
  }

    return 0;
}
