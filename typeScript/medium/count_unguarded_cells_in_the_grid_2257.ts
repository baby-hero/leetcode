/*
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/?envType=daily-question&envId=2024-11-21
 */



function find_near_by_value(cols: number[], start_row: number, value: number): number[] {
    let c = start_row;
    for (; c < cols.length; ++c) {
        if (value < cols[c]) {
            break;
        }
    }
    if (c === 0) {
        return [ cols[c], cols[c], c ];
    }
    if (c === cols.length) {
        return [ cols[cols.length - 1], cols[cols.length - 1], cols.length];
    }
    return [ cols[c - 1], cols[c], c];
}

function prepare_dict(guards: number[][], walls: number[][]) {
    const sort_guards = guards.sort(function (a, b) {
        return a[0] - b[0] || a[1] - b[1];
    });
    const sort_walls = walls.sort(function (a, b) {
        return a[0] - b[0] || a[1] - b[1];
    });
    const row_to_wall_cols = {};
    const col_to_wall_rows = {};

    const row_to_guard_cols = {};
    const col_to_guard_rows = {};
    for (let guard of sort_guards) {
        if (guard[0] in row_to_guard_cols) {
            row_to_guard_cols[guard[0]].push(guard[1]);
        } else {
            row_to_guard_cols[guard[0]] = [guard[1]];
        }
        if (guard[1] in col_to_guard_rows) {
            col_to_guard_rows[guard[1]].push(guard[0]);
        } else {
            col_to_guard_rows[guard[1]] = [guard[0]];
        }
    }
    for (let wall of sort_walls) {
        if (wall[0] in row_to_wall_cols) {
            row_to_wall_cols[wall[0]].push(wall[1]);
        } else {
            row_to_wall_cols[wall[0]] = [wall[1]];
        }
        if (wall[1] in col_to_wall_rows) {
            col_to_wall_rows[wall[1]].push(wall[0]);
        } else {
            col_to_wall_rows[wall[1]] = [wall[0]];
        }
    }
    return { row_to_guard_cols, row_to_wall_cols, col_to_guard_rows, col_to_wall_rows };
}

function countUnguarded(m: number, n: number, guards: number[][], walls: number[][]): number {
    const { row_to_guard_cols, row_to_wall_cols, col_to_guard_rows, col_to_wall_rows } = prepare_dict(guards, walls);

    let count = 0
    const arr = [];
    const start_guard_j = {};
    const start_wall_j = {};
    for (let i =0; i < m; i++) { 
        let start_guard_i = 0;
        let start_wall_i = 0;
        for (let j=0; j < n; j++) {

            // row
            if (i in row_to_guard_cols) {
                if (i in row_to_wall_cols) {
                    const [min_guard_i, max_guard_i, tmp_g_i] = find_near_by_value(row_to_guard_cols[i], start_guard_i, j);
                    start_guard_i = tmp_g_i
                    const [min_wall_i, max_wall_i, tmp_w_i] = find_near_by_value(row_to_wall_cols[i], start_wall_i, j);
                    start_wall_i = tmp_w_i;
                    if (
                        ((min_wall_i <= min_guard_i || min_wall_i > j) && min_guard_i <= j)
                        || (j <= max_guard_i && (max_guard_i <= max_wall_i || max_wall_i < j))
                    ) {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                if (i in row_to_wall_cols) {
                    const [min_wall_i, max_wall_i, tmp] = find_near_by_value(row_to_wall_cols[i], start_wall_i, j);
                    start_wall_i = tmp;
                    if (j == min_wall_i) { 
                        continue;
                    }
                }
            }
         
            // column
            if (j in col_to_guard_rows) {
                if (j in col_to_wall_rows) {
                    const [min_quard_j, max_guard_j, tmp_g_j] = find_near_by_value(col_to_guard_rows[j], (start_guard_j[j] || 0), i);
                    start_guard_j[j] = tmp_g_j;
                    const [min_wall_j, max_wall_j, tmp] = find_near_by_value(col_to_wall_rows[j], start_wall_j[j] || 0, i);
                    start_wall_j[j] = tmp;
                    if (
                        ((min_wall_j <= min_quard_j || min_wall_j > i)&& min_quard_j <= i)
                        || (i <= max_guard_j && (max_guard_j <= max_wall_j || max_wall_j < i))
                        || i == min_wall_j
                    ) {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                if (j in col_to_wall_rows) {
                    const [min_wall_j, max_wall_j, tmp] = find_near_by_value(col_to_wall_rows[j], start_wall_j[j] || 0, i);
                    start_wall_j[j] = tmp;
                    if (i == min_wall_j) { 
                        continue;
                    }
                }
            }
            arr.push([i,j]);
            count++;
        }
    }
    console.log(arr);
    return count
};

console.log(countUnguarded(4,6,[[0,0],[1,1],[2,3]],[[0,1],[2,2],[1,4]])); // output: 7
console.log(countUnguarded(3,3,[[1,1]],[[0,1],[1,0],[2,1],[1,2]])); // output: 4
console.log(countUnguarded(9,6,[[8,2]],[[2,3],[2,4],[6,5],[2,0],[5,3],[7,5],[4,2],[3,0]])); // output: 37

