package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(int i = 0; i < N ; i++){
            String[] tmp = sc.nextLine().split(" ");
            meetings.add(new Meeting(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(final Meeting o1, final Meeting o2) {
                if(o1.end == o2.end){
                    return o1.start;
                }
                else return o1.end;
            }
        });

    }

    public static class Meeting{
        int start;
        int end;

        public Meeting(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(final int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(final int end) {
            this.end = end;
        }


    }
}
