#include <stack>
#include <string>
#include <iostream>

using namespace std;

/* Program to see if a string of brackets ex. ”{[()]}” is valid
* Input: first line is an integer noting the number of strings to be
* read. Then each line is a string of brackets to be tested.
* Output is ”YES” if valid, ”NO” if invalid. */


int main(){
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        stack<char> brackets;
        bool isValid = true;
        if(s[0] == '}' || s[0] == ']' || s[0] == ')') isValid = false;
        else {
            for(int j = 0; j < s.size(); j++) {
                if(s[j] == '{' || s[j] == '[' || s[j] == '(') {
                    brackets.push(s[j]);
                }
                else if (s[j] == '}' && !brackets.empty()) {
                    if (brackets.top() != '{') {
                        isValid = false;
                        //break;
                    }
                    else brackets.pop();
                }
                else if (s[j] == ']' && !brackets.empty()) {
                    if (brackets.top() != '[') {
                        isValid = false;
                        //break;
                    }
                    else brackets.pop();
                }
                else if (s[j] == ')' && !brackets.empty()) {
                    if (brackets.top() != '(') {
                        isValid = false;
                        //break;
                    }
                    else brackets.pop();
                }
            }
            
        }
        if (brackets.empty() && isValid) cout << "YES" << endl; 
        else cout << "NO" << endl;
    }
    return 0;
}
