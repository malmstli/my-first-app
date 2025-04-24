package fi.arcada.codechallenge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class MainActivity extends AppCompatActivity {

    ArrayList<Double> values = new ArrayList<Double>();

    private TextView Count;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);

        Count = findViewById(R.id.Count);

        for (int i = 0; i<13; i++){
            double randomValue = Math.random();
            values.add(randomValue);
        }
    }
    public void buttonClickHandler(View view){calculate();}

    private void calculate(){
        Statistics meanCalc = new Statistics();

        int windowSize = 3;

        ArrayList<Double> temps = new ArrayList<>(Arrays.asList(17.5, 16.0, 16.5, 15.0, 17.5, 18.0, 15.5, 20.0, 19.5, 16.0));
        ArrayList<Double> result = meanCalc.glideMeanValue(temps, windowSize);
        Count.setText("SMA: "+result);
    }


}