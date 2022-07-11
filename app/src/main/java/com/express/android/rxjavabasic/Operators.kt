package com.express.android.rxjavabasic

import android.util.Log
import com.express.android.rxjavabasic.data.User
import com.express.android.rxjavabasic.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit

val mListNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 16)
val arraysNum = arrayOf(1, 3, 2, 4, 5, 7, 4, 3)

fun justOperator(){
    val observable = Observable.just(mListNum)

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onNext(t: List<Int>?) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }
}

fun fromOperator(){
    val observable = Observable.fromArray(mListNum)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(MainActivity.TAG, "onNext: ${Arrays.toString(t)}")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError: ${e.toString()}")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }
}

val mUserList = mutableListOf<User>(
    User(1, "demo1", 15),
    User(2, "demo2", 18),
    User(3, "demo3", 20),
    User(4, "demo4", 21),
    User(5, "demo5", 23),
    User(6, "demo6", 22),
)

val mUserProfileList = mutableListOf<UserProfile>(
    UserProfile(1, "demo1", 15, "https://test.com/1"),
    UserProfile(2, "demo2", 18, "https://test.com/2"),
    UserProfile(3, "demo3", 20, "https://test.com/3"),
    UserProfile(4, "demo4", 23, "https://test.com/4"),
    UserProfile(5, "demo5", 26, "https://test.com/5"),
    UserProfile(6, "demo6", 15, "https://test.com/6"),
)

fun fromIterableOperator(){
    val observable = Observable.fromIterable(mListNum)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onNext(t: Int?) {
            Log.d(MainActivity.TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError: ${e.toString()}")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }

    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 100)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 10).repeat(2)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).takeWhile{ value ->
        value <= 10
    }
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create(ObservableOnSubscribe<Int> {

        try {
            for(i in mListNum) {
                it.onNext(i * 5)
            }

            it.onComplete()

        } catch(e: Exception) {
            it.onError(e)
        }
    })
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun bufferOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun mapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(id: Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
        .filter {
            it.id == id
        }
}

fun flatMapOperatorT2(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun groupByOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUser(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getProfile(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun mergeOperator(): Observable<Any> {
    return Observable.merge(getUser(), getProfile())
}

fun getNum1To100(): Observable<Int> {
    return Observable.range(1, 100)
}

fun getNum101To150(): Observable<Int> {
    return Observable.range(101, 50)
}

fun concatOperator(): Observable<Int> {
    return getNum1To100().concatWith(getNum101To150())
}

fun startWithOperator(): Observable<User> {
    //return getNum101To150().startWith(getNum1To100())
    return getUser().startWith(Single.just(User(0, "demo1", 15)))
}