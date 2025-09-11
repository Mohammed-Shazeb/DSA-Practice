package Greedy_Algo;
import java.util.*;

public class ActivitySelection {
    // This is a greedy algorithm to select the maximum number of activities that can be performed by a single person, assuming that a person can only work on one activity at a time.
// ----------------------------------------------------------------
    // this is when ,when the end is not sorted

    // public static void main(String[] args) {
    //     int[] start = {1, 3, 0, 5, 8, 5};
    //     int[] end =   {2, 4, 6, 7, 9, 9};

    //     ArrayList<Integer> list = new ArrayList<>();
    //     int counter = 0;

    //     counter = 1;
    //     list.add(0);
    //     int lastEnd = end[0];

    //     for(int i=1;i<end.length;i++){
    //         if(start[i] >= lastEnd){
    //             counter++;
    //             list.add(i);
    //             lastEnd = end[i];
    //         }
    //     }
    //     System.out.println("Maximum activities are "+counter);
    //     for(int i=0;i<list.size();i++){
    //         System.out.print("A"+list.get(i)+" ");
    //     }
    //     System.out.println();
    // }

// ----------------------------------------------------------------
// // this is when ,when the end is already sorted
    
    // public static void main(String[] args) {
    //     int[] start = {1, 3, 0, 5, 8, 5};
    //     int[] end =   {2, 4, 6, 7, 9, 9};

    //     ArrayList<Integer> list = new ArrayList<>();
    //     int counter = 0;
    //     int activities[][] = new int[start.length][3];
    //     for(int i=0;i<start.length;i++){
    //         activities[i][0] = i;
    //         activities[i][1] = start[i];
    //         activities[i][2] = end[i];
    //     }
    //     Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));
               
    //     counter = 1;
    //     list.add(activities[0][0]);
    //     int lastEnd = activities[0][2];

    //     for(int i=1;i<end.length;i++){
    //         if(activities[i][1] >= lastEnd){
    //             counter++;
    //             list.add(activities[i][0]);
    //             lastEnd = activities[i][2];
    //         }
    //     }
    //     System.out.println("Maximum activities are "+counter);
    //     for(int i=0;i<list.size();i++){
    //         System.out.print("A"+list.get(i)+" ");
    //     }
    //     System.out.println();
    // }
    
    public static void main(String[] args) {
        int pairs[][] ={{1,2},{2,3},{3,4}};
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        // Arrays.sort(pairs, (a,b) -> Integer.compare(a[1],b[1]));

        int counter = 1; 
        int lastEnd = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] >= lastEnd){
                lastEnd = pairs[i][1];
                counter++;
            }
        }
        System.out.println("Maximum activities are "+counter);
    }
}
