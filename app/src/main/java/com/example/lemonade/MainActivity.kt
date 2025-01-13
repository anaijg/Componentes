package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentes.R
import com.example.lemonade.ui.theme.ComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // aquí metemos la aplicación en sí
                    MyLemonadeApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyLemonadeApp(modifier: Modifier = Modifier) {
    MyLemonAppUI()
}

@Preview(showBackground = true)
@Composable
fun MyLemonAppUI() {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        // header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Lemonade",
                color = Color.Black,
                fontSize = 32.sp
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // ojo: recordar que hay que importar getValue y setValue, que a veces no se hace automáticamente
            var estado by remember { mutableStateOf(1) }
            // necesitamos otra variable para generar números aleatorios entre 2 y 4
            var exprimir by remember { mutableStateOf((2..4).random())}
            Button(onClick = {
                when (estado) {
                    1 -> {
                        estado = 2
                        // en el estado siguiente, no basta con dar una vez en el limón, tiene que ser un número aleatorio de veces
                        exprimir = (2..4).random()
                    }
                    2 -> {
                        // sólo pasamos a estado 3 cuando pulsamos el nº random de veces
                        exprimir--
                        if (exprimir == 0) {
                            estado = 3
                        }
                    }
                    3 -> estado = 4
                    4 -> estado = 1
                }
            }) {
                // aquí en vez de la imagen ponemos una llamada a la función
                showImagen(estado)
            }
            showText(estado)
        }
    }
}

@Composable
fun showImagen(estado: Int = 1) {
    val imagen = when (estado) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_restart
    }
    Image(
        painterResource(id = imagen),
        contentDescription = stringResource(R.string.lemon_tree)
    )
}

@Composable
fun showText(estado: Int = 1) {
    val texto = when (estado) {
        1 -> R.string.tap_lemon_tree
        2 -> R.string.keep_taping
        3 -> R.string.tap_lemonade
        4 -> R.string.tap_empty_glass
        else -> R.string.tap_empty_glass
    }
    Text(text = stringResource(id = texto))
}

