from math import inf 
def getFirstUniqueChar(s: str) -> int:
    freq = dict(
        {
            'a': -1,
            'b': -1,
            'c': -1,
            'd': -1,
            'e': -1,
            'f': -1,
            'g': -1,
            'h': -1,
            'i': -1,
            'j': -1,
            'k': -1,
            'l': -1,
            'm': -1,
            'n': -1,
            'o': -1,
            'p': -1,
            'q': -1,
            'r': -1,
            's': -1,
            't': -1,
            'u': -1,
            'v': -1,
            'w': -1,
            'x': -1,
            'y': -1,
            'z': -1,
        }
    )

    for i, char in enumerate(s):
        if freq[char] >= 0:
            freq[char] = -2
        else:
            freq[char] = i
    
    first = inf
    
    for value in freq.values():
        if value >= 0 and value <= first:
            first = value
    
    return first


first_unique = getFirstUniqueChar('abcdafgb')
print(first_unique)