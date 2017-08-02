#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /*There is a collection of Nstrings ( There can be multiple occurences of      
    *a particular string ). Each string's length is no more than20characters.       
    *There are also Qqueries. For each query, you are given a string, and you 
    *need to find out how many times this string occurs in the given 
    *collection of Nstrings.
    *Input Format
    *The first line containsN, the number of strings.     *The next Nlines each contain a string.     *The N+2 line contains Q, the number of queries.     *The following Qlines each contain a query string.

    int N;
    int Q;
    cin >> N;
    vector<string> strings(N);
    for(int i = 0; i < N; i++) {
        cin >> strings[i];
    }
    cin >> Q;
    for(int i = 0; i < Q; i++) {
        string s;
        int count = 0;
        cin >> s;
        for(int j = 0; j < N; j++) {
            if(s == strings[j]) count += 1;
        }
        cout << count << endl;
            
    }
    
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    return 0;
}
