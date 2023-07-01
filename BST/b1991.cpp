#include <bits/stdc++.h>
using namespace std;

pair<char,char> arr[26];
int N;

void pre(char a){
    if(a == '.') return;
    cout << a;
    pre(arr[a - 'A'].first);
    pre(arr[a - 'A'].second);
}

void inorder(char a){
    if(a == '.') return;
    inorder(arr[a - 'A'].first);
    cout << a;
    inorder(arr[a - 'A'].second);
}
void post(char a){
    if(a == '.') return;
    post(arr[a - 'A'].first);
    post(arr[a - 'A'].second);
    cout << a;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        char parent,left,right;
        cin >> parent >> left >> right; // 요소 입력
        arr[parent - 'A'].first = left;
        arr[parent - 'A'].second = right;
    }
    pre('A');
    cout << '\n';  
    inorder('A');
    cout << '\n';
    post('A');
    return 0;
}
