package com.example.layouttestapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // ive been said its better to define lateinit vars than redefine vals over and over again
    private lateinit var doneButton: Button
    private lateinit var editText: EditText
    private lateinit var imm :InputMethodManager
    private lateinit var nicknameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        editText = findViewById(R.id.nickname_edit)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        nicknameTextView = findViewById(R.id.nickname_text)

        doneButton.setOnClickListener {
            addNickname(it)
        }
        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // Values to get the Editable text and Edited text
        // getting the text from user
        nicknameTextView.text = editText.text
        // switching visibility
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        // hiding keyboard, which is staying onscreen by defaults

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        // Set the focus to the edit text.
        editText.requestFocus()

        imm.showSoftInput(editText, 0)
    }

}