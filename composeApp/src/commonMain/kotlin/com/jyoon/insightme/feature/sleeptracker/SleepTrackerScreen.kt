package com.jyoon.insightme.feature.sleeptracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jyoon.core.compose.calculateSize

@Composable
fun SleepTrackerScreen(
    objectId: Int,
    navigateBack: () -> Unit
) {
    val size = calculateSize {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Detail Screen\nsadkfjslkdfjlskdf")
        }
    }

    Column(
        modifier = Modifier.height(size.value?.height ?: 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detail Screen")
        Text(text = "Object ID: $objectId")
        Text(text = "Object ID: $objectId")
        Button(
            onClick = navigateBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Go Back")
        }
    }
}
