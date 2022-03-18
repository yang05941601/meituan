import java.util.*;

public class train1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < n-K+1; i++) {
            int res = zhongshu(arr, i, K);
            System.out.println(res);
        }
    }

    public static int zhongshu(int[] arr, int start, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = start; i < start+K; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        // 转换成arrlist，然后排序
        ArrayList<Map.Entry<Integer,Integer>> arrayList = new ArrayList<>(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue()> o2.getValue()) {
                    return 1;
                } else if (o1.getValue()<o2.getValue()) {
                    return -1;
                } else {
                    return o2.getKey()-o1.getKey();
                }
            }
        });
        // 众数
        return arrayList.get(arrayList.size()-1).getKey();

    }
}
