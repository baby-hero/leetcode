/*
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 */

function findTheWinner(n: number, k: number): number {
    let gamers = new Array(n);
    for (let i = 0; i < n; i++) {
        gamers[i] = i + 1;
    }

    let removed_index = 0;
    while (gamers.length > 1) {
        removed_index = (removed_index + k - 1) % gamers.length;
        gamers.splice(removed_index, 1);
    }
    return gamers[0];
}

console.log(findTheWinner(5, 2));
console.log(findTheWinner(6, 5));
console.log(findTheWinner(10, 4));

