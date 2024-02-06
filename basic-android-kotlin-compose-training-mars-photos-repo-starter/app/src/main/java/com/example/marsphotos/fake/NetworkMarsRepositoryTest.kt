package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import junit.framework.Assert.assertEquals
import org.junit.Test


@Test
fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
    runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())

    }