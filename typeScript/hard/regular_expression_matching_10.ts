/*
 * https://leetcode.com/problems/regular-expression-matching/
 */

function findPattern(s: string, p: string, i: number, j: number, s_size: number, p_size: number): boolean {
    if (j == p_size) return i == s_size;
    const match = i < s_size && (s[i] == p[j] || p[j] == '.');
    if (j + 1 < p_size && p[j + 1] == '*') {
        return findPattern(s, p, i, j + 2, s_size, p_size) || (match && findPattern(s, p, i + 1, j, s_size, p_size));
    }
    return match && findPattern(s, p, i + 1, j + 1, s_size, p_size);
}

function isMatch(s: string, p: string): boolean {
    const s_size = s.length, p_size = p.length;
    return findPattern(s, p, 0, 0, s_size, p_size);
}

console.log(isMatch("aa", "a") == false);
console.log(isMatch("aa", "a*") === true);
console.log(isMatch("ab", ".*") === true);
console.log(isMatch("aab", "c*a*b*") === true);
console.log(isMatch("mississippi", "mis*is*p*.") === false);
console.log(isMatch("aaca", "ab*a*c*a") === true);
console.log(isMatch("a", "ab*") === true);
console.log(isMatch("bbbba", ".*a*a") === true);
console.log(isMatch("a", ".*..a*") === false);
console.log(isMatch("bbab", "b*a*") === false);
console.log(isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*") === true);
