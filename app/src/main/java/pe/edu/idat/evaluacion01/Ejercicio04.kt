package pe.edu.idat.evaluacion01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio04(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Suma de los digitos comprendidos desde el 23 Y 99",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            Button(onClick = {
                resultado = calcularSumaDigitos()
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

fun calcularSumaDigitos(): String {
    var sumaTotal = 0
    for (numero in 23..99) {
        val sumaDigitos = numero.toString().sumBy { it.toString().toInt() }
        sumaTotal += sumaDigitos
    }
    return "La suma de los digitos comprendidos desde 23 y 99 es: $sumaTotal"
}
