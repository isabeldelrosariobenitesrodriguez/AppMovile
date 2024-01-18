package com.example.appmovile.data.remote

import android.util.Log
import com.example.appmovile.domain.repository.AuthRepository
import com.example.appmovile.util.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        return try {
            var isSuccessful: Boolean = false
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            isSuccessful
        } catch (e: Exception) {
            Log.d("test", e.toString())
            false
        }
    }
}