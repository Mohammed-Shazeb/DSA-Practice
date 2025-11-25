// Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline. 
// It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. 
// Maximize the total profit if only one job can be scheduled at a time.
// input: jobs = [[4,20],[1,10],[1,40],[1,30]]  [[deadline, profit]]
// output: 60

package Greedy_Algo;

import java.util.*;

public class JobApplication {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }

    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);  // sort in decreasing order of profit

        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (time < curr.deadline) {
                ans.add(curr.id); // Select the job
                time++; // One job takes one unit of time
            }
        }

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

    }
}
