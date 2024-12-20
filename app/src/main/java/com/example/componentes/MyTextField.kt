package com.example.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyNameTextfield() {
    var state by remember { mutableStateOf(value = "") }

    Column {
        TextField(
            value = state, // nombre de la variable que guarda el estado
            onValueChange = { state = it },
            label = { Text("Enter your name") },
            placeholder = { Text("e.g., John Doe") }
        )

        Text(modifier = Modifier.padding(top = 32.dp), text = state)

    }
}

@Preview(showBackground = true)
@Composable
fun MyPassword() {
    var state by remember { mutableStateOf(value = "") }

    Column {
        TextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("Enter your password") },
            placeholder = { Text("...") },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            // si queremos que se introduzca una única línea
            singleLine = true
        )

        Text(modifier = Modifier.padding(top = 32.dp), text = state)

    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun MySearchTextField() {
    var state by rememberSaveable { mutableStateOf(value = "") }

    Column {
        TextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("Search for...") },
            placeholder = { Text("Whatever") },
            // icono. leadingicon te lo pone al principio, trailingicon te lo pone al final
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            // si queremos que se introduzca una única línea
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.purple_200),
                focusedTextColor = colorResource(id = R.color.white)
            )
        )

    }
}

