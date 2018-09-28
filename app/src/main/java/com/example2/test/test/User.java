package com.example2.test.test;

import java.util.List;

/**
 * Created by zwj on 6/14/18.
 */

public class User {

    public static <T> void printList2(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static <T> void printList1(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    /**
     * @param T 返回值,以及使用的参数
     * @param <T>   属于参数声明
     * @return
     */
    public <T> T testG(T t){
        return t;
    }


}
