package com.example.attendance.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.attendance.R;
import com.example.attendance.constants.Init;
import com.example.attendance.models.Student;
import com.example.attendance.adapters.AttendanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {
    List<Student> students;
    CheckBox chkAll;
    AttendanceAdapter attendanceAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public AttendanceFragment() {
        students = new ArrayList<>();
    }

    public AttendanceFragment(List<Student> students) {
        this.students = students;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        attendanceAdapter = new AttendanceAdapter(students);
        recyclerView.setAdapter(attendanceAdapter);
        recyclerView.setVerticalScrollBarEnabled(true);

        chkAll = view.findViewById(R.id.chkAll);
        chkAll.setOnClickListener(v -> handleSelectAll());
        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void handleSelectAll() {
        Init.IS_ALL = chkAll.isChecked();
        attendanceAdapter.setStudents(students);
        attendanceAdapter.notifyDataSetChanged();
    }
}