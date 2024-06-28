/*
 * https://leetcode.com/problems/regular-expression-matching/
 */
function findPattern(s: string, p: string,
    i: number, j: number,
    s_size: number,
    p_size: number,
): boolean {
    console.log("== i: " + i + " j: " + j + " ==");
    console.log("s: " + s.substring(i, s.length));
    console.log("p: " + p.substring(j, p.length));
    while (i < s_size && j < p_size) {
        if (s[i] === p[j] || p[j] === ".") {
            i++;
            j++;
        }
        else if (p[j] === "*") {
            const pre_j = p[j - 1];
            if (pre_j === "." || pre_j === s[i-1]) {
                if (findPattern(s, p, i - 1, j + 1, s_size, p_size)) {
                    return true;
                }
            }

            if (findPattern(s, p, i, j + 1, s_size, p_size)) {
                return true;
            }

            let t = i
            console.log("  ====== i: " + i + " j: " + j + " ====== t:" + t);

            while (t < s_size) {
                if (pre_j === s[t] || pre_j === ".") {
                    if (findPattern(s, p, t + 1, j + 1, s_size, p_size)) {
                        return true;
                    }
                } else {
                    break
                }
                t++;
            }
            i = t;
            break;
        }
        else if (j + 1 < p_size && p[j + 1] === "*"){
            return findPattern(s,p, i, j + 2, s_size, p_size);
        }
        else {
            break;
        }
    }
    if (j < p_size && p[j] === "*") {
        const pre_j = p[j - 1];
        if (pre_j === "." || pre_j === s[i-1]) {
            if (findPattern(s, p, i - 1, j + 1, s_size, p_size)) {
                return true;
            }
        }
        if (findPattern(s, p, i, j + 1, s_size, p_size)) {
                return true;
        }
    }
    if (j + 1 < p_size && p[j + 1] === "*") {
        if (findPattern(s, p, i, j + 2, s_size, p_size)) {
            return true;
        }
    }
    return i === s_size && j === p_size;
}
function isMatch(s: string, p: string): boolean {
    const s_size = s.length, p_size = p.length;
    let i = 0, j = 0;
    console.log("================================");
    console.log("================================");
    console.log("================================");

    return findPattern(s, p, i, j, s_size, p_size);
};

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
