package com.jyoon.insightme.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    navigateToDetails: (objectId: Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "List Screen")
        Button(
            onClick = {
                navigateToDetails(1)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Navigate to Detail Screen")
        }
    }
}
