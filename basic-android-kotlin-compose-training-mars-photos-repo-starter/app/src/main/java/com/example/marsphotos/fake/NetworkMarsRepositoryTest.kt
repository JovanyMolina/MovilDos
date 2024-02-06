package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.ui.screens.runTest
import junit.framework.Assert.assertEquals
import org.junit.Test


@Test
fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
    runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
     //   assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())

    }