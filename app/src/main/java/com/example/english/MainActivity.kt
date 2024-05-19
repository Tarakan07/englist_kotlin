package com.example.english

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
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

    //

        binding.layoutAnswer3.setOnClickListener {
        markAnswerCorrect()
        }
    }

    private fun markAnswerCorrect() {
        binding.layoutAnswer3.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_containers_correct);

        binding.tvVariantNumber3.setTextColor(ContextCompat.getColor(this,R.color.white));
        binding.tvVariantNumber3.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_variant_correct)

        binding.tvVariantValue3.setTextColor(ContextCompat.getColor(this,R.color.current_layout))

        binding.btnSkip.isVisible=false;

        binding.layoutResult.setBackgroundColor(ContextCompat.getColor(this,R.color.current_layout));

        binding.ivResultIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_like))
        binding.tvResultMessage.text=resources.getString(R.string.title_correct);

       binding.layoutResult.isVisible=true
    }
}