package com.practice;

public class VimeoFirstQuestion {
    public static void main(String[] args) {
        VimeoFirstQuestion object = new VimeoFirstQuestion();
        System.out.println(" power ->" + (int)object.myPow(2.0,100000));
        int powerOf2 = 1 << 11;
        double temp= 2;
        System.out.println(powerOf2);
        double result = (int)Math.pow(2, 100);
        System.out.println(" result ->" + result);

    }

    public long calculatePower(int exponent) {
        int base = 2;

        long result = 1;

        while (exponent != 0) {
            result *= base;
            --exponent;
        }
        return result;
    }

    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn<0){
            nn=-1*nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;

            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) {
            ans = (double) (1.0) / (double) ans;
        }

        return ans;
    }
}
