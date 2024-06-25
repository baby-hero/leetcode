function isHappy(n: number): boolean {
    let nums_set = new Set<number>();
    nums_set.add(n);
    while (n > 1) {
        let sum = 0;
        while (n > 0) {
            sum += (n % 10) ** 2;
            n = Math.floor(n / 10);
        }
        n = sum;
        if (nums_set.has(n)) {
            return false;
        }
        nums_set.add(n);
    }
    return true;
};

console.log(isHappy(19) === true);
console.log(isHappy(2) === false);