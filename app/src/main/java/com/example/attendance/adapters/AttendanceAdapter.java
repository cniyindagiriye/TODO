package com.example.attendance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.constants.Init;
import com.example.attendance.models.Student;

import java.util.List;

public class AttendanceAdapter  extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    List<Student> students;
    public AttendanceAdapter(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_attendance, parent, false);
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
        TextView txtRegNumber;
        CheckBox chkAction;
        ImageButton btnStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRegNumber = itemView.findViewById(R.id.txtRegNumber);
            btnStatus = itemView.findViewById(R.id.btnStatus);
            chkAction = itemView.findViewById(R.id.chkAction);
        }
        public void bind(final Student student){
            txtRegNumber.setText(student.regNumber);
            if (student.status || Init.IS_ALL) {
                btnStatus.setImageResource(R.drawable.ic_yes);
                chkAction.setChecked(true);
            } else {
                btnStatus.setImageResource(R.drawable.ic_no);
                chkAction.setChecked(false);
            }

            chkAction.setOnClickListener(view -> {
               if (chkAction.isChecked()) {
                   btnStatus.setImageResource(R.drawable.ic_yes);
               } else if (!chkAction.isChecked() || !Init.IS_ALL) {
                   btnStatus.setImageResource(R.drawable.ic_no);
               }
            });
        }
    }
}
