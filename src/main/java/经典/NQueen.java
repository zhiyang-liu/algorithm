package 经典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题
 * Created by liuzhiyang on 2020/1/28 下午7:41
 */
public class NQueen {
    int n;
    // output
    List<List<String>> output = new ArrayList();
    // queens positions
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (queens[i] == col) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                queens[row] = col;
                // if n queens are already placed
                if (row + 1 == n) addSolution();
                    // if not proceed to place the rest
                else backtrack(row + 1);
                // backtrack
                queens[row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];

        backtrack(0);

        return output;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(8);
        System.out.println(Arrays.toString(nQueen.output.toArray()));
        System.out.println(nQueen.output.size());
    }

}
