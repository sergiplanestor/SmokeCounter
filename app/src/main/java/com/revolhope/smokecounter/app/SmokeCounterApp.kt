package com.revolhope.smokecounter.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.managers.ApplicationComponentManager

@HiltAndroidApp
class SmokeCounterApp : Application()