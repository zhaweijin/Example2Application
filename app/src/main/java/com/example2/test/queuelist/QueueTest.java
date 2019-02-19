package com.example2.test.queuelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example2.test.base.BaseActivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class QueueTest extends BaseActivity{

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, QueueTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CircleQueue circleQueue = new CircleQueue(8);


        circleQueue.add('a');
        circleQueue.add('b');
        circleQueue.add('c');

        circleQueue.add('d');
        circleQueue.add('e');
        circleQueue.add('f');

        circleQueue.add('g');
        circleQueue.add('h');
        circleQueue.add('j');

        circleQueue.add('k');


        //Log.v("test",String.valueOf(circleQueue.getQueue()));



        Queue<Character> queue = new LinkedList<Character>();
        //添加元素
        queue.add('a');
        queue.add('b');
        queue.add('c');
        queue.add('d');
        queue.add('e');
        Log.v("test",">>"+String.valueOf(queue));
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            Log.v("test","value="+iterator.next());
        }



        LimitQueue<Character> lqueue = new LimitQueue<Character>(3);

        lqueue.offer('1');
        lqueue.offer('2');
        /*lqueue.offer('3');
        lqueue.offer('4');
        lqueue.offer('a');
        lqueue.offer('b');*/


        for (Character c : lqueue.getQueue()) {
            System.out.println(c);
        }
    }


}
