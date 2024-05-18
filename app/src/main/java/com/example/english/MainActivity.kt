package com.example.english

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.english.databinding.ActivityLearnWorldBinding
import com.example.english.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityLearnWorldBinding;
    private var _binding:ActivityLearnWorldBinding?=null;
    private val binding
        get() = _binding?:throw IllegalThreadStateException("Binding for ActivityLearnWorldBinding not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityLearnWorldBinding.inflate(layoutInflater);
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.learn_world)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = ContextCompat.getColor(this,R.color.red);

//    val tvQuestionWord:TextView=findViewById(R.id.tvQuestionWord);
//        tvQuestionWord.setTextColor(ContextCompat.getColor(this,R.color.black))

//        binding.tvQuestionWord.text="Lalala";
//        binding.tvQuestionWord.setTextColor(Color.GRAY)

        with(binding){
            tvQuestionWord.text="Lalala";
            tvQuestionWord.setTextColor(Color.GRAY)
        }
    }
}