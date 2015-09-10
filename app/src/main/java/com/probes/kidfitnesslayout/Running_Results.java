package com.probes.kidfitnesslayout;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Denis on 05.08.2015.
 */
public class Running_Results extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_results, null);

        final TextView date_res = (TextView) v.findViewById(R.id.date_res);
        final Date currentDate = new Date();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        final String str = dateFormat.format(currentDate).toUpperCase();

        date_res.setText(str);
        date_res.setGravity(Gravity.CENTER);

        Button left_date_res = (Button) v.findViewById(R.id.left_date_res);
        Button right_date_res = (Button) v.findViewById(R.id.right_date_res);

        /*String text[] = {"TIME", "DISTANCE", "STEPS", "CALORIES"};
        int pics[] = new int[]{R.drawable.restime, R.drawable.resdistance, R.drawable.ressteps, R.drawable.rescalories};*/

        /*GridView gv = (GridView) v.findViewById(R.id.gv);

        gv.setNumColumns(2);
        gv.setColumnWidth(10);

        gv.setVerticalSpacing(5);
        gv.setHorizontalSpacing(5);*/

        /*List<HashMap<String, String>> List = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("pics", Integer.toString(pics[i]));
            hm.put("text", text[i]);
            List.add(hm);
        }*/

        /*String[] from = {"pics", "text"};
        int[] to = {R.id.img_adapter, R.id.text_adapter};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), List, R.layout.adapter_results, from, to);
        *//*gv.setAdapter(adapter);
        gv.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);*/


        left_date_res.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });
        right_date_res.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }


}
