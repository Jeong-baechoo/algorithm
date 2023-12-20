#include<bits/stdc++.h>
using namespace std;

int in[100002];
int post[100002];
int Index[100002];

void preorder(int in_s, int in_e, int po_s, int po_e){
    if(in_s > in_e || po_s > po_e) return;
    int root = post[po_e];
    int idx = Index[root];
    int length = idx - in_s;
    cout << root << " ";
    preorder(in_s, idx-1,po_s,po_s+length-1);
    preorder(idx+1, in_e,po_s+length,po_e-1);
}

int main(void)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> in[i];
    }

    for (int i = 0; i < n; i++)
    {
        cin >> post[i];
    }
    
    for (int i = 0; i < n; i++)
    {
        Index[in[i]] = i;
    }
    
    preorder(0,n-1,0,n-1);
    
    return 0;
}
