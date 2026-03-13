#include <stdio.h>

int main()
{

    char str[101];

    scanf("%s", &str);

    int num[26];
    for(int i = 0; i < 26; i++)
    {
        num[i] = -1;
    }

    for(int i = 0; str[i] != '\0'; i++)
    {
        if(num[str[i] - 'a'] == -1)
        {
            num[str[i] - 'a'] = i;
        }
    }
    
    for(int i = 0; i< 26; i++)
    {
        printf("%d ", num[i]);
    }

    return 0;
}
