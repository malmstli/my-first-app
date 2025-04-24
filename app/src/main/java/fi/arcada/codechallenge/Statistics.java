package fi.arcada.codechallenge;

import java.util.ArrayList;

public class Statistics {


    public double calcMean(ArrayList<Double> values){

        double sum = 0;

        for (double value : values){
            sum += value;
        }

        return sum/values.size();
    }

    public ArrayList<Double> glideMeanValue(ArrayList<Double> values, int k) {
        ArrayList<Double> result = new ArrayList<>();

        if (values == null || values.size() < k || k <= 0) {
            return result;
        }

        double sum = 0.0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);

            if (i >= k - 1) {
                result.add(sum / k);
                sum -= values.get(i - k + 1);
            }
        }

        return result;
    }

}
