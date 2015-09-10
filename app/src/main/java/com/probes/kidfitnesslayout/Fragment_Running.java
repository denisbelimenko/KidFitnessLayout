package com.probes.kidfitnesslayout;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Denis on 04.08.2015.
 */
public class Fragment_Running extends Fragment implements View.OnClickListener {

    Button results, charts;
    TextView textresults, textcharts;
    Running_Results running_results;
    Running_Charts running_charts;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_running, null);

        running_results = new Running_Results();
        running_charts = new Running_Charts();

        results = (Button) v.findViewById(R.id.btn_results);
        charts = (Button) v.findViewById(R.id.btn_charts);

        results.setBackground(getResources().getDrawable(R.drawable.runningresults));

        textresults = (TextView) v.findViewById(R.id.textresults);
        textcharts = (TextView) v.findViewById(R.id.textcharts);

        textresults.setTextColor(getResources().getColor(R.color.bg));

        results.setOnClickListener(this);
        charts.setOnClickListener(this);

        return v;

    }


    public void onClick(View v) {

        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (v.getId()) {

            case R.id.btn_results:

                ft.replace(R.id.fragRun, running_results);

                results.setBackground(getResources().getDrawable(R.drawable.runningresults));
                textresults.setTextColor(getResources().getColor(R.color.bg));
                textcharts.setTextColor(getResources().getColor(R.color.orange));
                charts.setBackground(getResources().getDrawable(R.drawable.runningchartsin));

                break;

            case R.id.btn_charts:

                ft.replace(R.id.fragRun, running_charts);

                charts.setBackground(getResources().getDrawable(R.drawable.runningcharts));
                textcharts.setTextColor(getResources().getColor(R.color.bg));
                textresults.setTextColor(getResources().getColor(R.color.orange));
                results.setBackground(getResources().getDrawable(R.drawable.runningresultsin));

                break;
        }
        ft.commit();
    }
}
