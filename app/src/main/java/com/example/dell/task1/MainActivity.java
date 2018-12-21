package com.example.dell.task1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd,btnRetrieve,btnDelete;
    private static final String myPreference="MyPreference";
    private static final String myText="MyText";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.etInputText);
        btnAdd=findViewById(R.id.btnAdd);
        btnRetrieve=findViewById(R.id.btnRetrieve);
        btnDelete=findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(myPreference,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(myText,editText.getText().toString());
                editor.commit();
                editText.setText("");
                Toast.makeText(getApplicationContext(),"Success...",Toast.LENGTH_SHORT).show();
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(myPreference,Context.MODE_PRIVATE);
                if (sharedPreferences.contains(myText)){
                    editText.setText(sharedPreferences.getString(myText,""));
                }
                else
                    Toast.makeText(getApplicationContext(),"File Not Found...",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(myPreference,Context.MODE_PRIVATE);
                sharedPreferences.edit().remove(myText).commit();
            }
        });
    }
}
