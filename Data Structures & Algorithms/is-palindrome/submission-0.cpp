#include <string>

class Solution {
public:
    bool isAlphaNumeric(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }

    bool isPalindrome(string s) {
        int n = s.length();
        int p1 = 0, p2 = n-1;

        while(p1 <= p2){
            if(isAlphaNumeric(s[p1]) && isAlphaNumeric(s[p2])){
                if(tolower(s[p1]) != tolower(s[p2]))
                    return false;
                else{
                    p1++;
                    p2--;
                }
            }
            else if(isAlphaNumeric(s[p1]) && !isAlphaNumeric(s[p2]))
                p2--;
            else if(!isAlphaNumeric(s[p1]) && isAlphaNumeric(s[p2]))
                p1++;
            else if(!isAlphaNumeric(s[p1]) && !isAlphaNumeric(s[p2])){
                p1++;
                p2--;
            }
        }       
        return true;
    }
};
