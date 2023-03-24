package com.chanuka.employeemanagement.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chanuka.employeemanagement.R;
import com.chanuka.employeemanagement.module.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;
    private Context context;

    public EmployeeAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.employeeName.setText(employee.getName());
        holder.employeeEmail.setText(employee.getEmail());
        holder.employeePhone.setText(employee.getPhone());
        holder.employeeDOB.setText(employee.getBirthday());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public TextView employeeName, employeeEmail, employeePhone, employeeDOB;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employeeItemName);
            employeeEmail = itemView.findViewById(R.id.employeeItemEmail);
            employeePhone = itemView.findViewById(R.id.employeeItemPhone);
            employeeDOB = itemView.findViewById(R.id.employeeItemDOB);
        }
    }

}
