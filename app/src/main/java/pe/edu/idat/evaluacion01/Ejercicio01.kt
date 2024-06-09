package pe.edu.idat.evaluacion01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun Ejercicio01(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var vehiculo by rememberSaveable {
            mutableStateOf("")
        }
        var alcohol by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Control de Alcoholemia",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = vehiculo,
                onValueChange = { vehiculo = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Tipo de Vehículo")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            MySpace(16)
            OutlinedTextField(value = alcohol,
                onValueChange = { alcohol = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Alcohol consumido")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultado = verificarAlcoholemia(alcohol.toDouble(), vehiculo)
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Verificar")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray))
        }
    }
}

@Composable
fun MySpace(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun verificarAlcoholemia(alcohol: Double, vehiculo: String): String {
    val tasaMaxima = when (vehiculo.toUpperCase()) {
        "C", "A", "M" -> 0.3
        "T" -> 0.5
        else -> 0.0
    }
    return if (alcohol > tasaMaxima) {
        "$alcohol - Positivo"
    } else {
        "$alcohol - Negativo"
    }
}