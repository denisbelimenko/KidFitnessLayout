package com.probes.kidfitnesslayout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Denis on 30.07.2015.
 */
public class Activity_CurrentUser extends Activity implements View.OnClickListener {

    Fragment_Running f_running;
    Fragment_Walking f_walking;
    Fragment_Jumping f_jumping;
    FragmentTransaction trans;
    Running_Results running_results;
    Running_Charts running_charts;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_layout);
        f_running = new Fragment_Running();
        f_walking = new Fragment_Walking();
        f_jumping = new Fragment_Jumping();
        running_results = new Running_Results();

        LayoutInflater layoutInflater = getLayoutInflater();

        LinearLayout l = (LinearLayout) findViewById(R.id.user_lin);
        View child = getLayoutInflater().inflate(R.layout.current_user, null);
        l.addView(child);

        LinearLayout bot = (LinearLayout) findViewById(R.id.user_activity_layout);
        View child_bot = layoutInflater.inflate(R.layout.bottom_linear, null);
        bot.addView(child_bot);

        Button back_user_button = (Button) findViewById(R.id.back_user_but);
        back_user_button.setOnClickListener(this);


        Button wButton = (Button) findViewById(R.id.button_walking);
        /*wButton.getLayoutParams().width = width / 3;
        wButton.getLayoutParams().height = height / 12;*/
        Button rButton = (Button) findViewById(R.id.button_running);
        /*rButton.getLayoutParams().width = width / 3;
        rButton.getLayoutParams().height = height / 12;*/
        Button jButton = (Button) findViewById(R.id.button_jumping);
        /*jButton.getLayoutParams().width = width / 3;
        jButton.getLayoutParams().height = height / 12;*/

        wButton.setOnClickListener(this);
        rButton.setOnClickListener(this);
        jButton.setOnClickListener(this);


        TextView tview = (TextView) findViewById(R.id.cur_name);
        ImageView iview = (ImageView) findViewById(R.id.cur_face);
        ImageView image_tit = (ImageView) findViewById(R.id.imagetitul);
        ImageView image_overlay = (ImageView) findViewById(R.id.overlay_user);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        tview.setText(name);

        int photo = intent.getIntExtra("photo", R.drawable.f2);
        iview.setImageResource(photo);

        int activ_level = intent.getIntExtra("percent", 0);
        TextView activlevel = (TextView) findViewById(R.id.activlevel);
        activlevel.setText("Activity Level " + activ_level + "%");

        String label_str = intent.getStringExtra("label");
        TextView tv_label = (TextView) findViewById(R.id.textlabel);
        tv_label.setText(label_str);

        int img_titul = intent.getIntExtra("titul", R.drawable.titul_green);
        image_tit.setImageResource(img_titul);

        int img_overlay = getIntent().getIntExtra("frame", R.drawable.frameorangerose);
        image_overlay.setImageResource(img_overlay);
    }

    public void onClick(View v) {

        trans = getFragmentManager().beginTransaction();
        switch (v.getId()) {

            case R.id.back_user_but:

                finish();
                break;

            case R.id.button_running:

                trans.replace(R.id.fragCont, f_running);
                trans.add(R.id.fragRun, running_results);

                TextView tr = (TextView) findViewById(R.id.text_running);
                TextView tw = (TextView) findViewById(R.id.text_walking);
                TextView tj = (TextView) findViewById(R.id.text_jumping);

                tr.setTextAppearance(getApplicationContext(), R.style.TEXT_RUNNING_ACT);
                tw.setTextAppearance(getApplicationContext(), R.style.TEXT_WALKING);
                tj.setTextAppearance(getApplicationContext(), R.style.TEXT_JUMPING);

                Button r = (Button) findViewById(R.id.button_running);
                Button w = (Button) findViewById(R.id.button_walking);
                Button j = (Button) findViewById(R.id.button_jumping);

                r.setBackground(getResources().getDrawable(R.drawable.runningselectedstate));
                w.setBackground(null);
                j.setBackground(null);

                ImageView ir = (ImageView) findViewById(R.id.image_running);
                ImageView iw = (ImageView) findViewById(R.id.image_walking);
                ImageView ij = (ImageView) findViewById(R.id.image_jumping);

                ir.setImageDrawable(getResources().getDrawable(R.drawable.runningout));
                iw.setImageDrawable(getResources().getDrawable(R.drawable.walkingin));
                ij.setImageDrawable(getResources().getDrawable(R.drawable.jumpingguy));

                break;

            case R.id.button_walking:

                trans.replace(R.id.fragCont, f_walking);
                trans.remove(running_results);

                tw = (TextView) findViewById(R.id.text_walking);
                tr = (TextView) findViewById(R.id.text_running);
                tj = (TextView) findViewById(R.id.text_jumping);

                tw.setTextAppearance(getApplicationContext(), R.style.TEXT_WALKING_ACT);
                tr.setTextAppearance(getApplicationContext(), R.style.TEXT_RUNNING);
                tj.setTextAppearance(getApplicationContext(), R.style.TEXT_JUMPING);

                r = (Button) findViewById(R.id.button_running);
                w = (Button) findViewById(R.id.button_walking);
                j = (Button) findViewById(R.id.button_jumping);

                w.setBackground(getResources().getDrawable(R.drawable.walkingselectedstate));
                r.setBackground(null);
                j.setBackground(null);

                iw = (ImageView) findViewById(R.id.image_walking);
                ir = (ImageView) findViewById(R.id.image_running);
                ij = (ImageView) findViewById(R.id.image_jumping);

                iw.setImageDrawable(getResources().getDrawable(R.drawable.walkingguyact));
                ir.setImageDrawable(getResources().getDrawable(R.drawable.runningin));
                ij.setImageDrawable(getResources().getDrawable(R.drawable.jumpingguy));

                break;

            case R.id.button_jumping:

                trans.replace(R.id.fragCont, f_jumping);
                trans.remove(running_results);

                tj = (TextView) findViewById(R.id.text_jumping);
                tw = (TextView) findViewById(R.id.text_walking);
                tr = (TextView) findViewById(R.id.text_running);

                tj.setTextAppearance(getApplicationContext(), R.style.TEXT_JUMPING_ACT);
                tw.setTextAppearance(getApplicationContext(), R.style.TEXT_WALKING);
                tr.setTextAppearance(getApplicationContext(), R.style.TEXT_RUNNING);

                r = (Button) findViewById(R.id.button_running);
                w = (Button) findViewById(R.id.button_walking);
                j = (Button) findViewById(R.id.button_jumping);

                j.setBackground(getResources().getDrawable(R.drawable.jumpingselectedstate));
                r.setBackground(null);
                w.setBackground(null);

                ij = (ImageView) findViewById(R.id.image_jumping);
                ir = (ImageView) findViewById(R.id.image_running);
                iw = (ImageView) findViewById(R.id.image_walking);

                ir.setImageDrawable(getResources().getDrawable(R.drawable.runningin));
                iw.setImageDrawable(getResources().getDrawable(R.drawable.walkingin));
                ij.setImageDrawable(getResources().getDrawable(R.drawable.jumpingguyact));

                break;
        }
        trans.commit();
    }
}
