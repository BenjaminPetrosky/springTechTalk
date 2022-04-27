package com.example.techtalkspring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_NAME = "PERSON_NAME";
    public static final String EXTRA_ROLE = "ROLE";
    private boolean teacher = true;
    private SwitchCompat sSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // initiate a Switch
        sSwitch = findViewById(R.id.btnSwitch);
        sSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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


    /** Called when the user taps the Send button */
    public void launchActivity3(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        EditText editText = (EditText) findViewById(R.id.edtTxtPersonName);
        String inputName = editText.getText().toString();
        intent.putExtra(EXTRA_NAME, inputName);
        intent.putExtra(EXTRA_ROLE, teacher);
        startActivity(intent);
    }


}