package com.bobo.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bobo.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Mark")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener { addNickName() }
        binding.resetButton.setOnClickListener { resetEditText() }

    }

    private fun addNickName() {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            resetButton.visibility = View.VISIBLE


            // Hide the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(doneButton.windowToken, 0)
        }
    }

    private fun resetEditText() {
        binding.apply {
            nicknameEdit.text.clear()
            nicknameEdit.visibility = View.VISIBLE

            resetButton.visibility = View.GONE
            doneButton.visibility = View.VISIBLE

            nicknameText.visibility = View.GONE
            nicknameText.text = ""
        }
    }
}