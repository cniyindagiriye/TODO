package com.example.attendance.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.adapters.StudentsAdapter;
import com.example.attendance.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    List<Student> students;

    public StudentFragment () {
        this.students = new ArrayList<>();
    }

    public StudentFragment(List<Student> students) {
        this.students = students;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        StudentsAdapter attendanceAdapter = new StudentsAdapter(students);
        recyclerView.setAdapter(attendanceAdapter);
        recyclerView.setVerticalScrollBarEnabled(true);
        return view;
    }
}