import java.util.ArrayList;
import java.util.Comparator;

public class Train4 {
    public static void main(String[] args) {
        Train4 train4 = new Train4();
        String str = "he15I154Io87wor7I87d";
        train4.findNum(str);
    }

    public void findNum(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>=48 && str.charAt(i)<=59) {
                num = num+1;
            } else {
                if(num>0){
                    String sub_str = str.substring(i-num,i);
                    arrayList.add(Integer.parseInt(sub_str));
                    num = 0;
                }
            }
        }
        arrayList.sort(Comparator.naturalOrder()); // 对数组集合的排序
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
