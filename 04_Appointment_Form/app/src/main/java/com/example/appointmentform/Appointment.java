package com.example.appointmentform;

/**
 * Model class representing a booked appointment entity.
 */
public class Appointment {
    private final String patientName;
    private final String serviceType;
    private final String category;
    private final String date;
    private final String time;

    public Appointment(String patientName, String serviceType, String category, String date, String time) {
        this.patientName = patientName;
        this.serviceType = serviceType;
        this.category = category;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return patientName + " - " + serviceType + " (" + category + ") on " + date + " at " + time;
    }
}
