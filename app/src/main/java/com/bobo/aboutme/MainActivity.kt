package com.bobo.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var nicknameTextView: TextView
    private lateinit var doneButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        doneButton.setOnClickListener { addNickName(it) }

        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener { resetEditText(it) }

    }

    private fun addNickName(view: View) {
        editText = findViewById(R.id.nickname_edit)
        nicknameTextView = findViewById(R.id.nickname_text)
        val resetButton = findViewById<Button>(R.id.reset_button)

        nicknameTextView.text = editText.text

        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        resetButton.visibility = View.VISIBLE

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun resetEditText(view: View) {
        editText.visibility = View.VISIBLE
        editText.text.clear()
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        nicknameTextView.visibility = View.GONE
        nicknameTextView.text = ""
    }
}