package com.example.vinay.automation;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewUserRailway extends AppCompatActivity {

    private Toolbar toolbar;
    public EditText email,password,fullname,rollno,age,gender,contact,address,source,destination;
    public String semail,spassword,sname,srollno,sage,sgender,scontact,saddress,ssource,sdestination,ssemester,syear,sclass;
    private TextInputLayout temail,tpassword,tname, troll, tuserage,tsex,tcontactno,tadd,tsrc,tdestn;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_railway);

        Spinner yearSpinner = (Spinner) findViewById(R.id.yearSpinner);
        Spinner semSpinner = (Spinner) findViewById(R.id.semSpinner);
        Spinner classSpinner = (Spinner) findViewById(R.id.classSpinner);
        btnSignUp = (Button)findViewById(R.id.btn_signup);

        /*ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(NewUserRailway.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        ArrayAdapter<String> semAdapter = new ArrayAdapter<String>(NewUserRailway.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.semester));
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semSpinner.setAdapter(semAdapter);

        ArrayAdapter<String> classAdapter = new ArrayAdapter<String>(NewUserRailway.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.travelClass));
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);*/

        final String[] semester = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};

        ArrayAdapter<String> semAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, semester);

        semSpinner.setAdapter(semAdapter);

        semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ssemester = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                btnSignUp.setEnabled(false);
                Toast.makeText(NewUserRailway.this, "Select Semester", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        final String[] year = new String[]{"1", "2", "3", "4"};

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year);

        yearSpinner.setAdapter(yearAdapter);

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                syear = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                btnSignUp.setEnabled(false);
                Toast.makeText(NewUserRailway.this, "Select Year", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        final String[] travelClass = new String[]{"I", "II"};

        ArrayAdapter<String> classAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, travelClass);

        classSpinner.setAdapter(classAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sclass = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                btnSignUp.setEnabled(false);
                Toast.makeText(NewUserRailway.this, "Select Travelling Class", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        temail = (TextInputLayout)findViewById(R.id.mail);
        tpassword = (TextInputLayout)findViewById(R.id.pass);
        tname = (TextInputLayout) findViewById(R.id.name);
        troll = (TextInputLayout) findViewById(R.id.roll);
        tuserage = (TextInputLayout) findViewById(R.id.userage);
        tsex = (TextInputLayout) findViewById(R.id.sex);
        tcontactno = (TextInputLayout) findViewById(R.id.contactno);
        tadd = (TextInputLayout) findViewById(R.id.add);
        tsrc = (TextInputLayout) findViewById(R.id.src);
        tdestn = (TextInputLayout) findViewById(R.id.destn);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        fullname = (EditText)findViewById(R.id.fullname);
        rollno = (EditText)findViewById(R.id.rollno);
        age = (EditText)findViewById(R.id.age);
        gender = (EditText)findViewById(R.id.gender);
        contact = (EditText)findViewById(R.id.contact);
        address = (EditText)findViewById(R.id.address);
        source = (EditText)findViewById(R.id.source);
        destination = (EditText)findViewById(R.id.destination);

    }

    public void signupClicked(View view){

        if (email.getText().toString().isEmpty()) {
            temail.setError("Enter your Email ID!");
            email.requestFocus();
            return;
        }
        else if (password.getText().toString().isEmpty()) {
            tpassword.setError("Enter Password!");
            password.requestFocus();
            return;
        }
        else if (fullname.getText().toString().isEmpty()) {
            tname.setError("Enter your name!");
            fullname.requestFocus();
            return;
        }
        else if (rollno.getText().toString().isEmpty()) {
            troll.setError("Enter your roll no!");
            rollno.requestFocus();
            return;
        }
        else if (age.getText().toString().isEmpty()) {
            tuserage.setError("Enter your age!");
            age.requestFocus();
            return;
        }
        else if (gender.getText().toString().isEmpty()) {
            tsex.setError("Enter your gender!");
            gender.requestFocus();
            return;
        }
        else if (contact.getText().toString().isEmpty()) {
            tcontactno.setError("Enter your contact no!");
            contact.requestFocus();
            return;
        }
        else if (address.getText().toString().isEmpty()) {
            tadd.setError("Enter your address!");
            address.requestFocus();
            return;
        }
        else if (source.getText().toString().isEmpty()) {
            tsrc.setError("Enter source!");
            source.requestFocus();
            return;
        }
        else if (destination.getText().toString().isEmpty()) {
            tdestn.setError("Enter destination!");
            destination.requestFocus();
            return;
        }

        semail = email.getText().toString();
        spassword = password.getText().toString();
        sname = fullname.getText().toString();
        srollno = rollno.getText().toString();
        sage = age.getText().toString();
        sgender = gender.getText().toString();
        scontact = contact.getText().toString();
        saddress = address.getText().toString();
        ssource = source.getText().toString();
        sdestination = destination.getText().toString();

        String type = "new_user";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,sname,srollno,sage,sgender,scontact,saddress,ssource,sdestination,syear,ssemester,sclass,semail,spassword);
    }

}
