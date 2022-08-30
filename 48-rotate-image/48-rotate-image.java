class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] temp_arr = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                temp_arr[i][j] = matrix[N - j -1][i];
        
        System.arraycopy(temp_arr, 0, matrix, 0, matrix.length);
    }
}