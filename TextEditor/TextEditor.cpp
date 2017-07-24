#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

/* This is a text editor. It can append to a string (1), delete the last k
* characters (2), print this nth character of a string (3), and undo the last 
* modification to the string (4)
* Input: the first line contains the number of operations. The following
* lines contain an integer between 1 and 4 corresponding to the operations
* above, and in the case (1), a string, in the case of (2) and (3) an 
* integer, and in the case of (4), nothing. */

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int n;
    cin >> n;
    string s = "";
    stack<string> iterations;
    for(int i = 0; i < n; i++) {
        int operation;
        cin >> operation;
        if(operation == 1) {
            string w;
            cin >> w;
            s += w;
            string newString = s;
            iterations.push(newString);
        }
        else if(operation == 2) {
            int k;
            cin >> k;
            string newString = s.substr(0, s.size()-k);
            s = newString;
            iterations.push(newString);
           
        }
        else if (operation == 3) {
            int k;
            cin >> k;
            cout << s[k-1] << endl;
        }
        else {
            if(!iterations.empty()) {
                iterations.pop();
                if (iterations.empty()) {
                    s = "";
                }
                else {
                    s = iterations.top();
                    }
            }
        }
        
    }
    return 0;
}
