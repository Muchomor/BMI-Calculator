package pl.edu.pwr.lab1zimny.lab1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText mass;
    EditText height;
    TextView resultString;
    TextView result;
    CountBMIForKGM BMICounter;
    boolean clicked = false;
    String actualBMI;
    TextView lastKnownBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mass = (EditText) findViewById(R.id.massInput);
        height = (EditText) findViewById(R.id.heightInput);
        resultString = (TextView) findViewById(R.id.resultString);
        result = (TextView) findViewById(R.id.result);
        BMICounter = new CountBMIForKGM();
        lastKnownBMI = (TextView) findViewById(R.id.yourLastKnownBMI);

        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                if(clicked){
                    lastKnownBMI.setText((getString(R.string.yourLastKnownBMI))+ " was: " + actualBMI);
                }
                clicked=true;

                float res = BMICounter.calculateBMI(Float.parseFloat(mass.getText().toString()),
                        Float.parseFloat(height.getText().toString()));
                actualBMI = String.valueOf(res);
                resultString.setVisibility(View.VISIBLE);
                colorOfText(res,result);
                result.setText(actualBMI);
            }
        });
    }

    private void colorOfText(float BMI, TextView t){
        if(BMI<=24.9){
            t.setTextColor(Color.GREEN);
        }
        else if(BMI<=29.9){
            t.setTextColor(Color.YELLOW);
        }
        else{
            t.setTextColor(Color.RED);
        }
    }

}


