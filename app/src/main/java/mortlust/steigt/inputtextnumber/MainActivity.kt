package mortlust.steigt.inputtextnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mortlust.steigt.inputtextnumber.databinding.ActivityMainBinding
import android.widget.EditText
import java.lang.Exception
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var B: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        B = ActivityMainBinding.inflate(layoutInflater)
        setContentView(B.root)

        B.buOutput.setOnClickListener {
            val name = B.etName.text.toString()
            val pw = B.etPassword.text.toString()
            B.tvOutput.text = "$name / $pw"
        }

        B.buTotal.setOnClickListener {
            val total = round((wert(B.etNumberOne)
                    + wert(B.etNumberTwo)) * 1e6) / 1e6
            B.tvOutputSum.text = "Total: $total"
        }
    }

    private fun wert(et: EditText): Double {
        return try {
            et.text.toString().toDouble()
        } catch (ex: Exception) {
            0.0
        }
    }

}