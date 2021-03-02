package com.mall.user.common;

import java.util.*;

/**
 * @author: gaolingfeng
 * @date: 2021/2/27 14:17
 * @description:
 */


/**
 * a 97   b 98  c 99
 * n = 5
 * 97 97 97 97 97
 * 97 98 98 98 97
 * 97 98 99 98 97
 * 97 98 98 98 97
 * 97 97 97 97 97
 */

public class Test2 {
    public static void main(String[] args) {
        print(5);
    }

    private static void print(int n) {
        int start = 96;
        Map<Integer, List<Integer>> map = new HashMap(n);
        int seq = 1;

        // 第n行 先输出上半一部分
        List<Integer> list = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                list.add(i+start);
                map.put(i,list);
            }
        }
        // 下半部分

        for(Integer key: map.keySet()){
            System.out.println(map.get(key));
        }
        char[][] matrix=new char[n][n];
        boolean[][] vis=new boolean[n][n];
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int dir=0,x=0,y=0;
        int cur=97;
        for(int i=0;i<n*n;i++)
        {
            matrix[x][y]= (char) cur;
            vis[x][y]=true;
            int tx=x+dx[dir];
            int ty=y+dy[dir];
            if(tx<0||tx>=n||ty<0||ty>=n||vis[tx][ty])
            {
                dir++;
                if(dir==4) cur++;
                dir=dir%4;
                tx=x+dx[dir];
                ty=y+dy[dir];
            }
            x=tx;y=ty;
        }

    }


}


