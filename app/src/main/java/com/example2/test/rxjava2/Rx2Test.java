package com.example2.test.rxjava2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example2.test.base.BaseActivity;
import com.example2.test.utils.PUtils;
import com.example2.test.utils.RxUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by zwj on 6/8/18.
 */

public class Rx2Test extends BaseActivity{

    /**
     *   1.Observable/Observer
     *   2.Flowable/Subscriber
     *
     *   3.Single/SingleObserver
     *   4.Completable/CompletableObserver
     *   5.Maybe/MaybeObserver
     * Maybe/MaybeObserver可以说是前两者的复合体(当你只想要某个事件的结果（true or false)的时候，你可以用这种观察者模式)
     */

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, Rx2Test.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        testObservable();
//        testFlowable();
//        testMaybe();
//        testObserArray();
        testObserfromCallable();
    }


    private void testObservable() {
        Observable mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onComplete();
                //send message
            }
        });

        //receive message

        Observer mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String o) {
                PUtils.print("onNext==" + o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        mObservable.subscribe(mObserver);

    }

    //尽可能确保在request（）之前已经完成了所有的初始化工作
    private void testFlowable(){
        Flowable.range(1,10)
                .subscribe(new Subscriber<Integer>() {
                    Subscription sub;
                    @Override
                    public void onSubscribe(Subscription s) {
                        sub = s;
                        s.request(1);   //3属于策略，允许发送的个数
                    }

                    @Override
                    public void onNext(Integer integer) {
                        PUtils.print("onNext---"+integer);
                        sub.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        //允许create 方式创建
        /*Flowable mFlowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {

            }
        }, BackpressureStrategy.BUFFER);*/
    }


    /**
     * 单一发射数据的情况使用
     */
    private void testMaybe(){
        Maybe.just(true)
                .subscribe(new MaybeObserver<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Boolean aBoolean) {
                        PUtils.print("maybe ===="+aBoolean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void testObserArray() {
        String[] strings = {"Hello", "RxJava", "Nice to meet you"};
        Observable.fromArray(strings)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        PUtils.print("from array----"+s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        //just是在主线程执行的
        Observable.just("yy")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });


    }


    private void testObserfromCallable() {
        Observable<String> mObservable = Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //此处属于子线程执行
                return "tt";
            }
        });

        mObservable.compose(RxUtils.rxSchedulerHelper())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        PUtils.print("from callable ---"+o);
                    }
                });
    }
}
