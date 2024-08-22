package graph;

/**
 * n皇后问题！
 */
public class solveNQueens {
    public int solveNQueens(int n) {
        if(n < 1) return 0;
        int[] record = new int[n];
        return scheme(0,record,n);
    }
    //i ==> 目前的行数
    //n ==> 一共多少行
    public int scheme(int i,int[] record,int n){
        //到达最后一行的下一行，证明该摆法可行，返回一种摆法
        if (i == n) return 1;
        int res = 0;
        //遍历这一行的所有列，找到符合的位置
        for (int j = 0; j < n; j++) {
            if(isValue(record,i,j)){
                record[i] = j;
                //将符合的位置
                res += scheme(i+1,record,n);
            }
        }
        return res;
    }

    public boolean isValue(int[] record,int i,int j){
        for (int k = 0; k < i; k++) {
            if(record[k] == j) return false;
            if (Math.abs(record[k]-j) == Math.abs(k-i)) return false;
        }
        return true;
    }
}
