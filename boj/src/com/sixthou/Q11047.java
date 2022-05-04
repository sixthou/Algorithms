package com.sixthou;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }

        list.sort(Comparator.reverseOrder());

        for (Integer integer : list) {
            ans += K / integer;
            K %= integer;
            if (K <= 0) {
                break;
            }
        }

        System.out.println(ans);

    }

}
