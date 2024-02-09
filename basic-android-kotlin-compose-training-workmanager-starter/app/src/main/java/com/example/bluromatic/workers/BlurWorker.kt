package com.example.bluromatic.workers
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.example.bluromatic.R
import kotlinx.coroutines.Dispatchers
import com.example.bluromatic.DELAY_TIME_MILLIS
import com.example.bluromatic.KEY_BLUR_LEVEL
import com.example.bluromatic.KEY_IMAGE_URI
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import android.net.Uri
import androidx.work.workDataOf


private const val TAG = "BlurWorker"

class BlurWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        val blurLevel = inputData.getInt(KEY_BLUR_LEVEL, 1)

        makeStatusNotification(
            applicationContext.resources.getString(R.string.blurring_image),
            applicationContext
        )
        return withContext(Dispatchers.IO) {
        //   val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())

            //return try {
            return@withContext try {

                delay(DELAY_TIME_MILLIS)

                require(!resourceUri.isNullOrBlank()) {
                    val errorMessage =
                        applicationContext.resources.getString(R.string.invalid_input_uri)
                    Log.e(TAG, errorMessage)
                    errorMessage
                }
                val resolver = applicationContext.contentResolver
                val picture = BitmapFactory.decodeStream(
                    resolver.openInputStream(Uri.parse(resourceUri))
                )
             //   val picture = BitmapFactory.decodeResource(
               //     applicationContext.resources,
                 //   R.drawable.android_cupcake
               // )



               // val output = blurBitmap(picture, 1)
                val output = blurBitmap(picture, blurLevel)

                // Write bitmap to a temp file
                val outputUri = writeBitmapToFile(applicationContext, output)

                //makeStatusNotification(
                //    "Output is $outputUri",
               //     applicationContext
               // )

                val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())

                Result.success(outputData)
            } catch (throwable: Throwable) {
                Log.e(
                    TAG,
                    applicationContext.resources.getString(R.string.error_applying_blur),
                    throwable
                )

                Result.failure()
            }


        }
    }
}