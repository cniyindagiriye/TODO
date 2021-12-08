package com.example.attendance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.models.Student;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {
    List<Student> students;
    public StudentsAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_students, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtFirstName, txtLastName, txtRegNumber;
        ImageButton btnStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFirstName = itemView.findViewById(R.id.txtFirstName);
            txtLastName = itemView.findViewById(R.id.txtLastName);
            txtRegNumber = itemView.findViewById(R.id.txtRegNumber);
            btnStatus = itemView.findViewById(R.id.btnStatus);
        }
        public void bind(final Student student){
            txtRegNumber.setText(student.regNumber);
            txtFirstName.setText(student.firstName);
            txtLastName.setText(student.lastName);
            if (student.status) {
                btnStatus.setImageResource(R.drawable.ic_yes_small);
            } else {
                btnStatus.setImageResource(R.drawable.ic_no_small);
            }
        }
    }
}
