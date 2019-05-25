package com.exercise;
/*
* 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母在一个单词中不允许被重复使用。
示例:
输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:
你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作
？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find2 {
    public int[] dx={1,-1,0,0};
    public int[] dy={0,0,1,-1};
    class Trie{
        Trie[] tries;
        String isEnd;
        public Trie(){
            tries = new Trie[26];
        }
    }
    public boolean[][] vis;    //是否判断过
    public List<String> res;    //答案

    public void insert(String word, Trie root){
        Trie t = root;
        for(int i = 0;i < word.length();i++){
            int index = word.charAt(i)-'a';
            if(t.tries[index] == null){
                t.tries[index] = new Trie();
            }
            t = t.tries[index];//跳到子节点
        }
        t.isEnd = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        //先把单词存入字典树当中
        Trie root=new Trie();
        for(String word:words){
           insert(word,root);
        }

        res=new ArrayList<String>();
        vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){  //对board每一个点都进行检索
            for(int j=0;j<board[i].length;++j){
                dfs(root,i,j,board);
            }
        }
        Collections.sort(res);  //需要对结果进行排序
        return new ArrayList<String>(res);
    }

    public void dfs(Trie cur,int x,int y,char[][] board){
        //判断边界
        if(x<0||y<0||x>=board.length||y>=board[0].length||vis[x][y]){
            return;
        }
        cur=cur.tries[board[x][y]-'a'];  //延伸下一个节点
        vis[x][y]=true; //把当前设置为走过 不可重复走
        if(cur!=null){ //如果当前不为null的话 可以继续检索
            if(cur.tries!=null){ //说明到这里已经可以组成一个单词了
                res.add(cur.isEnd);
                cur.tries=null; //变成null是为了防止重复加入单词
            }
            for(int i=0;i<4;++i){
                dfs(cur,x+dx[i],y+dy[i],board); //四个方向检索
            }
        }
        vis[x][y]=false;
    }


    public static void main(String[] args) {

        String[] words ={"oath","pea","eat","rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        com.zage.Solution m = new com.zage.Solution();
        List<String> a = m.findWords(board,words);
        System.out.println(a.toString());
    }
}
