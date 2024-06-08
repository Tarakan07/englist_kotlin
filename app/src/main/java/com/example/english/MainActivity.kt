package com.example.english

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.english.databinding.ActivityLearnWorldBinding
import com.example.english.databinding.ActivityMainBinding
import org.w3c.dom.Text
data class AnswerComponents(
    val layoutAnswer: LinearLayout,
    val tvVariantNumber: TextView,
    val tvVariantValue: TextView
)
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

            markAnswerWrong(AnswerComponents(
                layoutAnswer = binding.layoutAnswer1,
                tvVariantNumber = binding.tvVariantNumber1,
                tvVariantValue = binding.tvVariantValue1
            ));
            showResultMessage(false)
        }
        binding.layoutAnswer3.setOnClickListener {
        markAnswerCorrect(  AnswerComponents(
            layoutAnswer = binding.layoutAnswer3,
            tvVariantNumber = binding.tvVariantNumber3,
            tvVariantValue = binding.tvVariantValue3
        ))
            showResultMessage(true)
        }
        binding.btnContinue.setOnClickListener {
            markAnswerNeutral(AnswerComponents(
                layoutAnswer = binding.layoutAnswer1,
                tvVariantNumber = binding.tvVariantNumber1,
                tvVariantValue = binding.tvVariantValue1
            ))
            markAnswerNeutral(AnswerComponents(
                layoutAnswer = binding.layoutAnswer3,
                tvVariantNumber = binding.tvVariantNumber3,
                tvVariantValue = binding.tvVariantValue3
            ))
        }
    }

    private fun markAnswerNeutral(components:AnswerComponents) {
        val (layoutAnswer, tvVariantNumber, tvVariantValue) = components
        layoutAnswer.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.shape_rounded_containers)

        tvVariantValue.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.textVariantColor))
        tvVariantNumber.apply {
            setTextColor(ContextCompat.getColor(this@MainActivity,R.color.textVariantColor))
            background=ContextCompat.getDrawable(this@MainActivity,R.drawable.shape_rounded_variant)
        }


        binding.layoutResult.isVisible=false;
        binding.btnSkip.isVisible=true
    }

    private fun markAnswerWrong(components:AnswerComponents) {
        val (layoutAnswer, tvVariantNumber, tvVariantValue) = components
            layoutAnswer.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_containers_wrong);

            tvVariantNumber.setTextColor(ContextCompat.getColor(this,R.color.white));
            tvVariantNumber.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_variant_wrong)

            tvVariantValue.setTextColor(ContextCompat.getColor(this,R.color.wrong_layout))



        }


    private fun markAnswerCorrect(components:AnswerComponents) {
        val (layoutAnswer, tvVariantNumber, tvVariantValue) = components
        layoutAnswer.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_containers_correct);

        tvVariantNumber.setTextColor(ContextCompat.getColor(this,R.color.white));
        tvVariantNumber.background=ContextCompat.getDrawable(this,R.drawable.shape_rounded_variant_correct)

        tvVariantValue.setTextColor(ContextCompat.getColor(this,R.color.current_layout))


    }

    private fun showResultMessage(isCorrect:Boolean){
        val color:Int
        val messageText:String
        val resultIcon: Drawable?
        if(isCorrect){
            color=ContextCompat.getColor(this,R.color.current_layout)
          messageText=resources.getString(R.string.title_correct)
          resultIcon=ContextCompat.getDrawable(this,R.drawable.ic_like)
        }else{
            color=ContextCompat.getColor(this,R.color.wrong_layout)
            messageText=resources.getString(R.string.title_wrong)
            resultIcon=ContextCompat.getDrawable(this,R.drawable.ic_wrong)
        }
        with(binding)
        {
            btnSkip.isVisible=false;
            layoutResult.isVisible=true
            layoutResult.setBackgroundColor(color);
            btnContinue.setTextColor(color)
            ivResultIcon.setImageDrawable(resultIcon)
            tvResultMessage.text= messageText
        }
    }
}