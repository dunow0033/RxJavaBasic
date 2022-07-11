package com.express.android.rxjavabasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.express.android.rxjavabasic.data.User
import com.express.android.rxjavabasic.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.just
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    val mList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 43)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fromOperator()
        //fromIterableOperator()

//        rangeOperator().subscribe(
//            {
//                Log.d(TAG, " onNext : $it")
//            },
//            {
//                Log.d(TAG, " onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        intervalOperator().subscribe(
//            {
//                Log.d(TAG, " onNext : $it")
//                getLocation()
//            },
//            {
//                Log.d(TAG, " onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )
//    }

//        createOperator().subscribe(
//            {
//
//            }
//        )

//        filterOperator()
//            .filter {
//                it.age > 18
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, " onNext : $it")
//                },
//                {
//                    Log.d(TAG, " onError ${it.toString()}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        lastOperator()
//            //.last(User(1, "demo1", 15))
//            //.lastElement()
//            .lastOrError()
//            .subscribe(
//                {
//                    Log.d(TAG, " onNext : $it")
//                },
//                {
//                    Log.d(TAG, " onError ${it}")
//                }
//            )

//        distinctOperator()
//            .distinct {
//                it.age
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        skipOperator()
//            .skip(2, TimeUnit.SECONDS)
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        mapOperator()
//            //.map { it.age * 2 }
//            .map {
//                UserProfile(it.id, it.name, it.age, "https://test.com/${it.id}")
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        flatMapOperator()
//            .flatMap {
//                getUserProfile(it.id)
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        flatMapOperatorT2()
//            .flatMap {
//                Observable.fromIterable(it)
//            }
//            .flatMap {
//                getUserProfile(it.id)
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        groupByOperator()
//            .groupBy {
//                it.age
//            }
//            .flatMapSingle { group ->
//                group.toList()
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        mergeOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        concatOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

        startWithOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext $it")
                },
                {
                    Log.d(TAG, "onError ${it}")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )
    }

    private fun getLocation() {
        Log.d(TAG, "Latitude: 102.0303 Longitude: 1.2355")
    }
}