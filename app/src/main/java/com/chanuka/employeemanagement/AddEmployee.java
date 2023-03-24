package com.chanuka.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.chanuka.employeemanagement.module.Employee;

import java.util.Calendar;

public class AddEmployee extends AppCompatActivity implements View.OnClickListener {
    private Button registerBtn;
    public static EditText nameEditText,emailEditTex,phoneEditText,birthdayEditText;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        nameEditText = findViewById(R.id.employeeNameEditText);
        emailEditTex = findViewById(R.id.employeeEmailEditText);
        phoneEditText = findViewById(R.id.employeePhoneEditText);
        birthdayEditText = findViewById(R.id.employeeDateOfBirthEditText);

        final Calendar calendar =Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        birthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(AddEmployee.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        selectedDate =day+"/"+month+"/"+year;
                        birthdayEditText.setText(selectedDate);
                    }
                },year,month,day);
                dialog.show();
            }
        });

        registerBtn = findViewById(R.id.addEmployeeBtn);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addEmployeeBtn:
                addEmployee();
                break;
        }
    }

    private void addEmployee() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditTex.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String birthday = birthdayEditText.getText().toString().trim();

        ValidateEmployeeDetails validateEmployeeDetails = new ValidateEmployeeDetails(name,email,phone,birthday);
        if(validateEmployeeDetails.validate() == true){
            Employee employee = new Employee(name,email,phone,birthday);
            AddEmployeeToDB addEmployeeToDB = new AddEmployeeToDB(employee, getApplicationContext());
            addEmployeeToDB.addEmployeeToDB();
            startActivity(new Intent(AddEmployee.this,MainActivity.class));
            finish();
        }

    }
}