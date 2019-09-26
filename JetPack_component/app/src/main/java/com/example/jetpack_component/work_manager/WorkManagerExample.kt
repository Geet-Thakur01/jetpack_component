package com.example.jetpack_component.work_manager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.jetpack_component.R
import kotlinx.android.synthetic.main.activity_work_manager_example.*

class WorkManagerExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_example)

        fun createConstraints() = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.UNMETERED)  // if connected to WIFI
            // other values(NOT_REQUIRED, CONNECTED, NOT_ROAMING, METERED)
            .setRequiresBatteryNotLow(true)                 // if the battery is not low
//            .setRequiresStorageNotLow(true)                 // if the storage is not low
            .build()
//
//
//        fun createWorkRequest(data: Data) =
//            PeriodicWorkRequestBuilder<LocationWorker>(2, TimeUnit.HOURS)  // setting period to 12 hours
//                // set input data for the work
//                .setInputData(data)
//                .setConstraints(createConstraints())
//                // setting a backoff on case the work needs to retry
//                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, PeriodicWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
//                .build()
//
//        fun startWork() {
//            // set the input data, it is like a Bundle
//            val work = createWorkRequest(Data.EMPTY)
//            /* enqueue a work, ExistingPeriodicWorkPolicy.KEEP means that if this work already existits, it will be kept
//            if the value is ExistingPeriodicWorkPolicy.REPLACE, then the work will be replaced */
//            WorkManager.getInstance().enqueueUniquePeriodicWork("Smart work", ExistingPeriodicWorkPolicy.KEEP, work)
//
//            // Observe the result od the work
//            WorkManager.getInstance().getWorkInfoByIdLiveData(work.id)
//                .observe(this, Observer { workInfo ->
//                    if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
//                        // FINISHED SUCCESSFULLY!
//                    }
//                })
//        }
//        send.setOnClickListener {
//            startWork()
//        }


        val workmanager = WorkManager.getInstance()
        val request = OneTimeWorkRequest.Builder(LocationWorker::class.java)
            .setConstraints(createConstraints())
            .build()
        send.setOnClickListener {
            workmanager.enqueue(request)
        }
        workmanager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            it.let {
                wotkifotext.append("\n")
                wotkifotext.append(it.state.toString())
            }
        })
    }
}
