package com.example.vinay.automation;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ExistingUserRailway extends AppCompatActivity {

    public TextInputLayout etroll;
    public EditText erollno;
    public String esroll,esyear,essemester,esclass;
    Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user_railway);

        btnSignin = (Button)findViewById(R.id.btn_signin);

        Spinner eyearSpinner = (Spinner) findViewById(R.id.eyearSpinner);
        Spinner esemSpinner = (Spinner) findViewById(R.id.esemSpinner);
        Spinner eclassSpinner = (Spinner) findViewById(R.id.eclassSpinner);

        final String[] esemester = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};

        ArrayAdapter<String> esemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, esemester);

        esemSpinner.setAdapter(esemAdapter);

        esemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                essemester = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                Toast.makeText(ExistingUserRailway.this, "Select Semester", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        final String[] eyear = new String[]{"1", "2", "3", "4"};

        ArrayAdapter<String> eyearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eyear);

        eyearSpinner.setAdapter(eyearAdapter);

        eyearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                esyear = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                Toast.makeText(ExistingUserRailway.this, "Select Year", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        final String[] etravelClass = new String[]{"I", "II"};

        ArrayAdapter<String> eclassAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, etravelClass);

        eclassSpinner.setAdapter(eclassAdapter);

        eclassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                esclass = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                btnSignin.setEnabled(false);
                Toast.makeText(ExistingUserRailway.this, "Select Travelling Class", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        etroll = (TextInputLayout) findViewById(R.id.eroll);
        erollno = (EditText)findViewById(R.id.erollno);

    }

    public void signinClicked(View view){
        if (erollno.getText().toString().isEmpty()) {
            etroll.setError("Enter your roll no!");
            erollno.requestFocus();
            return;
        }
        esroll = erollno.getText().toString();
        String type = "existing_user";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,esroll,essemester,esyear,esclass);
    }
}
