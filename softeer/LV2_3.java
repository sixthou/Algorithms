package softeer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LV2_3 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=409
     * 입력예제1
     * 7
     * 1110111
     * 0110101
     * 0110101
     * 0000100
     * 0110000
     * 0111110
     * 0110000
     * 출력예제1
     * 3
     * 7
     * 8
     * 9
     */

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Position> queue = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            String[] nums = sc.nextLine().split("");
            for(int j = 0 ; j < n ; j++){
                int now = Integer.parseInt(nums[j]);
                if(now == 1){
                    queue.add(new Position(i,j));
                }
                map[i][j] = now;
            }
        }


        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!visited[now.x][now.y]){
                answer.add(doVisit(map, visited, now));
            }
        }
        System.out.println(answer.size());
        answer.stream()
                .sorted()
                .forEach(i -> System.out.println(i));
    }

    private static int doVisit(int[][] map, boolean[][] visited, Position pos){
        Queue<Position> que = new LinkedList<>();
        que.add(pos);
        visited[pos.x][pos.y] = true;
        int count =1;

        while(!que.isEmpty()){
            Position now = que.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i = 0 ; i < 4; i++){
                int tmpX = nowX + dx[i];
                int tmpY = nowY + dy[i];
                if(tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n){
                    if(!visited[tmpX][tmpY] && map[tmpX][tmpY] ==1){
                        que.add(new Position(tmpX, tmpY));
                        visited[tmpX][tmpY] = true;
                        count++;
                    }
                }
            }


        }

        return count;
    }


    static class Position{
        public int x;
        public int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }


    }
}
