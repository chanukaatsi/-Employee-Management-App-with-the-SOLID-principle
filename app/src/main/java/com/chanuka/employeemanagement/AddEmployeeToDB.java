package com.chanuka.employeemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.chanuka.employeemanagement.module.Employee;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class AddEmployeeToDB {
    private Employee employee;
    private Context context;

    public AddEmployeeToDB(Employee employee, Context applicationContext) {
        this.employee = employee;
        this.context = applicationContext;
    }


    public void addEmployeeToDB() {
        FirebaseDatabase.getInstance().getReference("employees")
                .push()
                .setValue(employee).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task1) {
                        if (task1.isSuccessful()){
                            Toast.makeText( context,"User has been registered successfully!",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(context,"Fail to register! Try again!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
