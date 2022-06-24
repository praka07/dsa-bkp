package com.practice;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    char c;
    boolean isEnd;
    Map<Character, TrieNode> children = new HashMap<>();
    int counter = 1;

}

public class Trie {
    public String[] prefix(String[] A) {
        String[] result = new String[A.length];
        // create dummy root node
        TrieNode dummy = new TrieNode();
        for (int i = 0; i < A.length; i++) {
            insertIntoTrie(dummy, A[i]);

        }

        for (int j = 0; j < A.length; j++) {
            String uniquePrefix = search(dummy, A[j]);
            result[j] = uniquePrefix;
        }


        return result;
    }

    public void insertIntoTrie(TrieNode root, String input) {
        char[] character = input.toCharArray();
        for (int i = 0; i < character.length; i++) {
            if (root.children.size() > 0 && root.children.containsKey(character[i])) {
                root.children.get(character[i]).counter++;
            } else {
                TrieNode temp = new TrieNode();
                temp.c = character[i];
                root.children.put(character[i], temp);
            }
            root = root.children.get(character[i]);

        }
        root.isEnd = true;

    }

    public String search(TrieNode root, String word) {
        StringBuilder builder = new StringBuilder();
        for (int wordLength = 0; wordLength < word.length(); wordLength++) {
            if (root.children.get(word.charAt(wordLength)).counter == 1) {
                builder.append(word.charAt(wordLength));
                return builder.toString();
            } else {
                builder.append(word.charAt(wordLength));
                root = root.children.get(word.charAt(wordLength));
            }

        }
        return builder.toString();

    }

    public static void main(String[] args) {
        String[] a = {"zebra", "dog", "duck", "dove"};
        Trie object = new Trie();
        System.out.println("result ::: " + object.prefix(a));


    }
}
