package com.example.marsphotos.ui.screens

import com.example.marsphotos.fake.FakeDataSource
import com.example.marsphotos.fake.FakeNetworkMarsPhotosRepository
import junit.framework.Assert.assertEquals
import org.junit.Test

@Test
fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
    runTest {
        val marsViewModel = MarsViewModel(
            marsPhotosRepository = FakeNetworkMarsPhotosRepository()
        )
        assertEquals(
            MarsUiState.Success("Success: ${FakeDataSource.photosList.size} Mars " +
                    "photos retrieved"),
            marsViewModel.marsUiState
        )
    }

fun runTest(function: () -> Unit): Any {
    TODO("Not yet implemented")
}
