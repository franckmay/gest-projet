package com.example.android.employeesmanagementsoftware.TaskCreation;


import android.app.Activity;


import com.example.android.employeesmanagementsoftware.data.DBHelpers.EmployeesManagementDbHelper;
import com.example.android.employeesmanagementsoftware.taskDB.Task;
import com.google.android.material.textfield.TextInputLayout;

class TaskCreationUtil {

    public static final int NEW_TASK_ID = -1;
    private Activity activity;
    private EmployeesManagementDbHelper employeeDBHelper;
    private static final String TAG="util";
    TaskCreationUtil(Activity activity, EmployeesManagementDbHelper employeeDBHelper) {
        this.activity = activity;

        this.employeeDBHelper = employeeDBHelper;
    }

    //return a suitable TaskCreationCommandObject based on the task's id
    TaskCreationCommand getCommander(long task_id,Task task) {

        return task_id == NEW_TASK_ID ? new NewCommand(employeeDBHelper) : new EditCommand(activity, employeeDBHelper, task_id,task);

    }

    boolean isEmpty(TextInputLayout nameLayout, TextInputLayout descpLayout, TextInputLayout deadlineLayout) {
        boolean flag=false;
        if (nameLayout.getEditText().getText().toString().isEmpty()){
            flag=true;
            nameLayout.setError("Entrer le nom");
        }
        if (descpLayout.getEditText().getText().toString().isEmpty()){
            flag=true;
            descpLayout.setError("Entrer une description");

        }
        if (deadlineLayout.getEditText().getText().toString().isEmpty()){
            flag=true;
            deadlineLayout.setError("Entrer la deadline");
        }

        return flag;
    }
}
