package com.revolhope.data.feature.user.repositoryimpl

import com.revolhope.data.common.BaseRepositoryImpl
import com.revolhope.domain.common.model.State
import com.revolhope.domain.feature.user.model.UserModel
import com.revolhope.domain.feature.user.repository.UserRepository

class UserRepositoryImpl : BaseRepositoryImpl(), UserRepository {

    override suspend fun registerUser(user: UserModel): State<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchUser(): State<UserModel> {
        TODO("Not yet implemented")
    }
}