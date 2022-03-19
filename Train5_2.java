import java.util.Scanner;

public class Train5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            boolean flag = isLuck(num);
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    public static boolean isLuck(int num) {
        if (num%11==0) {
            return true;
        } else{
            int count = 0;
            while(num>0) {
                if (num%10==1) count++;
                num = num/10;
            }
            return count>=2;
        }
    }
}
