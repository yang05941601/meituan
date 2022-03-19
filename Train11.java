import java.util.ArrayList;
import java.util.Scanner;

public class Train11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str_lib = "abcdefghijklmnopqrstuvwxyz";
        String str = scanner.nextLine();
        ArrayList<String> arrayList = new ArrayList<>();
        // 先对字符串进行排序,将满足顺序的子串放入一个数组中
        int left = 0;
        int right = 0;
        for( int i = 1; i < str.length(); i++) {
            if (str.charAt(i)>str.charAt(i-1)) {
                right = i;
            } else {
                arrayList.add(str.substring(left,right+1));
                left = i;
                right = i;
            }
        }
        arrayList.add(str.substring(left,right+1));
        System.out.println(arrayList);
        int len = str_lib.length()*(arrayList.size()-1);
        for (int i  = 0; i < str_lib.length(); i++) {
            if (str_lib.charAt(i)==arrayList.get(arrayList.size()-1).charAt(arrayList.get(arrayList.size()-1).length()-1)) {
                len += i+1;
            }
        }
        System.out.println(len-str.length());
    }

}
