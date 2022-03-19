import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Train8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] boom = new int[m];
        for (int i = 0; i<m;i++) {
            boom[i] = scanner.nextInt();
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],m);
        }

        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boom[i]==j){
                    dp[i][j] = m;
                } else {
                    // 两种情况，一种一直呆在原房间，此时继承上一步的魔法消耗
                    // 另一种，从其他房间转移过来，（转移的原因则是因为下一步将是炸弹所在的房间）
                    // 需要在其他房间能耗的最小值的基础上+1
                    dp[i][j] = Math.min(dp[i][j],Math.min(dp[i-1][j],dp[i-1][boom[i]]+1));
                }
            }
        }
        for (int[] tem:dp
             ) {
            System.out.println(Arrays.toString(tem));
        }
        int res = dp[m-1][0];
        for (int i =1; i < n; i++) {
            res = Math.min(res,dp[m-1][i]);
        }
        System.out.println(res);

    }
}
