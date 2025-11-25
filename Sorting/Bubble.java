package Sorting;

public class Bubble {
    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t; 
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {5,3,8,4,2};
        int[] sorted = bubbleSort(nums);
        for(int i=0;i<sorted.length;i++){
            System.out.print(sorted[i] + " ");
        }

    }
}
