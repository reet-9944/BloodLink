package com.bloodlink.model;

public class BloodRequest {
    private int requestId;
    private String patientName;
    private String bloodGroup;
    private int unitsNeeded;
    private String city;
    private String emergencyLevel;
    private String status;

    public BloodRequest() {}

    public BloodRequest(int requestId, String patientName, String bloodGroup, int unitsNeeded, String city, String emergencyLevel, String status) {
        this.requestId = requestId;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.unitsNeeded = unitsNeeded;
        this.city = city;
        this.emergencyLevel = emergencyLevel;
        this.status = status;
    }

    public int getRequestId() { return requestId; }
    public String getPatientName() { return patientName; }
    public String getBloodGroup() { return bloodGroup; }
    public int getUnitsNeeded() { return unitsNeeded; }
    public String getCity() { return city; }
    public String getEmergencyLevel() { return emergencyLevel; }
    public String getStatus() { return status; }
}
