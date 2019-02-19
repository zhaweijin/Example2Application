package com.example2.test.queuelist;

import android.os.Looper;
import android.util.Log;

import java.util.Arrays;

/**
 * package_name:com.hiveview.abn.util
 * author: 李文烙
 * date: 2017/11/29
 * company: hiveview
 * @Desc:循环队列工具类
 */

public class CircleQueue{

    private static final String TAG = "queue";
    /**
     * 循环队列 （数组）默认大小
     */
    private final int DEFAULT_SIZE = 1000;

    /**
     * (循环队列)数组的容量
     */
    public int capacity;

    /**
     * 数组：保存循环队列的元素
     */
    public char[] elementData;

    /**
     * 队头(先见先出)
     */
    public int head = 0;

    /**
     * 队尾
     */
    public int tail = 0;

    /**
     * 以循环队列 默认大小创建空循环队列
     */
    public CircleQueue() {
        capacity = DEFAULT_SIZE;
        elementData =new char[capacity];
    }

    /**
     * 以指定长度的数组来创建循环队列
     *
     * @param initSize
     */
    public CircleQueue(final int initSize) {
        capacity = initSize;
        elementData =new char[capacity];
    }

    /**
     * 获取循环队列的大小(包含元素的个数)
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (isFull()) {
            return capacity;
        } else {
            return tail + 1;
        }
    }

    /**
     * 插入队尾一个元素
     */
    public void add(final char element) {
        if (isEmpty()) {
            Log.v(TAG,"add head null");
            elementData[0] = element;
        } else if (isFull()) {
            elementData[head] = element;
            head++;
            tail++;
            Log.v(TAG,"1add head=="+head+",tail=="+tail);
            head = (head == capacity)? 0 : head;
            tail = (tail == capacity)? 0 : tail;
            Log.v(TAG,"2add head=="+head+",tail=="+tail);
        } else {
            elementData[tail + 1] = element;
            tail++;
            Log.v(TAG,"add  tail="+tail);
        }
    }

    public boolean isEmpty() {
        return tail == head && tail == 0 && (String.valueOf(elementData[tail])==null||String.valueOf(elementData[tail]).equals(""));
    }

    public boolean isFull() {
        return head != 0 && head - tail == 1 || head == 0 && tail == capacity - 1;
    }

    public void clear() {
        elementData=new char[capacity];
        head = 0;
        tail = 0;
    }

    /**
     * @return 取 循环队列里的值（先进的index=0）
     */
    public char[] getQueue() {
        Log.v(TAG,"tail="+tail);
        final char[] elementDataSort =new char[capacity];
        final char[] elementDataCopy = elementData.clone();
        Log.v(TAG,"origin value=="+String.valueOf(elementDataCopy));
        int size=0;
        Log.v(TAG,"isFull="+isFull());
        if (isEmpty()) {
        } else if (isFull()) {
            int indexMax = capacity;
            int indexSort = 0;
            for (int i = head; i < indexMax;) {
                if (i<capacity&&indexSort<capacity)
                {
                    elementDataSort[indexSort] = elementDataCopy[i];
                    indexSort++;
                    i++;
                }
                if (i == capacity) {
                    i = 0;
                    indexMax = head;
                }
                size++;
                if (size>=5 * 1024 * 1024){
                    Log.i("DebugActivity","无限循环，进行手动break;");
                    break;
                }
            }
        } else {
            // elementDataSort = elementDataCopy;//用这行代码代替下面的循环，在队列刚满时候会出错
            for (int i = 0; i < tail; i++) {
                size++;
                elementDataSort[i] = elementDataCopy[i];
                if (size>=5 * 1024 * 1024){
                    Log.i("DebugActivity","无限循环，进行手动break;");
                    break;
                }
            }
        }
        return elementDataSort;
    }

}
