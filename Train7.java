import java.util.Scanner;

public class Train7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] menu = new int[m];
        int[][] cust = new int[n][2];
        for (int i = 0; i < m; i++) {
            menu[i] = 1;   // 表示有的每道菜
        }
        for (int i = 0; i <n; i++) {
            cust[i][0] = scanner.nextInt();
            cust[i][1] = scanner.nextInt();
        }
        // 采用状态压缩的方法,每种顾客的处理方式作为一个二进制
        // 通过移位来处理
        int[] temp = menu;
        int max_cust = 0;
        for (int mask = 0; mask < (1<<n); mask++) {
            menu = temp;
            int cust_num = 0;
            boolean succ = true;
            for (int i = 0; i < n; i++) {
                if ((mask>>i&1)==1) {
                    if (menu[cust[i][0]]==1 && menu[cust[i][1]]==1) {
                        menu[cust[i][0]] = 0;
                        menu[cust[i][1]] = 0;
                        cust_num++;
                    } else {
                        succ  = false;
                        break;
                    }
                }
            }
            if (succ) {
                max_cust = Math.max(max_cust,cust_num);
            }
        }
        System.out.println(max_cust);
    }
}
