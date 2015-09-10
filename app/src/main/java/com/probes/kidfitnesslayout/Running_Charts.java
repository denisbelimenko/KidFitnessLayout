package com.probes.kidfitnesslayout;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Denis on 05.08.2015.
 */
public class Running_Charts extends Fragment implements View.OnClickListener {


    Button button_time, button_distance, button_steps, button_calories;
    TextView tv_time, tv_distance, tv_steps, tv_calories;
    ImageView img_time, img_distance, img_steps, img_calories;
    private BarChart mChart;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_charts, null);

        final TextView date_charts = (TextView) v.findViewById(R.id.date_charts);
        final Date currentDate = new Date();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM, yyyy", Locale.ENGLISH);
        final String str = dateFormat.format(currentDate).toUpperCase();

        date_charts.setText(str);
        date_charts.setGravity(Gravity.CENTER);

        Button left_date_charts = (Button) v.findViewById(R.id.left_date_charts);
        Button right_date_charts = (Button) v.findViewById(R.id.right_date_charts);

        left_date_charts.setOnClickListener(this);
        right_date_charts.setOnClickListener(this);

        mChart = (BarChart) v.findViewById(R.id.chartie);

        mChart.setDescription("");
        mChart.setMaxVisibleValueCount(1);
        mChart.setPinchZoom(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);

        XAxis xAxis = mChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGridColor(getResources().getColor(R.color.black));
        xAxis.setSpaceBetweenLabels(0);
        xAxis.setDrawGridLines(true);
        xAxis.isEnabled();
        xAxis.setAxisLineWidth(1);
        xAxis.setAxisLineColor(getResources().getColor(R.color.black));
        xAxis.setDrawLimitLinesBehindData(true);

        YAxis yAxisR = mChart.getAxisRight();

        yAxisR.setEnabled(false);

        YAxis yAxisL = mChart.getAxisLeft();

        yAxisL.setDrawGridLines(true);
        yAxisL.isEnabled();
        yAxisL.setAxisLineWidth(1);
        yAxisL.setAxisLineColor(getResources().getColor(R.color.black));

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < 10 + 1; i++) {
            float mult = 10000;
            float val1 = (float) (Math.random() * mult);
            yVals1.add(new BarEntry((int) val1, i));
        }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < 30; i++) {
            if ((i+1) % 7 == 0) xVals.add(i + 1 + "");
            else xVals.add("");
        }

        BarDataSet set1 = new BarDataSet(yVals1, "Data Set");
        set1.setColor(getResources().getColor(R.color.red));
        set1.setDrawValues(false);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);

        mChart.setData(data);
        mChart.invalidate();
        mChart.animateY(2500);
        mChart.getLegend().setEnabled(false);

        tv_time = (TextView) v.findViewById(R.id.tvtime);
        tv_distance = (TextView) v.findViewById(R.id.tvdistance);
        tv_steps = (TextView) v.findViewById(R.id.tvsteps);
        tv_calories = (TextView) v.findViewById(R.id.tvcalories);

        button_time = (Button) v.findViewById(R.id.buttontime);
        button_distance = (Button) v.findViewById(R.id.buttondistance);
        button_steps = (Button) v.findViewById(R.id.buttonsteps);
        button_calories = (Button) v.findViewById(R.id.buttoncalories);

        button_time.setOnClickListener(this);
        button_distance.setOnClickListener(this);
        button_steps.setOnClickListener(this);
        button_calories.setOnClickListener(this);

        img_time = (ImageView) v.findViewById(R.id.imgtime);
        img_distance = (ImageView) v.findViewById(R.id.imgdistance);
        img_steps = (ImageView) v.findViewById(R.id.imgsteps);
        img_calories = (ImageView) v.findViewById(R.id.imgcalories);

        return v;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.left_date_charts:

                break;

            case R.id.right_date_charts:

                break;

            case R.id.buttontime:

                button_time.setBackground(getResources().getDrawable(R.drawable.buttonchartsact));
                button_distance.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_steps.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_calories.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));

                tv_time.setTextColor(getResources().getColor(R.color.bg));
                tv_distance.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_steps.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_calories.setTextColor(getResources().getColor(R.color.dark_gray));

                img_time.setImageDrawable(getResources().getDrawable(R.drawable.restimeact));
                img_distance.setImageDrawable(getResources().getDrawable(R.drawable.resdistance));
                img_steps.setImageDrawable(getResources().getDrawable(R.drawable.ressteps));
                img_calories.setImageDrawable(getResources().getDrawable(R.drawable.rescalories));

                break;

            case R.id.buttondistance:

                button_time.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_distance.setBackground(getResources().getDrawable(R.drawable.buttonchartsact));
                button_steps.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_calories.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));

                tv_time.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_distance.setTextColor(getResources().getColor(R.color.bg));
                tv_steps.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_calories.setTextColor(getResources().getColor(R.color.dark_gray));

                img_time.setImageDrawable(getResources().getDrawable(R.drawable.restime));
                img_distance.setImageDrawable(getResources().getDrawable(R.drawable.resdistanceact));
                img_steps.setImageDrawable(getResources().getDrawable(R.drawable.ressteps));
                img_calories.setImageDrawable(getResources().getDrawable(R.drawable.rescalories));

                break;

            case R.id.buttonsteps:

                button_time.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_distance.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_steps.setBackground(getResources().getDrawable(R.drawable.buttonchartsact));
                button_calories.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));

                tv_time.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_distance.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_steps.setTextColor(getResources().getColor(R.color.bg));
                tv_calories.setTextColor(getResources().getColor(R.color.dark_gray));

                img_time.setImageDrawable(getResources().getDrawable(R.drawable.restime));
                img_distance.setImageDrawable(getResources().getDrawable(R.drawable.resdistance));
                img_steps.setImageDrawable(getResources().getDrawable(R.drawable.resstepsact));
                img_calories.setImageDrawable(getResources().getDrawable(R.drawable.rescalories));

                break;

            case R.id.buttoncalories:

                button_time.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_distance.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_steps.setBackground(getResources().getDrawable(R.drawable.buttonchartsnon));
                button_calories.setBackground(getResources().getDrawable(R.drawable.buttonchartsact));

                tv_time.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_distance.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_steps.setTextColor(getResources().getColor(R.color.dark_gray));
                tv_calories.setTextColor(getResources().getColor(R.color.bg));

                img_time.setImageDrawable(getResources().getDrawable(R.drawable.restime));
                img_distance.setImageDrawable(getResources().getDrawable(R.drawable.resdistance));
                img_steps.setImageDrawable(getResources().getDrawable(R.drawable.ressteps));
                img_calories.setImageDrawable(getResources().getDrawable(R.drawable.rescaloriesact));

                break;
        }
    }
}
