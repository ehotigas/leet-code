#include <string.h>
#include <stdio.h>

int isPalindrome(char *string) {
    int length = strlen(string);
    int middle = length / 2;
    for (int idx = 0; idx < middle; idx++) {
        printf("%c != %c\n", string[idx], string[length - idx -1]);
        if (string[idx] != string[length - idx -1]) return 0;
    }
    return 1;
}

char* longestPalindrome(char* s) {
    for (int startIdx = 0; startIdx < (s); startIdx++) {
        for (int endIdx = 0; endIdx < (s); endIdx++) {
            
        }
    }
}

int main(void) {
    // char string[] = "teste string";
    // printf("%s\n", string);

    char *string = "ab";
    printf("Is palindrome: %d\n", isPalindrome(string));
    return 0;
}