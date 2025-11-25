import java.util.*;

public class BookAllocation {
    public static boolean isvalid(int arr[], int n, int m, int mid){
        int student = 1;
        int pages = 0;
        for(int i=0;i<n;i++){
            if(arr[i]> mid) return false;
            if(arr[i]+pages<=mid){
                pages += arr[i];
            }else{
                student++;
                pages = arr[i];
            }
            // if(pages > mid) return false;
        }
        return student>m?false:true;
    }
    public static int bookAllocation(int arr[], int n ,int m){
        int sum = 0;
        // int sumArr[] = new int[sum];
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        int si = 0;
        int ei = sum; 
        int ans = -1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(isvalid(arr,n,m,mid)){
                ans = mid;
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,3,4};
        int n = 4,m = 2;
        // int result = bookAllocation(arr,n,m);
        System.out.println(bookAllocation(arr,n,m));
    }
}
