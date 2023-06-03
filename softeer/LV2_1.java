package softeer;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LV2_1 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=395
     * 입력예제1
     * 100 2
     * 90 1
     * 70 2
     * 출력예제1
     * 170
     */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int bagWeight = Integer.parseInt(sc.nextLine().split(" ")[0]);
        PriorityQueue<Element> que = new PriorityQueue<>();

        while(sc.hasNext()){
            String[] token = sc.nextLine().split(" ");
            que.offer(new Element(Integer.parseInt(token[0]), Integer.parseInt(token[1])));
        }

        int priceSum = 0;
        while(bagWeight > 0){
            Element nowElement = que.poll();

            if(nowElement.getweight() > bagWeight){
                priceSum += nowElement.calPrice(bagWeight);
                bagWeight -= bagWeight;
                continue;
            }else{
                priceSum += nowElement.calPrice(nowElement.getweight());
                bagWeight -= nowElement.getweight();
            }
        }
        System.out.println(priceSum);

    }

    static class Element implements Comparable<Element> {
        private final int weight;
        private final int price;

        Element(int weight, int price){
            this.weight = weight;
            this.price = price;

        }
        public int calPrice(int weight){
            return weight * price;
        }

        public int getweight(){
            return weight;
        }


        public int compareTo(Element o){
            return o.price - this.price;
        }
    }

}
