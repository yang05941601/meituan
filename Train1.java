import java.util.*;

public class Train1 {
    public static void main(String[] args) {
        Train1 train1 = new Train1();
        int[] arr = {1,2,2,1,3};
        int[] arr_zhongshu = train1.zhongshu(5,3,arr);
        for(int i = 0; i < arr_zhongshu.length;i++){
            System.out.println(arr_zhongshu[i]);
        }
        System.out.println("This is a Hot-Fix branch");
    }

    public int[] zhongshu(int n, int K, int[] num) {
        // treemap集合会自动按照由小到大顺序排列
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int[] arr = new int[n-K+1];
        for (int i = 0; i < n-K+1; i++) {
            if (i==0){
                for (int j = 0; j < K; j++) {
                    if (!map.containsKey(num[i+j])) {
                        map.put(num[i+j],1);
                    } else {
                        map.put(num[i+j],map.get(num[i+j])+1);
                    }
                }
            } else{
                if (!map.containsKey(num[i+K-1])) {
                    map.put(num[i+K-1],1);
                } else {
                    map.put(num[i+K-1],map.get(num[i+K-1])+1);
                }
            }

            // 排序选择众数,或者利用Collections的max函数
            int maxValue = Collections.max(map.values());
/*            Collection<Integer> values = map.values();
            Iterator it = values.iterator();
            int max = 0;
            while (it.hasNext()) {
                Integer temp = (Integer) it.next();
                if (max<temp) {
                    max = temp;
                }
            }*/
            // 选择对应的key
            Set<Map.Entry<Integer,Integer>> entry = map.entrySet();
            Iterator<Map.Entry<Integer,Integer>> it2 = entry.iterator();
            while(it2.hasNext()){
                Map.Entry<Integer,Integer> node = it2.next();
                if (node.getValue()==maxValue) {
                    arr[i] = node.getKey();
                    break;
                }
            }
            // 删除前一个节点
            map.put(num[i], map.get(num[i])-1);
        }
        return arr;
    }
}
