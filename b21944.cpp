#include <bits/stdc++.h>
using namespace std;

// 문제 추천에 따라서 자료구조를 다르게 만든다.
string op;
int N, L, P, G, x;
// pair<int,int> levelNal; //level & algorithm
pair<int, int> probLevel[100'002]; // 이 문제가 어느 난이도였는지 저장
set<int> probByGL[102][102];       // 기준이 분류, 난이도
set<int> probByL[102];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    while (N--)
    {
        cin >> P >> L >> G;
        probLevel[P] = {L, G};
        probByL[L].insert(P);
        probByGL[G][L].insert(P);
    }

    cin >> N;
    while (N--)
    {
        cin >> op;
        if (op == "recommend")
        {
            cin >> G >> x;
            if (x == 1)
            {
                for (int i = 100; i >= 0; i--)
                {
                    if (probByGL[G][i].empty())
                        continue;
                    cout << *(prev(probByGL[G][i].end())) << '\n';
                    break;
                }
            }
            else
            {
                for (int i = 0; i < 101; i++)
                {
                    if (probByGL[G][i].empty())
                        continue;
                    cout << *probByGL[G][i].begin() << '\n';
                    break;
                }
            }
        }
        else if (op == "recommend2")
        {
            cin >> x;
            if (x == 1)
            {
                for (int i = 100; i >= 0; i--)
                {
                    if (probByL[i].empty())
                        continue;
                    cout << *(prev(probByL[i].end())) << '\n';
                    break;
                }
            }
            else
            {
                for (int i = 0; i < 101; i++)
                {
                    if (probByL[i].empty())
                        continue;
                    cout << *(prev(probByL[i].begin())) << '\n';
                    break;
                }
            }
        }
        else if (op == "recommend3")
        {
            cin >> x >> L;
            int ans = -1;
            if (x == 1)
            {
                for (int i = L; i < 101; i++)
                {
                    if (probByL[i].empty())
                        continue;
                    ans = *probByL[i].begin();
                    break;
                }
            }
            else
            {
                for (int i = L - 1; i >= 0; i--)
                {
                    if (probByL[i].empty())
                        continue;
                    ans = *(prev(probByL[i].end()));
                    break;
                }
            }
            cout << ans << '\n';
        }
        else if (op == "add")
        {
            cin >> P >> L >> G;
            probLevel[P] = {L, G};
            probByL[L].insert(P);
            probByGL[G][L].insert(P);
        }
        else if (op == "solved")
        {
            cin >> P;
            tie(L, G) = probLevel[P];
            probByL[L].erase(P);
            probByGL[G][L].erase(P);
        }
    }

    return 0;
}
