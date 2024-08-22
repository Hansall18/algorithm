package 笔试代码题.TencentMusic;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
public class numIslands {
    //网格的深度优先遍历
    //给定的网格 grid
    //当前搜索到坐标[x,y]的格子
    public static int dfs(char[][] grid,int x,int y){
        //坐标越界，返回
        if (!isValue(grid,x,y)){
            return 0;
        }
        //不是陆地，返回
        if (grid[x][y] != '1'){
            return 0;
        }
        //遍历过得陆地，将值改为2
        //防止重复遍历
        grid[x][y] = '2';
        //递归将所有连在一起的'1'都改成'2'
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
        //返回一个岛屿
        return 1;
    }
    public static boolean isValue(char[][] grid,int x,int y){
        if (x>=grid.length || x<0) return false;
        if (y>=grid[0].length || y<0) return false;
        return true;
    }
    public int numIslands(char[][] grid){
        int num = 0;
        //遍历网格，找到'1'则进行深度遍历
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1'){
                    num += dfs(grid,x,y);
                }
            }
        }
        return num;
    }
}
