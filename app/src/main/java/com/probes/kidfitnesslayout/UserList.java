package com.probes.kidfitnesslayout;

import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Denis on 28.07.2015.
 */
public class UserList extends ListFragment {

    String[] labels = new String[]{};

    ImageView iv;
    TextView tv;

   /* int[] colors = new int[]
            {
                    R.color.rose,
                    R.color.green,
                    R.color.grey,
                    R.color.violet
            };*/

    int[] frames_white = new int[]
            {
                    R.drawable.framewhiterose,
                    R.drawable.framewhitegreen,
                    R.drawable.framewhitegray,
                    R.drawable.framewhiteviolet
            };

    int[] frames_orange = new int[]
            {
                    R.drawable.frameorangerose,
                    R.drawable.frameorangegreen,
                    R.drawable.frameorangegray,
                    R.drawable.frameorangeviolet
            };


    String[] names = new String[]{"Michael", "Elizabeth", "Abby", "Jimmie"};
    int[] percents = new int[]{187, 52, 11, 99};
    int[] faces = new int[]
            {
                    R.drawable.f1,
                    R.drawable.f2,
                    R.drawable.f3,
                    R.drawable.f4,
            };

    int[] tituls = new int[]
            {
                    R.drawable.titul_rose,
                    R.drawable.titul_green,
                    R.drawable.titul_gray,
                    R.drawable.titul_violet,
            };

    int[] tituls_start = new int[]
            {
                    R.drawable.titul_rose_start,
                    R.drawable.titul_green_start,
                    R.drawable.titul_gray_start,
                    R.drawable.titul_violet_start
            };

    int sync_data = R.drawable.syncdata;
    List<HashMap<String, String>> aList;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.pb);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(50);*/
        labels = getResources().getStringArray(R.array.tituls);

        aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 4; i++) {

            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("white_frames",Integer.toString(frames_white[i]));
            hm.put("txt", names[i]);
            hm.put("percents", "Activity Level " + Integer.toString(percents[i]) + "%");
            hm.put("faces", Integer.toString(faces[i]));
            hm.put("tituls", Integer.toString(tituls_start[i]));
            hm.put("labels", labels[i]);
            hm.put("syncs", Integer.toString(sync_data));

            aList.add(hm);

        }

        String[] from = {"faces", "txt", "percents", "tituls", "labels", "syncs", "white_frames"};
        int[] to = {R.id.photo, R.id.name, R.id.actlevel, R.id.titul, R.id.label, R.id.synchr, R.id.overlay};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.user, from, to);
        setListAdapter(adapter);

        getListView().setSelector(R.drawable.listselector);

    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        Intent i = new Intent(getActivity().getApplicationContext(), Activity_CurrentUser.class);

            switch (position) {
                default:
                    i.putExtra("name", names[position]);
                    i.putExtra("percent", percents[position]);
                    i.putExtra("photo", faces[position]);
                    i.putExtra("titul", tituls[position]);
                    i.putExtra("label", labels[position]);
                    i.putExtra("frame", frames_orange[position]);
                    startActivity(i);
                    break;
        }
    }
}



