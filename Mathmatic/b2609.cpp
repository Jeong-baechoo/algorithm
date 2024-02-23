#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b)
{
    while (b != 0)
    {
        int mod = a % b;
        a = b;
        b = mod;
    }
    return a;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n1;
    int n2;
    cin >> n1 >> n2;

    cout << gcd(n1, n2) << '\n'
         << n1 * n2 / gcd(n1, n2);

    return 0;
}
