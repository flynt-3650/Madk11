// app/src/main/java/com/example/madk11/MyWorker.kt
package com.example.madk11

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        return Result.success()
    }
}
