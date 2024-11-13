package ro.pub.cs.systems.eim.practicaltest01var06

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.pub.cs.systems.eim.practicaltest01var06.ui.theme.PracticalTest01Var06Theme
import kotlin.random.Random

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_practical_test01_var06_main)
//
//        val playButton = findViewById<Button>(R.id.play_button)
//        playButton.setOnClickListener {
//            showPlayDialog()
//        }
//    }
//
//    private fun showPlayDialog() {
//        val dialogBuilder = AlertDialog.Builder(this)
//        dialogBuilder.setTitle("Rezultatul Play")
//        dialogBuilder.setMessage("A fost apăsat butonul Play!")
//
//
//        dialogBuilder.setPositiveButton("OK") { dialog, _ ->
//            dialog.dismiss()
//        }
//
//        // Afișăm dialogul
//        val alertDialog = dialogBuilder.create()
//        alertDialog.show()
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_main)

        // Referințe către EditText-uri și CheckBox-uri
        val editText1 = findViewById<EditText>(R.id.numar1)
        val editText2 = findViewById<EditText>(R.id.numar2)
        val editText3 = findViewById<EditText>(R.id.numar3)

        val checkBox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkbox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkbox3)

        // Butonul "Play"
        val playButton = findViewById<Button>(R.id.play_button)
        playButton.setOnClickListener {
            // Generăm valori aleatoare pentru cele trei EditText-uri
            val randomValue1 = generateRandomValue()
            val randomValue2 = generateRandomValue()
            val randomValue3 = generateRandomValue()

            // Suprascriem valorile doar dacă checkbox-ul nu este bifat
            if (!checkBox1.isChecked) {
                editText1.setText(randomValue1)
            }
            if (!checkBox2.isChecked) {
                editText2.setText(randomValue2)
            }
            if (!checkBox3.isChecked) {
                editText3.setText(randomValue3)
            }

            // Afișăm valorile generate într-un Toast
            val toastMessage = "Numere generate: $randomValue1, $randomValue2, $randomValue3"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    // Funcție care generează o valoare aleatoare dintre "1", "2", "3" sau "*"
    private fun generateRandomValue(): String {
        val options = listOf("1", "2", "3", "*")
        return options[Random.nextInt(options.size)]
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalTest01Var06Theme {
        Greeting("Android")
    }
}