#include<bits/stdc++.h>
    using namespace std;
    #define el endl
    #define LL long long
    #define ULL unsigned long long
    #define vi vector<int>
    #define vd vector<double>
    #define mp make_pair
    #define pb push_back
    #define pf push_front
    #define pii pair<int,int>
    #define pll pair<LL,LL>
    #define x first
    #define y second
    #define pi acos(-1)
    #define sqr(x) ((x)*(x))
    #define pdd pair<double,double>
    #define MEMS(x) memset(x,-1,sizeof(x))
    #define MEM(x) memset(x,0,sizeof(x))
     
    int main() {
      int t;
      cin >> t;
      for(int i = 0; i < t; i++) {
        int n;
        string st;
        cin >> n;
        cin >> st;
        //Find the
        map<char, int> last;
        map<char, int> friends;
        //First pass for num of friends
        LL waitdiff = 0;
        for(int j = st.size()-1; j >= 0; j--) {
          if(last.count(st[j]) < 1) {
            last[st[j]] = j;
          }
          else {
            waitdiff += last[st[j]] - j;
          }
          friends[st[j]] += 1;
        }
        waitdiff *= 5;
        LL optimalDiff = 0;
        for(auto it = friends.begin(); it!=friends.end(); ++it) {        
          optimalDiff += (LL)(5*((LL) it->second-1)*(LL)it->second)/2;
        }
        cout << waitdiff - optimalDiff << el;
      }
      return 0; 
    }