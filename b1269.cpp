#include<bits/stdc++.h>
using namespace std;

map<int,int> a;
map<int,int> b;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n,m;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        int value;
        cin >> value;
        a.insert({value, 1});
    }
    for (int i = 0; i < m; i++)
    {
        int value;
        cin >> value;
        b.insert({value, 1});
    }
    
    vector<int> del;
    for(const auto& iter: a){
        if(b.find(iter.first) != b.end()){
            del.push_back(iter.first);
        }
    }

    for (int i = 0; i < del.size(); i++)
    {
        a.erase(del[i]);
        b.erase(del[i]);
    }
    
    cout<< a.size() + b.size();

    return 0;
}
