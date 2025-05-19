package za.ac.iie.assignment2tyricsinghst10479817

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<ViewGroup>(R.id.main)
        val startButton = findViewById<Button>(R.id.btnstart)
        val instructionsText = findViewById<TextView>(R.id.txtinstructions)

        // Text to guide the user on how to use the quiz
        instructionsText.text =  "Press Start Quiz button to begin quiz. \nYou will have two options: True and False. \nThen press Next to continue to next question."

        startButton.setBackgroundColor(Color.MAGENTA)//Colour of the button

        //The button that takes you to the next screen
        startButton.setOnClickListener {
            //Display a Toast message to indicate that the quiz is starting
            Toast.makeText(this@MainActivity, "Quiz is Starting", Toast.LENGTH_LONG).show()

            //Able to move to the QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)

        }

        //Background of the Start Screen
        mainLayout.setBackgroundResource(R.drawable.start_screen)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}