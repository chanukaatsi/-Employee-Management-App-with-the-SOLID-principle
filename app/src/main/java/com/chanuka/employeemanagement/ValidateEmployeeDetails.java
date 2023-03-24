package com.chanuka.employeemanagement;

import android.util.Patterns;

public class ValidateEmployeeDetails extends AddEmployee{
    private String name, email, phone, birthday;

    public ValidateEmployeeDetails() {
    }

    public ValidateEmployeeDetails(String name, String email, String phone, String birthday) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    public boolean validate(){
        if(name.isEmpty()){
            nameEditText.setError("First Name is required");
            nameEditText.requestFocus();
            return false;
        }else if(email.isEmpty()){
            emailEditTex.setError("Email is required");
            emailEditTex.requestFocus();
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditTex.setError("Please provide valid email!");
            emailEditTex.requestFocus();
            return false;
        }else if(phone.isEmpty()){
            phoneEditText.setError("Mobile is required");
            phoneEditText.requestFocus();
            return false;
        }else if(phone.length() < 10){
            phoneEditText.setError("Invalid Mobile Number");
            phoneEditText.requestFocus();
            return false;
        }else if(phone.length() > 12){
            phoneEditText.setError("Invalid Mobile Number");
            phoneEditText.requestFocus();
            return false;
        }else if(birthday.isEmpty()) {
            birthdayEditText.setError("Birthday is required");
            birthdayEditText.requestFocus();
            return false;
        }else {
            return true;
        }
    }


}
