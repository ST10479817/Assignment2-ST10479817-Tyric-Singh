package za.ac.iie.assignment2tyricsinghst10479817

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val userAnswers = intent.getBooleanArrayExtra("userAnswers")

        val scoreText = findViewById<TextView>(R.id.txtscores)
        val feedbackText = findViewById<TextView>(R.id.txtdisplayFeedback)
        val reviewText = findViewById<TextView>(R.id.txtreview)
        val reviewButton = findViewById<Button>(R.id.btnreview)
        val exitButton = findViewById<Button>(R.id.btnexit)
        val reviewTitle = findViewById<TextView>(R.id.txtreviewTitle)


        scoreText.text = "$score/5"

        reviewButton.setBackgroundColor(Color.MAGENTA)
        exitButton.setBackgroundColor(Color.RED)
        reviewTitle.visibility = Button.GONE


        feedbackText.text = if (score >= 3){
            "Great job!"
        } else {
            "Keep practising"
        }

        reviewButton.setOnClickListener {
            val questions = arrayOf(
                "Nelson Mandela became South Africa's first Black president in 1994.",
                "The Soweto Uprising happened in 1980.",
                "Nelson Mandela was sentenced to life in prison.",
                "The ANC was banned again in 1994.",
                "Apartheid officially ended in 1994."
            )

            val answers = booleanArrayOf(
                true,
                false,
                true,
                false,
                true
            )

            if (userAnswers == null) {
                reviewText.text = "User answers not available."
                return@setOnClickListener
            }

            val reviewContent = StringBuilder()
            for (i in questions.indices){
                val correct = userAnswers[i] == answers[i]
                val result = if (correct) "Correct"  else "Incorrect"
                reviewContent.append("${questions[i]} \nThe Correct answer was: ${answers[i]} \nYou were: $result\n\n")
            }
            reviewText.text = reviewContent.toString()
            scoreText.visibility = Button.GONE
            feedbackText.visibility = Button.GONE
            reviewButton.visibility = Button.GONE
            reviewTitle.visibility = Button.VISIBLE

        }

        exitButton.setOnClickListener {
            finishAffinity()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}