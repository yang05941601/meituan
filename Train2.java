public class Train2 {
    public static void main(String[] args) {
        int n =3;
        int m = 3;
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        Train2 train2 = new Train2();
        int[][] arr2_re = train2.reverse(n,m,arr2);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr2_re[i][j]);
            }
            System.out.println();
        }
    }
    // 复杂度较高,由于他没有说是方正，因此无法在原矩阵上进行交换
    public int[][] reverse(int n , int m, int[][] arr2) {
        int[][] arr2_re = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                arr2_re[j][i] = arr2[i][j];
            }
        }
        return arr2_re;
    }
}
