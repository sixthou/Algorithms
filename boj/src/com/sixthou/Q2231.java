package com.sixthou;


import java.util.Scanner;
public class Q2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for(int i = 0; i <= n ; i++){
            int now = i;
            int tmp = now;
            while(now != 0){
                tmp += now%10;
                now = now/10;
            }

            if(tmp == n){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}