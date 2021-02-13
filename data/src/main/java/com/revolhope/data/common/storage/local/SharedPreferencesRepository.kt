package com.revolhope.data.common.storage.local

import com.revolhope.domain.feature.user.model.UserModel

interface SharedPreferencesRepository {

    suspend fun fetchUser(): UserModel?

    suspend fun insertUser(user: UserModel): Boolean

    suspend fun updateUser(user: UserModel): Boolean

    suspend fun deleteUser(id: String): Boolean

}