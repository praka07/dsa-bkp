package com.practice;

import java.util.HashMap;
import java.util.Map;

class TrieSpellingCheckerNode {
    char c;
    Map<Character, TrieSpellingCheckerNode> children = new HashMap<>();
    int counter = 1;
    boolean isEnd;
}

public class TrieSpellingChecker {
    public int[] solve(String[] A, String[] B) {
        int[] output = new int[B.length];
// insert into trie
        TrieSpellingCheckerNode root = new TrieSpellingCheckerNode();
        for (int i = 0; i < A.length; i++) {
            insert(root, A[i]);
        }

        for (int j = 0; j < B.length; j++) {
            int result = search(root, B[j]);
            System.out.println(result);

        }

        return output;
    }

    public void insert(TrieSpellingCheckerNode root, String word) {

        for (int i = 0; i < word.length(); i++) {
            if (root.children.size() > 0 && root.children.containsKey(word.charAt(i))) {
                root.children.get(word.charAt(i)).counter++;

            } else {
                TrieSpellingCheckerNode temp = new TrieSpellingCheckerNode();
                temp.c = word.charAt(i);
                root.children.put(word.charAt(i), temp);

            }
            root = root.children.get(word.charAt(i));
        }
        root.isEnd = true;

    }

    public int search(TrieSpellingCheckerNode root, String word) {

        for (int i = 0; i < word.length(); i++) {
            if (!root.children.containsKey(word.charAt(i))) {
                return 0;
            }
            root = root.children.get(word.charAt(i));
            if (root.isEnd) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] a = {"hat", "cat", "rat"};
        String[] b = {"cat", "ball"};
        TrieSpellingChecker object = new TrieSpellingChecker();
        System.out.println("result " + object.solve(a, b));
    }
}
