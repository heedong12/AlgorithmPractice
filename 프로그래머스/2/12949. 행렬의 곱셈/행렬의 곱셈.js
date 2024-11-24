function solution(arr1, arr2) {
    return arr1.map((row) =>
        arr2[0].map((_, i) => 
            row.reduce((sum, cell, j) => sum + cell * arr2[j][i], 0)
        )
    );
}
