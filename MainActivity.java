package com.example.barcmp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart=findViewById(R.id.barChart);
        BarDataSet barDataSet1= new BarDataSet(barEntries1(),"SOLVED");
        barDataSet1.setColor(Color.GREEN);
        BarDataSet barDataSet2= new BarDataSet(barEntries2(),"UNSOLVED");
        barDataSet1.setColor(Color.RED);
        BarData data=new BarData(barDataSet1,barDataSet2);
        barChart.setData(data);

        String[] type = new String[]{"Fever","Cough","Ache","Cramp","Fracture","Other1"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(type));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(4);

        float barSpace = 0.008f;
        float groupSpace= 0.80f;
        data.setBarWidth(0.10f);

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*6);
        barChart.getAxisLeft().setAxisMinimum(0);

        barChart.groupBars(0,groupSpace,barSpace);
        barChart.animateY(2000);
        barChart.invalidate();



    }
    private ArrayList<BarEntry> barEntries1(){
        ArrayList<BarEntry> barEntries1= new ArrayList<>();
        barEntries1.add(new BarEntry(1,2000));
        barEntries1.add(new BarEntry(2,791));
        barEntries1.add(new BarEntry(3,630));
        barEntries1.add(new BarEntry(4,458));
        barEntries1.add(new BarEntry(5,2724));
        barEntries1.add(new BarEntry(6,500));
        barEntries1.add(new BarEntry(7,2173));


        return barEntries1;
    }
    private ArrayList<BarEntry> barEntries2(){
        ArrayList<BarEntry> barEntries2= new ArrayList<>();
        barEntries2.add(new BarEntry(1,900));
        barEntries2.add(new BarEntry(2,631));
        barEntries2.add(new BarEntry(3,1040));
        barEntries2.add(new BarEntry(4,382));
        barEntries2.add(new BarEntry(5,2614));
        barEntries2.add(new BarEntry(6,5000));
        barEntries2.add(new BarEntry(7,1173));


        return barEntries2;
    }
}
