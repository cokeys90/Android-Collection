package com.cokeys90.android.collection.sample.animation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cokeys90.android.collection.R
import com.cokeys90.android.collection.activity.base.BaseActivity
import com.cokeys90.android.collection.databinding.ActivityFirstBinding

class FirstActivity : BaseActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onResume() {
        super.onResume()
        initBinding()
    }


    private fun initBinding(){
        binding.apply {
            btnGo.isEnabled = true
            btnGo.setOnClickListener(){
                btnGo.isEnabled = false
                val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}