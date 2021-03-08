package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

public class UserInstructionActivity extends AppCompatActivity {
    TextView txtUserInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_instruction);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("User Instructions");
        initViews();
        setData();
    }

    private void setData() {
//        txtUserInstructions.setText(HtmlCompat.fromHtml(getResources().getString(R.string.user_instructions),HtmlCompat.FROM_HTML_MODE_COMPACT));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtUserInstructions.setText(Html.fromHtml(getResources().getString(R.string.user_instructions),Html.FROM_HTML_MODE_COMPACT));
        }else{
            txtUserInstructions.setText(Html.fromHtml(getResources().getString(R.string.user_instructions)));
        }
    }

    private void initViews() {
        txtUserInstructions=findViewById(R.id.txtUserInstructions);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}