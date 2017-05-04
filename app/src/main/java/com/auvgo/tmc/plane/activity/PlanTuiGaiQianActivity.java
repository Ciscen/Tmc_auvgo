package com.auvgo.tmc.plane.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.auvgo.tmc.R;

public class PlanTuiGaiQianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_tui_gai_qian);
        Intent intent = getIntent();
        String tuipiao = intent.getStringExtra("tuipiao");
        String gaiqian = intent.getStringExtra("gaiqian");
        TextView tui = (TextView) findViewById(R.id.tuipiao_tv);
        TextView gai = (TextView) findViewById(R.id.gaiqian_tv);
        tui.setText(tuipiao);
        gai.setText(gaiqian);
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
