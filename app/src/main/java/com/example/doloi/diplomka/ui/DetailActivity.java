package com.example.doloi.diplomka.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.doloi.diplomka.R;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private TextView mTitle;
    private TextView mSubtitle;

    public static Intent newInstance(@NonNull Context context, @NonNull String title, @NonNull String subtitle){
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(EXTRA_QUOTE, title);
        i.putExtra(EXTRA_ATTR, subtitle);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView) findViewById(R.id.lbl_quote_text);
        mSubtitle = (TextView) findViewById(R.id.lbl_quote_attribution);

        String title = getIntent().getStringExtra(EXTRA_QUOTE);
        String subtitle = getIntent().getStringExtra(EXTRA_ATTR);
        if(title != null && subtitle != null){
            mTitle.setText(title);
            mSubtitle.setText(subtitle);
        }
    }

    public void jumpToLocation(View view){
        Intent intent = new Intent(this, GeoActivity.class);
        startActivity(intent);
    }
}
