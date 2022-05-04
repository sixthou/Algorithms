package leetcode;

public class Q0042_Trapping_Rain_Water {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {4,2,0,3,2,5};

//        solution.trap(height);
        System.out.println(solution.trap(height));


    }

    static class Solution {
        public int trap(int[] height) {
            int result = 0;
            int max = 0;
            int originalSum  = 0;
            int tmpSum = 0;
            int[] fromLeft = height.clone();
            int[] fromRight = height.clone();

            for(int i = 0; i<height.length; i++){
                originalSum += height[i];
                if(height[i] > max) max = height[i];
            }


            //왼쪽에서 부터
            for(int i = 0; i < max ; i++){
                for(int j = 0 ; j<height.length; j++){
                    if(j != 0 && (fromLeft[j-1] > fromLeft[j])){
                        fromLeft[j]++;
                    }
                }
            }
            //오른쪽 부터
            for(int i = 0 ; i < max ; i++){
                for(int j = height.length; j>0 ; j--){
                    if(j< height.length && fromRight[j] > fromRight[j-1]){
                        fromRight[j-1]++;
                    }
                }
                print(fromRight);
            }

            //정리
            for(int i = 0; i< height.length ; i++){
                if(fromLeft[i] >= fromRight[i]){
                    tmpSum = tmpSum + fromRight[i];
                }else if(fromLeft[i] < fromRight[i]){
                    tmpSum = tmpSum + fromLeft[i];
                }
            }

            result = tmpSum -  originalSum ;
            return result;
        }
    }

    public static void print(int[] arr){
        for(int i = 0; i <arr.length ; i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
