import java.util.ArrayList;
import java.util.Scanner;

public class Train9 {
    int res1;
    int res2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 7;//= scanner.nextInt();
        int[] state = {0,1,0,1,1,1,0};//new int[n];
        // 建立树的父节点对应的子节点
        ArrayList<ArrayList<Integer>> father = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            state[i]  = scanner.nextInt();
//        }
        for (int i = 0; i< n; i++) {
            father.add(new ArrayList<>());
        }
        int root=0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x==0) {
                root = i;
            } else {
                father.get(x-1).add(i);
            }
        }
        // dfs方法
        Train9 train9 = new Train9();
        train9.dfs(father,root,state);
        System.out.println(train9.res1);
        System.out.println(train9.res2);

    }

    public void dfs(ArrayList<ArrayList<Integer>> father, int root, int[] state) {
        int cnt1 = 0; // 白色子节点统计
        int cnt2 = 0; // 黑色子节点统计
        ArrayList<Integer> subNode = father.get(root);
        for (int i = 0; i < subNode.size(); i++) {
            if (state[subNode.get(i)]==0) {
                cnt1++;
            } else {
                cnt2++;
            }
            dfs(father,subNode.get(i),state);
        }
        if (state[root]==0 && (subNode.size()==0 || cnt2>0)) res1++;
        if (state[root]==1 && (subNode.size()==0 || cnt1==subNode.size())) res2++;
    }
}
