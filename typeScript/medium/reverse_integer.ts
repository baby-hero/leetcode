/*
 * https://leetcode.com/problems/reverse-integer/
 */
function reverse(x: number): number {
    let sign_x = 1;
    if (x < 0) {
        x = -x;
        sign_x = -1;
    }

    let rx = 0
    while (x > 0) {
        rx = rx * 10 + x % 10;
        x = Math.floor(x / 10);
    }
    rx = rx * sign_x;
    if (rx < -(2 ** 31) || rx > (2 ** 31 - 1)) {
        return 0;
    }
    return rx;   
};
console.log(reverse(123))
console.log(reverse(-123))
console.log(reverse(120))

