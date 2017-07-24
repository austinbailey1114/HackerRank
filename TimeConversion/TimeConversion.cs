#include <bits/stdc++.h>
#include <sstream>

// Input format: HH:MM:SS:AM or HH:MM:SS:PM

using namespace std;

string timeConversion(string s) {
    std::string hour = s.substr(0,2);
    std::string minute = s.substr(3, 2);
    std::string second = s.substr(6, 2);
    std::string half = s.substr(8, 2);
    if ((half == "AM" && hour != "12") || (hour == "12" && half == "PM")) {
        return hour + ":" + minute + ":" + second;
    }
    else if (half == "AM" && hour == "12") return "00:" + minute + ":" + second;
    else {
        int hour_int = atoi(hour.c_str());
        hour_int +=12;
        std::string hour = std::to_string(hour_int);
        return hour + ":" + minute + ":" + second;
    }
}

int main() {
    string s;
    cin >> s;
    string result = timeConversion(s);
    cout << result << endl;
    return 0;
}
