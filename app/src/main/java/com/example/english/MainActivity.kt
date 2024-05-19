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
        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong();
        }
        binding.layoutAnswer3.setOnClickListener {
        markAnswerCorrect()
        }
        binding.btnContinue.setOnClickListener {
            markAnswerNeutral()
        }
    }

    private fun markAnswerNeutral() {
        with(binding){
            for(layout in listOf(layoutAnswer1,layoutAnswer3)){
                layout.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.shape_rounded_containers)

            }
            for(textView in listOf(tvVariantValue1,tvVariantValue3)){
                textView.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.textVariantColor))
            }
            for (textViewNumber in listOf(tvVariantNumber1,tvVariantNumber3)){
//                textViewNumber.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.textVariantColor))
//                textViewNumber.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.shape_rounded_variant)

                textViewNumber.apply {
                    setTextColor(ContextCompat.getColor(this@MainActivity,R.color.textVariantColor))
                   background=ContextCompat.getDrawable(this@MainActivity,R.drawable.shape_rounded_variant)
                }
            }

            layoutResult.isVisible=false;
            btnSkip.isVisible=true
        }
    }

    private fun markAnswerWrong() {
        binding.layoutAnswer1.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_containers_wrong);

        binding.tvVariantNumber1.setTextColor(ContextCompat.getColor(this,R.color.white));
        binding.tvVariantNumber1.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_variant_wrong)

        binding.tvVariantValue1.setTextColor(ContextCompat.getColor(this,R.color.wrong_layout))

        binding.btnSkip.isVisible=false;

        binding.layoutResult.setBackgroundColor(ContextCompat.getColor(this,R.color.wrong_layout));

        binding.ivResultIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_wrong))
        binding.tvResultMessage.text= resources.getString(R.string.title_wrong);
        binding.btnContinue.setTextColor(ContextCompat.getColor(this,R.color.wrong_layout))
        binding.layoutResult.isVisible=true
    }

    private fun markAnswerCorrect() {
        binding.layoutAnswer3.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_containers_correct);

        binding.tvVariantNumber3.setTextColor(ContextCompat.getColor(this,R.color.white));
        binding.tvVariantNumber3.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_variant_correct)

        binding.tvVariantValue3.setTextColor(ContextCompat.getColor(this,R.color.current_layout))

        binding.btnSkip.isVisible=false;

        binding.layoutResult.setBackgroundColor(ContextCompat.getColor(this,R.color.current_layout));
        binding.btnContinue.setTextColor(ContextCompat.getColor(this,R.color.current_layout))
        binding.ivResultIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_like))
        binding.tvResultMessage.text= resources.getString(R.string.title_correct);

       binding.layoutResult.isVisible=true
    }
}