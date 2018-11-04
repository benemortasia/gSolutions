#!/usr/bin/env python2
 
# Context: each character in a string represents a different
# color m&m on a cake. How can we cut any given cake such that
# every piece appears identical and that there are no
# leftover pieces?
 
# Takes some string s that looks like "abccbaabccba"
# and tries to cut it evenly with zero remaining pieces.
# Returns the number of pieces that may be cut evenly.
# A string like "abcdefg" will return 1, as we can
# only split the combination "abcdefg" among one person.
# A string like "abcabcabcabc" will return 4, as we can
# split "abc" among 4 people.
def Answer(s):
    s = s.strip()
 
    # edge cases
    if not s or not s.isalpha():
        return 0
 
    str1 = ''
 
    # str1 will build like this:
    # 'a', 'ab', 'abc', 'abcc', 'abccb', etc
    for c in s:
        str1 += c
        if s.replace(str1, '') == '':
            return len(s) / len(str1)
 
 
# testing
print Answer('abccbaabccba')
print Answer('aaaaaaaaaaaa')
print Answer('              ')
print Answer('    abcabcabcabcabc     ')
print Answer('abbaabbaabbaabba')
print Answer('3462')
print Answer('aaabbaaabbaaabb')
print Answer('abcdefedcbaabcdedefdefbbabcabcabcedcba')
