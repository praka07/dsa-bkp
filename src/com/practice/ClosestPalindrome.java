package com.practice;

public class ClosestPalindrome {
    public String solve(String A) {
        int n=A.length();
        int count = 0;
        StringBuilder sb = new StringBuilder(A);

        String s = sb.reverse().toString();



        if(s.equals(A))

        {

            if(n%2 == 1)

                return "YES";

            else

                return "NO";

        }

        else{

            for (int i = 0; i < n/2; ++i)

            {

                if (A.charAt(i) != A.charAt(n - i - 1))

                    count++;

            }

        }

        if(n==1)

            return "YES";

        else if(count==1)

            return "YES";

        else

            return "NO";

    }
}
