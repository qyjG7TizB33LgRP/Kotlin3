package com.example.kotlin3

import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatViewInflater
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding>:AppCompatActivity() {
    lateinit var binding:VB
    protected abstract fun  inflateBinding(inflater:LayoutInflater):VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()
    }

    abstract fun initView()
}