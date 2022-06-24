package com.practice;

class TrieNodeXor {
    TrieMaximumXor[] node = new TrieMaximumXor[2];

}

public class TrieMaximumXor {
    public int solve(int[] A) {

        return 0;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        TrieMaximumXor object = new TrieMaximumXor();
        System.out.println("result " + object.solve(a));
        int num = 6;
        for (int i = 32; i >= 0; i--) {
            // System.out.println(num >>32);
            int bit = (num >> i) & 1;
            System.out.print(" " + bit);
        }
    }
}
