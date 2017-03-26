package pl.edu.pwr.lab1zimny.lab1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.calculate)
    Button calculate;
    @Bind(R.id.massInput)
    EditText massInput;
    @Bind(R.id.heightInput)
    EditText heightInput;
    @Bind(R.id.resultString)
    TextView resultString;
    @Bind(R.id.result)
    TextView result;
    @Bind(R.id.metrics)
    Switch metricsButton;
    ICountBMI BMICounter;
    String actualBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BMICounter = new CountBMIForKGM();

        metricsButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    BMICounter = isChecked? new CountBMIForLBIN() : new CountBMIForKGM();
            }
        });
    }

    @OnClick(R.id.calculate)
    public void submit(){
        closeSoftKeyboard();

        float res = 0;
        try {
            float mass = Float.parseFloat(massInput.getText().toString());
            float height = Float.parseFloat(heightInput.getText().toString());
            res = BMICounter.calculateBMI(mass,height);
            actualBMI = String.valueOf(res);
            resultString.setVisibility(View.VISIBLE);
            colorOfText(res,result);
            result.setText(actualBMI);
        }
        catch(IllegalArgumentException iae){
            resultString.setVisibility(View.VISIBLE);
            result.setTextColor(Color.BLACK);
            result.setText(R.string.wrongInput);
        }
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

    private void closeSoftKeyboard(){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}


