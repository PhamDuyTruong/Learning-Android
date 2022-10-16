package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    private var progressBar : ProgressBar?= null
    private  var tvProgress : TextView?= null;
    private var tvQuestions: TextView?= null;
    private var ivImage : ImageView?= null

    private var tvOptionOne: TextView?= null;
    private var tvOptionTwo: TextView?= null;
    private var tvOptionThree: TextView?= null;
    private var tvOptionFour: TextView?= null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tv_progress);
        tvQuestions = findViewById(R.id.tv_question);
        ivImage = findViewById(R.id.iv_image);

        tvOptionOne = findViewById(R.id.tv_option_one);
        tvOptionTwo = findViewById(R.id.tv_option_two);
        tvOptionThree = findViewById(R.id.tv_option_three);
        tvOptionFour = findViewById(R.id.tv_option_four);


        val questionsList = Conststants.getQuestions();
        val currentPosition = 1 // Default and the first question position
        val question: Questions? =
            questionsList[currentPosition - 1];
        progressBar?.progress =
            currentPosition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$currentPosition" + "/" + progressBar?.getMax();

        tvQuestions?.text = question!!.questions
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }
}