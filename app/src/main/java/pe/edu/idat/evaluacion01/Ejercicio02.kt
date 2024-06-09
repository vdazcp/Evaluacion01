package pe.edu.idat.evaluacion01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio02(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var numero1 by rememberSaveable {
            mutableStateOf("")
        }
        var numero2 by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Operaciones con 2 números",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = numero1,
                onValueChange = { numero1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text ="Ingrese el primer número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = numero2,
                onValueChange = { numero2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text ="Ingrese el segundo número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultado = calcularOperacion(numero1.toInt(), numero2.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun calcularOperacion(numero1: Int, numero2: Int): String {
    return when {
        numero1 == numero2 -> "Los números son iguales. Su multiplicación es ${numero1 * numero2}"
        numero1 > numero2 -> "El primer número es mayor. La resta es ${numero1 - numero2}"
        else -> "El segundo número es mayor. La suma es ${numero1 + numero2}"
    }
}