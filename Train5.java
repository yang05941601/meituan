public class Train5 {
    public static void main(String[] args) {
        int[] num = {3,4,11,22};
    }

    public boolean judgeNum(int[] num) {
        // 假设数位指的是10进制的话
        boolean flag_1 = true;
        boolean flag_2 = true;
        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            if (n%11!=0){
                flag_1 = false;
            }
            // 统计1的个数
            int count = 0;
            while(n!=0) {
                if(n%10==1){
                    count++;
                }
                n = n / 10;
            }
            if (count<=2) {
                flag_2 = false;
            }
            if (flag_1 || flag_2) {
                return false;
            }
        }
        return true;
    }
}
