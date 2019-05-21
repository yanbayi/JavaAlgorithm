package com.exercise;

public class FirstTrie {
    class Node{
        Node[] nodes;
        boolean isEnd;
        public Node(){
            nodes = new Node[26];
        }
    }
    private Node root;

    public FirstTrie(){
        root = new Node();
    }
    public void insert(String word){
        Node t = root;
        for(int i = 0;i < word.length();i++){
            int index = word.charAt(i)-'a';
            if(t.nodes[index] == null){
                t.nodes[index] = new Node();
            }
            t = t.nodes[index];//跳到子节点
        }
        t.isEnd = true;
    }
    public boolean search(String word){
        Node t = root;
        for(int i = 0;i < word.length();i++){
            int index = word.charAt(i)-'a';
            if(t.nodes[index] == null){
                return false;
            }
            t = t.nodes[index];
        }
        return t.isEnd == true;
    }

    public boolean startsWith(String word){
        Node t = root;
        for(int i = 0;i < word.length();i++){
            int index = word.charAt(i)-'a';
            if(t.nodes[index] == null){
                return false;
            }
            t = t.nodes[index];
        }
        return true;
    }

    public static void main(String[] args) {
        FirstTrie m = new FirstTrie();
        m.insert("from");
        m.insert("tomorrow");
        m.insert("on");
        m.search("on");
        m.startsWith("o");
    }
}

