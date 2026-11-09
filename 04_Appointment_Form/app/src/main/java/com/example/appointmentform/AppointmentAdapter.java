package com.example.appointmentform;

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
 * Custom ArrayAdapter to bind Appointment items to the ListView.
 */
public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    public AppointmentAdapter(@NonNull Context context, @NonNull List<Appointment> appointments) {
        super(context, 0, appointments);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_appointment, parent, false);
        }

        Appointment appointment = getItem(position);
        if (appointment != null) {
            TextView tvPatient = convertView.findViewById(R.id.tvItemPatient);
            TextView tvService = convertView.findViewById(R.id.tvItemService);
            TextView tvCategory = convertView.findViewById(R.id.tvItemCategory);
            TextView tvDateTime = convertView.findViewById(R.id.tvItemDateTime);

            tvPatient.setText(appointment.getPatientName());
            tvService.setText(appointment.getServiceType());
            tvCategory.setText("Department: " + appointment.getCategory());
            tvDateTime.setText("Date: " + appointment.getDate() + " | Time: " + appointment.getTime());
        }

        return convertView;
    }
}
