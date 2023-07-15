package com.itproger.myapplication

class Presenter constructor(var view: CounterView){

    var model = Injector.getModel()

    fun increment() {
        model.increment()
        view.showCount(model.count)
        if (model.count == 10){
            view.showToast("Поздравляем вы дошли до 10!!")
        }
        if (model.count == 15){
            view.textColor()
            view.showToast("Цвет поменялось на зеленый!")
        }else{
            view.color()
        }
    }


    fun darkTheme() {
        if (!model.isDark) {
            model.isDark = true
            view.darkTheme()
        }else{
            model.isDark = false
            view.lightTheme()
        }
    }

fun decrement() {
    model.decrement()
    view.showCount(model.count)
    if (model.count == -10){
        view.showToast("-10 что здесь происходит 0_0?")
    }
}
}