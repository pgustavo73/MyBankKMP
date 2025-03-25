package com.pgustavo.mybank.bank.presentation.bank_login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mybank.composeapp.generated.resources.Res
import mybank.composeapp.generated.resources.alert
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
fun MyBottomSheet(
    showSheet: Boolean,
    onDismiss: () -> Unit
) {
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.alert),
                    contentDescription = null,
                )
                Spacer(Modifier.height(16.dp))
                Text("cpf  or password invalid", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Button(onClick = onDismiss) {
                    Text("Try Again")
                }
            }
        }
    }
}
