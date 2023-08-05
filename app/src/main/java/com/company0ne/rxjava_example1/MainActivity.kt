package com.company0ne.rxjava_example1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //simpleObserver()

        createObservable()
    }
    //Example 2
    private fun createObservable() {
        val observable = Observable.create<String>{
            it.onNext("One")
            //To check the exception Handling
            //it.onError(IllegalArgumentException("Error in Observable"))
            it.onNext("Two")
            it.onComplete()
        }
        observable.subscribe(object :Observer<String>{
            override fun onSubscribe(d: Disposable) {
                Log.d("TAG","onSubscribe is called")

            }

            override fun onError(e: Throwable) {
                Log.d("TAG","onNext is called - ${e.message}")
            }

            override fun onComplete() {
                Log.d("TAG","onComplete is called")
            }

            override fun onNext(t: String) {
                Log.d("TAG","onNext is called -$t")
            }

        })
    }
    //Example 1
    /*
    private fun simpleObserver() {
        val list = listOf<String>("A","B","C")
         val observable = Observable.fromIterable(list)

        observable.subscribe(object :Observer<String>{
            override fun onSubscribe(d: Disposable) {
                Log.d("TAG","onSubscribe is called")
            }

            override fun onError(e: Throwable) {
                Log.d("TAG","onNext is called - ${e.message}")
            }

            override fun onComplete() {
                Log.d("TAG","onComplete is called")
            }

            override fun onNext(t: String) {
                Log.d("TAG","onNext is called -$t")
            }

        })
    } */
}