package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Double> list = new ArrayList<>();
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);
        list.add(5.5);

        calculate();

    }
    public void calculate() {

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Statistics stats = new Statistics();
                double mean = stats.calcMean(list);
                resultTextView.setText("Medelvärdet är: " + mean);
            }
        });

    }
    public class Statistics {
        public double calcMean(ArrayList<Double> dataset){
            double sum = 0;
            for (double num : dataset) {
                sum+= num;
            }
            return sum / dataset.size();
        }
    }
}