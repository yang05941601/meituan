import java.util.Scanner;

public class Train6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        // 穷举
        // 单独一个1，也算一种情况，不考虑序列的重复
        int count = 0;
        for(int i = 0; i < n; i++) {
            int x = 1;
            for (int j = i; j < n; j++) {
                x = x * num[i];
                if (x>0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
