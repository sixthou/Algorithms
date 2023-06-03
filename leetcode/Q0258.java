package leetcode;

public class Q0258 {
    public int addDigits(int num) {

        while(num > 9){
            num = doFun(num);
        }

        return num;
    }

    private int doFun(int num){
        int tempSum = 0;

        while(num > 0) {
            tempSum += num % 10;
            num /= 10;
        }
        return tempSum;
    }
}
