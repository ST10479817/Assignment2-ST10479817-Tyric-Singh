package za.ac.iie.assignment2tyricsinghst10479817

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela become South African's first Black president in 1994",
        "The Soweto Uprising happened in 1980",
        "Nelson Mandela was sentenced to life in prison",
        "The ANC was banned again in 1994",
        "Apartheid officially ended in 1994"
    )

    private val answers = booleanArrayOf(
        true,
        false,
        true,
        false,
        true
    )

    private var currentQuestion = 0
    private var userAnswers = BooleanArray(questions.size)
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        val trueButton = findViewById<Button>(R.id.btntrue)
        val falseButton = findViewById<Button>(R.id.btnfalse)
        val nextButton = findViewById<Button>(R.id.btnnext)
        val questionText = findViewById<TextView>(R.id.txtquestion)
        val feedbackText = findViewById<TextView>(R.id.txtfeedback)
        val scoreText = findViewById<TextView>(R.id.txtscore)
        val mainLayout = findViewById<ViewGroup>(R.id.main)


        val backgrounds = arrayOf(
            R.drawable.question_one,
            R.drawable.question_two,
            R.drawable.question_three,
            R.drawable.question_four,
            R.drawable.question_five
        )

        nextButton.visibility = Button.GONE

        fun questionDisplay() {
            questionText.text = questions[currentQuestion]
            feedbackText.text = " "
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            mainLayout.setBackgroundResource(backgrounds[currentQuestion])
        }

        fun answerchecker(userAnswer: Boolean){
            userAnswers[currentQuestion] = userAnswer

            if (userAnswer == answers[currentQuestion]){
                feedbackText.text = "Correct"
                score++
            } else {
                feedbackText.text = "Incorrect"
            }

            scoreText.text = "Score: $score"
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }

        questionDisplay()

        trueButton.setOnClickListener {
            answerchecker(true)
            nextButton.visibility = Button.VISIBLE
        }
        falseButton.setOnClickListener {
            answerchecker(false)
            nextButton.visibility = Button.VISIBLE
        }

        nextButton.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                questionDisplay()
                nextButton.visibility = Button.GONE
            } else {
                var finalScore = 0
                for (i in questions.indices) {
                    if (userAnswers[i] == answers[i])
                        finalScore++
                }

                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", finalScore)
                intent.putExtra("score", score)
                intent.putExtra("userAnswers", userAnswers)

                startActivity(intent)
                finish()

            }
        }
    }
}













