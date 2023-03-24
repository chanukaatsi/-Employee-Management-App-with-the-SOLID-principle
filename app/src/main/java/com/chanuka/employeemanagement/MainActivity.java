package com.chanuka.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chanuka.employeemanagement.adapters.EmployeeAdapter;
import com.chanuka.employeemanagement.module.Employee;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAddEmployee;
    public static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEmployee = findViewById(R.id.addEmployeeButton);
        recyclerView = findViewById(R.id.employeeListRecyclerView);

        ViewEmployee viewEmployee = new ViewEmployee(recyclerView,getApplicationContext());
        viewEmployee.viewEmployeeList();

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEmployee.class);
                startActivity(intent);
            }
        });
    }
}