package com.example.crudsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/**
 * Custom ArrayAdapter to display Student entity cards inside a ListView.
 */
public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> students) {
        super(context, 0, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }

        Student student = getItem(position);
        if (student != null) {
            TextView tvBadgeId = convertView.findViewById(R.id.tvBadgeId);
            TextView tvItemName = convertView.findViewById(R.id.tvItemName);
            TextView tvItemEmail = convertView.findViewById(R.id.tvItemEmail);
            TextView tvItemCourse = convertView.findViewById(R.id.tvItemCourse);

            tvBadgeId.setText("#" + student.getId());
            tvItemName.setText(student.getName());
            tvItemEmail.setText(student.getEmail());
            tvItemCourse.setText(student.getCourse());
        }

        return convertView;
    }
}
