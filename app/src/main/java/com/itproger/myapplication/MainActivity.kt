package com.itproger.myapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.itproger.myapplication.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity(), CounterView  {
    lateinit var binding: ActivityMainBinding
   private var presenter =  Injector.getPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            incrementBtn.setOnClickListener {
           presenter.increment()
            }
            decrementBtn.setOnClickListener {
           presenter.decrement()
            }
            darkThemeBtn.setOnClickListener {
                presenter.darkTheme()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast(congretulation: String) {
        Toast.makeText(this, congretulation, Toast.LENGTH_SHORT).show()
    }

    override fun darkTheme() {
     binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        binding.counterTv.setTextColor(ContextCompat.getColor(this, R.color.white))

    }

    override fun lightTheme() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        binding.counterTv.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    override fun textColor() {
        binding.counterTv.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

    override fun color() {
        binding.counterTv.setTextColor(ContextCompat.getColor(this, R.color.black))
    }


}