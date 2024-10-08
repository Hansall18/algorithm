package LeetCode随机刷;

import java.util.Scanner;

public class landsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            sc.nextLine();
            int[][] map = new int[endX][endY];
            for (int j = 0; j < endX; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < endY; k++) {
                    map[j][k] = line.charAt(k) - '0';
                }
            }
            int res = 0;
            for (int j = 0; j < endX; j++) {
                for (int k = 0; k < endY; k++) {
                    if (map[j][k] == 1){
                        res++;
                        process(map,j,k,endX,endY);
                    }
                }
            }
            System.out.println(res);
        }
    }
    public static void process(int[][] map,int curX,int curY,int endX,int endY){
        if (curX<0||curX>=endX||curY<0||curY>=endY||map[curX][curY] != 1){
            return;
        }
        map[curX][curY] = -2;
        process(map,curX+1,curY,endX,endY);
        process(map,curX,curY+1,endX,endY);
        process(map,curX-1,curY,endX,endY);
        process(map,curX,curY-1,endX,endY);
    }
}
