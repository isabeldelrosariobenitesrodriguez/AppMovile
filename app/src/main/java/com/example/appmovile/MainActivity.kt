package com.example.appmovile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.appmovile.presentation.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  supportFragmentManager.commit {
            replace<LoginFragment>(R.id.fragment_container_login)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }*/
    }
}