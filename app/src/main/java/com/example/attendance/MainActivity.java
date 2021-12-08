package com.example.attendance;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.attendance.fragments.AttendanceFragment;
import com.example.attendance.fragments.StudentFragment;
import com.example.attendance.models.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentList = new ArrayList<>();
        loadStudents();
        fragment = new AttendanceFragment();
        Button btnPresence = findViewById(R.id.btnAttendance);

        btnPresence.setOnClickListener(view -> onTopNavSelected(btnPresence));
        Button btnStudents = findViewById(R.id.btnStudents);
        btnStudents.setOnClickListener(view -> onTopNavSelected(btnStudents));

        onTopNavSelected(btnPresence);
    }

    @SuppressLint("NonConstantResourceId")
    public void onTopNavSelected(View item) {
        switch (item.getId()) {
            case R.id.btnAttendance:
                fragment = new AttendanceFragment(studentList);
                break;
            case R.id.btnStudents:
                fragment = new StudentFragment(studentList);
                break;
            default:
                return;
        }
        if (fragment.isAdded()) {
            return;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frmContainer, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
    }

    public void loadStudents () {
        Student student = new Student();
        student.regNumber = "219000001";
        student.firstName = "Mia";
        student.lastName = "Benitha";
        student.status = false;
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
    }
}