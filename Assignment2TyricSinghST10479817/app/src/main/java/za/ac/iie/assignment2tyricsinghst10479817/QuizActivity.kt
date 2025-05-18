package za.ac.iie.assignment2tyricsinghst10479817

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    //Questions array
    private val questions = arrayOf(
        "Nelson Mandela become South African's first Black president in 1994.",
        "The Soweto Uprising happened in 1980.",
        "Nelson Mandela was sentenced to life in prison.",
        "All South Africans gained voting rights before 1994",
        "Apartheid officially ended in 1994."
    )

    //Answers array for each question
    private val answers = booleanArrayOf(
        true,
        false,
        true,
        false,
        true
    )

    //Variable that tracks the current question to display
    private var currentQuestion = 0
    //An array that stores the user's answers using (True/ False) for each question
    private var userAnswers = BooleanArray(questions.size)
    //Variable to keep track of the user's score based on the user's correct answers
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

        //Background images for each question in an array
        val backgrounds = arrayOf(
            R.drawable.question_one,
            R.drawable.question_two,
            R.drawable.question_three,
            R.drawable.question_four,
            R.drawable.question_five
        )

        //Making Next button non-visibility
        nextButton.visibility = Button.GONE

        //Making each Button a different colour
        trueButton.setBackgroundColor(Color.GREEN)
        falseButton.setBackgroundColor(Color.RED)
        nextButton.setBackgroundColor(Color.MAGENTA)

        //A function that changes the question and background
        fun questionDisplay() {
            // Loop to display each question
            for (i in currentQuestion until questions.size){
            questionText.text = questions[i]
            feedbackText.text = ""
            mainLayout.setBackgroundResource(backgrounds[i])
            break
            }
        }

        //Checks the user's answer and updates the score
        fun answerchecker(userAnswer: Boolean){
            userAnswers[currentQuestion] = userAnswer

            if (userAnswer == answers[currentQuestion]){
                feedbackText.text = "Correct"
                score++
            } else {
                feedbackText.text = "Incorrect"
            }

            //Updates the score display
            scoreText.text = "Score: $score"

            //Hides the False and True button
            trueButton.visibility = Button.GONE
            falseButton.visibility = Button.GONE
        }

        //Displays the questions
        questionDisplay()

        //Handles the True Button and brings out the Next Button
        trueButton.setOnClickListener {
            answerchecker(true)
            nextButton.visibility = Button.VISIBLE
        }

        //Handles the False Button and brings out the Next Button
        falseButton.setOnClickListener {
            answerchecker(false)
            nextButton.visibility = Button.VISIBLE
        }

        //Handles the Next Button
        nextButton.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                //Displays the next question
                questionDisplay()
                nextButton.visibility = Button.GONE
                trueButton.visibility = Button.VISIBLE
                falseButton.visibility = Button.VISIBLE
            } else {
                //End of quiz
                //Here is a loop that will hold the total number of correct answers
                var finalScore = 0
                for (i in questions.indices) {
                    if (userAnswers[i] == answers[i])
                        finalScore++
                }

                //This takes the user to the Score Activity and the user's score to the next screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", finalScore)
                intent.putExtra("userAnswers", userAnswers)

                startActivity(intent)

                //Close the current Quiz Activity
                finish()

            }
        }
    }
}
