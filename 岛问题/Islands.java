package 岛问题;

//[0..1][0...1]区域，1为岛屿，计算[][]范围内有多少个岛屿
public class Islands {
    //返回岛屿的数量res
    public int countIslands(int[][] m){
        if (m == null || m[0] == null) return 0;
        int res = 0;
        int M = m[0].length;
        int N = m.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1){
                    //找到一个1，岛屿数量就加1
                    res++;
                    //进行感染，将1变成2
                    inflect(m,i,j,N,M);
                }
            }
        }
        return res;
    }
    //将找到的第一个1及其连接的所有1，都改成2
    public void inflect(int[][] m,int i,int j,int N,int M){
        if (i<0||i>=N||j<0||j>=M||m[i][j]!=1){
            return;
        }
        m[i][j] = 2;
        inflect(m,i-1,j,N,M);
        inflect(m,i+1,j,N,M);
        inflect(m,i,j-1,N,M);
        inflect(m,i,j+1,N,M);
    }
}
