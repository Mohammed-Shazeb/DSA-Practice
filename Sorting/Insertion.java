package Sorting;

public class Insertion {
    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {5,3,8,4,2};
        int[] sorted = insertionSort(nums);
        for(int i=0;i<sorted.length;i++){
            System.out.print(sorted[i] + " ");
        }
    }
}
