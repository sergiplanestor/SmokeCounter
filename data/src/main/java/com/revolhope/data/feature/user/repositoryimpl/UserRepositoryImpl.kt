package com.revolhope.data.feature.user.repositoryimpl

import com.google.gson.Gson
import com.revolhope.data.common.BaseRepositoryImpl
import com.revolhope.data.common.storage.local.SharedPreferencesRepository
import com.revolhope.domain.common.model.State
import com.revolhope.domain.feature.user.model.UserModel
import com.revolhope.domain.feature.user.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val preferencesRepository: SharedPreferencesRepository
) : BaseRepositoryImpl(), UserRepository {

    override suspend fun registerUser(user: UserModel): State<Boolean> =
        statefulCall {
            preferencesRepository.insertUser(user)
        }

    override suspend fun fetchUser(): State<UserModel?> =
        statefulCall {
            preferencesRepository.fetchUser()
        }
}