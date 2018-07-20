package com.myapp.anit.learnandroiddevelopment.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class TextActivity extends AppCompatActivity {
    private LinearLayout linearLayoutRoot;
    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLinearLayoutView();
        setContentView(linearLayoutRoot);

        initText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edt = editText.getText().toString();
                if(!edt.equals("")){
                    Toast.makeText(TextActivity.this, "Welcome to android: "+edt, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TextActivity.this, "text not null", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        Intent intent = getIntent();
        String text=intent.getStringExtra("tv");
        switch (text){
            case "TextView":
                setTextView();

                break;
            case "EditText":
                setEditText();
                break;
        }
    }

    private void initText() {
        button = new Button(this);
        editText = new EditText(this);
        textView = new TextView(this);
    }

    private void createLinearLayoutView() {
        linearLayoutRoot = new LinearLayout(this);
        linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
    }
    private void setTextView() {
        textView.setText("This is a TextView");
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        linearLayoutRoot.addView(textView);
    }
    private void setEditText() {
        editText.setHint("Write text here");
        button.setText("Show editText");
        linearLayoutRoot.addView(editText);
        linearLayoutRoot.addView(button);
    }
}
