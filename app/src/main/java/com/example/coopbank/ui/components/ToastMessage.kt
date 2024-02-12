package com.example.coopbank.ui.components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import kotlinx.coroutines.delay

@Composable
fun Toast(message: String, durationMillis: Int = 2000) {
    LocalContext.current
    LocalLifecycleOwner.current
    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(durationMillis.toLong())
        isVisible = false
    }

    if (isVisible) {
       // androidx.compose.ui.platform.LocalContext.current.showToast(message)
    }

    DisposableEffect(Unit) {
        onDispose {
            isVisible = false
        }
    }
}