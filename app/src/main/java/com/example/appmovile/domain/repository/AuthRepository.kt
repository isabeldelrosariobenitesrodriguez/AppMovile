package com.example.appmovile.domain.repository

import com.example.appmovile.util.Resource

interface AuthRepository {

    suspend fun login(email: String, password: String): Boolean

}