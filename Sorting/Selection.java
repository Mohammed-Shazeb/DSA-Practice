package Sorting;

public class Selection {
    public static int[] selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int minIdx = i;
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }
            // Swap nums[i] and nums[minIdx]
            int t = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = t;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {5,3,8,4,2};
        int[] sorted = selectionSort(nums);
        for(int i=0;i<sorted.length;i++){
            System.out.print(sorted[i] + " ");
        }
    }
}
