//https://www.hackerrank.com/contests/smart-interviews/challenges/si-number-of-valid-subarrays

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t -- > 0)
        {
            int n= Integer.parseInt(br.readLine());
            String s[]= br.readLine().split(" ");
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i]= Integer.parseInt(s[i]);
                if(arr[i]==0)
                    arr[i]=-1; // modifying 0s to -1, which will help us to see if we have encountered this sum previously
            }
            int count=0; //count number of subarrays with equal number of 0s and 1s(sum same here)
            HashMap<Integer, Integer> hm= new HashMap<>(); //This HashMap updates number of time a particular sum has been encountrered before
            int sum=arr[0];
            hm.put(sum, 1);
            for(int i=1; i<n; i++)
            {
                sum+=arr[i];
                if(sum==0)
                    count++;  // if sum is 0, count is incremented regardless of whether this sum is encountered before or not.
                int val= hm.getOrDefault(sum, 0);
                count+=val; // adding number of time, this sum has been encountered before
                hm.put(sum, ++val); //updating number of times this sum has been encountered till now
            }
            System.out.println(count);
        }
    }
}
