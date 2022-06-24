package com.practice;

import java.util.HashMap;
import java.util.Map;

public class MakeThemEqual {
    public int solve(int[] A){
        HashMap<Integer,Integer> frequencyMap= new HashMap<Integer,Integer>();
        int number=0;
        for(int i=0;i<A.length;i++){
            frequencyMap.put(A[i],frequencyMap.getOrDefault(A[i],0)+1);
        }
        int max=Integer.MIN_VALUE;

        for(Map.Entry<Integer,Integer> map:frequencyMap.entrySet()){
            if(map.getValue()>max){
                max= map.getValue();
            }
            if(max==A.length){
                return 0;
            }
        }

        return 0;

    }
    public static void main(String[] args) {

    }
}
