package com.example.jetpack_component.work_manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.jetpack_component.R

class LocationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
//        Thread(Runnable{
//            for (x in 0..50) {
//                Log.d("TAG", "i am working")
//                Thread.sleep(2000)
//            }
//        }).start()
//        Log.d("TAG","i am working")
        return Result.success()
    }

    private fun showNotification(title: String, desc: String) {
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val noti_channalId = "Location"
        val noti_channalname = "Location_name"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channal = NotificationChannel(noti_channalId, noti_channalname, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channal)
        }
        val builder = NotificationCompat.Builder(applicationContext, noti_channalId)
            .setContentTitle(title)
            .setContentText(desc)
            .setSmallIcon(R.drawable.ic_cake_black_24dp)

        manager.notify(1, builder.build())
    }
}