import java.util.Scanner;

public class Train3 {
    int max_sum = 0;
    int max_min = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5; //scanner.nextInt();
        int m = 4; //scanner.nextInt();
        int[] vertex = {3,4,1,4,9};//new int[n];
//        for (int i = 0; i < n; i++) {
//            vertex[i] = scanner.nextInt();
//        }
        int[][] edges = {{0,1,1,0,0},{0,0,0,1,0},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};//new int[n][n];
//        for (int i = 0; i < m; i++) {
//            int v1 = scanner.nextInt();
//            int v2 = scanner.nextInt();
//            edges[v1-1][v2-1] = 1;
//        }
        int[] res = new int[2];
        Train3 train3 = new Train3();
        for (int i = 0; i < n; i++) {
            res[0] = vertex[i];
            res[1] = vertex[i];
            train3.dfs( edges, vertex, i,res,edges[i]);
        }
        System.out.println(train3.max_sum+" "+ train3.max_min);

    }

    public void dfs(int[][] edges, int[] vertex, int index, int[] res, int[] wall) {
        // wall 表示每次将当前行的后续联通索引标记上，表示后续也不能选取这些点
        if (index+1>=vertex.length) {
            if (max_sum<=res[0]) {
                max_sum = res[0];
                max_min = Math.max(max_min,res[1]);
            }
            return;
        }
        int[] temp_wall = wall;
        // 结束条件
        for (int i = index+1; i < vertex.length; i++) {
            if (wall[i]==0) {
                res[0] += vertex[i];
                int temp = res[1];
                res[1] = Math.min(res[1],vertex[i]);
                for (int j = i+1; j < vertex.length; j++) {
                    wall[j] = edges[i][j] + wall[j];
                }
                dfs(edges,vertex,i,res,wall);
                // 回退操作
                res[0] -= vertex[i];
                res[1] = temp;
                wall = temp_wall;
            }
        }
    }
}
