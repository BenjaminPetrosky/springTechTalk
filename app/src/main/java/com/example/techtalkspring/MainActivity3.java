package com.example.techtalkspring;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Switch sUpdateRole;
    private boolean teacher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String messageName = intent.getStringExtra(MainActivity2.EXTRA_NAME);
        Boolean messageIsTeacher;
        messageIsTeacher = intent.getBooleanExtra("ROLE", true);

        // set from info carried over from activity2
        TextView textViewName = findViewById(R.id.tvName);
        TextView textViewRole = findViewById(R.id.tvRole);
        if(messageIsTeacher){
            textViewRole.setText("Is a teacher.");
        }else{
            textViewRole.setText("Is a student.");
        }
        textViewName.setText(messageName);

        //update within activity3
        sUpdateRole = findViewById(R.id.swchTS);
        sUpdateRole.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    teacher = false;
                }else{
                    teacher = true;
                }
            }
        });
    }

    public void updateName(View view){
        EditText editText = (EditText) findViewById(R.id.edtTxtPersonNameChange);
        String inputNameUpdate = editText.getText().toString();
        TextView textViewName = findViewById(R.id.tvName);
        textViewName.setText(inputNameUpdate);

    }

    public void updateRole(View view){
        TextView textViewRole = findViewById(R.id.tvRole);
        if(teacher){
            textViewRole.setText("Is a teacher.");
        }else{
            textViewRole.setText("Is a student");
        }


    }
}