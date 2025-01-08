package com.example.componentes.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentes.R

@Preview(showBackground = true)
@Composable
fun MyFirstText() {
    Text(
        text = stringResource(id = R.string.texto),
        textDecoration = TextDecoration.Underline,
        color = colorResource(id = R.color.teal_700),
        modifier = Modifier.padding(24.dp),
        fontWeight = FontWeight.ExtraBold
    )
}