package com.revolhope.data.common.storage.local

import android.content.SharedPreferences
import com.revolhope.domain.feature.user.model.UserModel
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    SharedPreferencesRepository {

    override suspend fun fetchUser(): UserModel? {
        TODO("Not yet implemented")
    }

    override suspend fun insertUser(user: UserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: UserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(id: String): Boolean {
        TODO("Not yet implemented")
    }
}