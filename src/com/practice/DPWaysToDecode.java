package com.practice;

import java.util.Arrays;

public class DPWaysToDecode {
    public int numDecodings(String A) {
        if(A.length()==0){
            return 0;
        }
        if(A.charAt(0)=='0'){
            return 0;
        }
        int[] dp= new int[A.length()+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=A.length();i++){
            if(A.charAt(i-1)>='1' && A.charAt(i-1)<='g'){
                dp[i]=dp[i-1];

            }
            if(A.charAt(i-2)=='1'){
                dp[i]+=dp[i-2];
            }else if(A.charAt(i-2)=='2' && A.charAt(i-1)>='0' && A.charAt(i-1)<='6'){
                dp[i]+=dp[i-2];
            }
        }

        return dp[A.length()];
    }
}
