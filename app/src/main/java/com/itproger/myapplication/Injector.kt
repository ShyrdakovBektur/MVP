package com.itproger.myapplication

class Injector {


    companion object{
        fun getModel() = Model()
        fun getPresenter(view: CounterView) = Presenter(view)

    }
}