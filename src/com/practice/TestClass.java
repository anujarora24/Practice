package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
    
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/
        List<Integer> mainSet = new ArrayList<Integer>();

       /* for (int i = 0; i < N; i++) {
            line = br.readLine();
            mainSet.add(Integer.parseInt(line));
        }*/
        
        mainSet.add(2);
        mainSet.add(3);
        mainSet.add(5);
        
        int finalSum =0;
        
        final List<List<String>> allSubsets = subSet(mainSet,0);
        for(List<String> subsets : allSubsets)
        {
            int subsetSum = 1;
           for(String vals : subsets)
           {
               String[] arrStrVals = vals.split(",");
               if(arrStrVals.length > 1){
                   for(int i=0;i< arrStrVals.length ; i++){
                       subsetSum = subsetSum * Integer.parseInt(arrStrVals[i]);
                   }
               }
               else{
                   subsetSum = Integer.parseInt(arrStrVals[0]);
               }
           }
           finalSum = finalSum + subsetSum;
        }
        
        System.out.println(finalSum);
        
    }
    
    private static List<List<String>> subSet(final List<Integer> values, int index){
        if(index==values.size()){
            return new ArrayList<>();
        }
        int val = values.get(index);
        List<List<String>> subset = subSet(values, index+1);
        List<List<String>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(String.valueOf(val)));
        returnList.addAll(subset);
        for(final List<String> subsetValues : subset){
            for(final String subsetValue : subsetValues){
                returnList.add(Arrays.asList(val+","+subsetValue));
            }
        }
        
        return returnList;
        
    }
}
