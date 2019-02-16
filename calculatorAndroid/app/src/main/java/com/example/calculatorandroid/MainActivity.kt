package com.example.calculatorandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var button_plus: Button
    private lateinit var button_min: Button
    private lateinit var button_multiply: Button
    private lateinit var button_div: Button
    private lateinit var button_f: Button
    private lateinit var button_c: Button
    private lateinit var button_point: Button
    private lateinit var button_equals: Button
    private lateinit var editText: EditText

    private var num1 = 0;
    private var num2 = 0;
    private var operation : Operations = Operations.SUM;
    var numbers: MutableList<Int> = mutableListOf<Int>()
    var isnum2 : Boolean = false

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button0 = findViewById(R.id.button0)

        button_plus = findViewById(R.id.button_mas)
        button_min = findViewById(R.id.button_menos)
        button_multiply = findViewById(R.id.button_por)
        button_div = findViewById(R.id.button_div)
        button_f = findViewById(R.id.button_f)
        button_c = findViewById(R.id.button_c)
        button_point = findViewById(R.id.button_point)
        button_equals = findViewById(R.id.button_equal)
        editText = findViewById(R.id.text)


        //operaciones
        button_equals.setOnClickListener{

            editText.text = this.operate(num1,num2,operation).toString().toEditable()
            isnum2 = false;
        }

        button_plus.setOnClickListener{
            operation = Operations.SUM
            num1 = editText.text.toString().toInt()
            editText.text = "${editText.text.toString()} +".toEditable()
            isnum2 = true;

        }
        button_min.setOnClickListener{
            operation = Operations.REST
            num1 = editText.text.toString().toInt()
            editText.text = "${editText.text.toString()} -".toEditable()
            isnum2 = true;
        }

        button_div.setOnClickListener{
            operation = Operations.DIV
            num1 = editText.text.toString().toInt()
            editText.text = "${editText.text.toString()} /".toEditable()
            isnum2 = true;
        }

        button_multiply.setOnClickListener{
            operation = Operations.MULT
            num1 = editText.text.toString().toInt()
            editText.text = "${editText.text.toString()} *".toEditable()
            isnum2 = true;
        }




        //numeros
        button1.setOnClickListener {
            if (isnum2) num2 = 1 else num1 = 1
            editText.text = "${editText.text.toString()} 1".toEditable()
        }
        button2.setOnClickListener {
            if (isnum2) num2 = 2 else num1 = 2
            editText.text = "${editText.text.toString()} 2".toEditable()
        }
        button3.setOnClickListener {
            if (isnum2) num2 = 3 else num1 = 3
            editText.text = "${editText.text.toString()} 3".toEditable()
        }
        button4.setOnClickListener {
            if (isnum2) num2 = 4 else num1 = 4
            editText.text = "${editText.text.toString()} 4".toEditable()
        }
        button5.setOnClickListener {
            if (isnum2) num2 = 5 else num1 = 5
            editText.text = "${editText.text.toString()} 5".toEditable()
        }
        button6.setOnClickListener {
            if (isnum2) num2 = 6 else num1 = 6
            editText.text = "${editText.text.toString()} 6".toEditable()
        }
        button7.setOnClickListener {
            if (isnum2) num2 = 7 else num1 = 7
            editText.text = "${editText.text.toString()} 7".toEditable()
        }
        button8.setOnClickListener {
            if (isnum2) num2 = 8 else num1 = 8
            editText.text = "${editText.text.toString()} 8".toEditable()
        }
        button9.setOnClickListener {
            if (isnum2) num2 = 9 else num1 = 9
            editText.text = "${editText.text.toString()} 9".toEditable()
        }
        button0.setOnClickListener {
            if (isnum2) num2 = 0 else num1 = 0
            editText.text = "${editText.text.toString()} 0".toEditable()
        }


    }






    fun operate(a: Int, b: Int, o: Operations): Int {

        when (o) {
            Operations.SUM -> return a + b
            Operations.REST -> return a - b
            Operations.MULT -> return a * b
            Operations.DIV -> return a / b
            Operations.FUNC -> return customFunction(a, b)
            else -> return 0
        }
        return 0

    }

    fun customFunction(a: Int, b: Int): Int = Math.max(a, b)

    enum class Operations {

        SUM, REST, MULT, DIV, FUNC
    }
}
