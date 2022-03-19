import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Train4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean flag = true;
        int start_index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='0' && str.charAt(i) <= '9') {
                if (flag) {
                    flag = false;
                    start_index = i;
                }
            } else {
                if (!flag) {
                    flag = true;
                    int num = Integer.parseInt(str.substring(start_index,i));
                    arrayList.add(num);
                }
            }
        }
        if (!flag) {
            int num = Integer.parseInt(str.substring(start_index));
            arrayList.add(num);
        }
        arrayList.sort(Comparator.naturalOrder());
        for (Object obj:arrayList
             ) {
            System.out.println(obj);
        }
    }


}
