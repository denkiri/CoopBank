package com.example.coopbank.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coopbank.ui.theme.AppTheme
import com.example.coopbank.ui.theme.CoopBankTheme

@Composable
fun NormalButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color.Green
            )
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White // Set your desired text color here
            )
        }
    }
}

@Composable
fun SmallClickableWithIconAndText(
    modifier: Modifier = Modifier,
    iconVector: ImageVector = Icons.Outlined.QuestionMark,
    iconContentDescription: String = "",
    text: String = "",
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable {
            onClick.invoke()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = iconVector,
            contentDescription = iconContentDescription,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(start = AppTheme.dimens.paddingSmall),
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}