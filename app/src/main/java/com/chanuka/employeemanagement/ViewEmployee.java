package com.chanuka.employeemanagement;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chanuka.employeemanagement.adapters.EmployeeAdapter;
import com.chanuka.employeemanagement.module.Employee;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewEmployee {

    private List<Employee> employeeList;
    private RecyclerView recyclerView;

    private Context context;

    private EmployeeAdapter adapter;
    private DatabaseReference databaseReference;

    public ViewEmployee(RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
    }


    public void viewEmployeeList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        employeeList =new ArrayList<>();
        adapter= new EmployeeAdapter(employeeList,context);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("employees");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot wallpaperSnapshot:dataSnapshot.getChildren()){

                        Employee employee = wallpaperSnapshot.getValue(Employee.class);

                        employeeList.add(employee);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
