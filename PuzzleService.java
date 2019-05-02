package com.zage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Puzzle的实现
 * @author lzq
 *
 */
public class PuzzleService {
    //原数数组默认大小
    private int default_size = 10;
    //存放原数数组
    private ArrayList<Integer> puzzlelist;
    //原始数组大小
    private int size;
    //栈 正确执行的步骤的记录
    private LinkedList<Integer> stack;

    /**
     * 构造函数
     */
    public PuzzleService() {
        this.size = this.default_size;
        this.puzzlelist = new ArrayList<Integer>(this.size);
        this.stack = new LinkedList<Integer>();
        init();
        printPuzzle();
        //默认从1号位置开始
        this.stack.addFirst(1);
    }




    /**
     * 判断是否能正常执行
     *
     */
    public boolean isSuccess() {
        boolean x = rightMove();
        return x;
    }
    /**
     * 向右移动
     * @return 右移成功
     */
    private boolean rightMove() {
        Integer idx= this.stack.getFirst();
        if(idx == size) {
            //移动到最后一个位置，执行成功
            return true;
        }
        Integer val = this.puzzlelist.get(idx-1);
        idx = idx+val;
        if(idx > size) {
            return false;
        }
        if(this.stack.contains(idx)) {
            //步骤重复
            return false;
        }
        this.stack.addFirst(idx);
        boolean move = rightMove();
        if(!move) {
            //右移完了，不成功，左移
            move = leftMove();
        }
        if(!move) {
            this.stack.removeFirst();
        }
        return move;
    }

    /**
     * 向左移动
     * @return 左移成功
     */
    private boolean leftMove() {
        Integer idx= this.stack.getFirst();
        this.puzzlelist.get(idx-1);
        Integer val = this.puzzlelist.get(idx-1);
        idx = idx-val;
        if(idx < 1) {
            return false;
        }
        if(this.stack.contains(idx)) {
            //步骤重复
            return false;
        }
        this.stack.addFirst(idx);
        boolean move = rightMove();
        if(!move) {
            move = leftMove();
        }
        if(!move) {
            this.stack.removeFirst();
        }
        return move;
    }

    /**
     * 有参构造函数
     * @param size  原数数据大小
     */
    public PuzzleService(int size) {
        if(size > 0 && size > Integer.MAX_VALUE) {
            System.out.println("输入参数不合法");
            return ;
        }
        this.size = size;
        this.puzzlelist = new ArrayList<Integer>(size);
        this.stack = new LinkedList<Integer>();
    }
    /**
     * 打印移动过程
     */
    public void printMove() {
        Integer first= this.stack.getFirst();
        if(first == size) {
            Integer last= this.stack.getLast();
            int stackSize = this.stack.size();
            while(stackSize > 0) {
                this.stack.removeLast();
                stackSize = this.stack.size();
                int next = 0;
                if(stackSize > 0) {
                    next = this.stack.getLast();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("移动过程： ");

                if(next != 0) {

                    if(next > last) {
                        //右移
                        stringBuffer.append("第"+last+"个位置");
                        stringBuffer.append("右移");
                        stringBuffer.append("到第"+next+"个位置");

                    }else {
                        stringBuffer.append("第"+last+"个位置");
                        stringBuffer.append("左移");
                        stringBuffer.append("到第"+next+"个位置");
                    }
                    last = next;
                    System.out.println(stringBuffer.toString());
                }
            }
        }

    }






    /**
     * 数组初始化
     */
    private void init() {
        Random random = new Random();
        for(int i = 0;i < size;i++) {
            //[0,9)--->[1,9]
            int val = random.nextInt(9)+1;
            puzzlelist.add(val);
        }
    }

    private void printPuzzle() {
        Iterator<Integer> iterator = puzzlelist.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
    }
}