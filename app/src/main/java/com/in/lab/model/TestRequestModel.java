package com.in.lab.model;

public class TestRequestModel {

    String BookingId,patientName,datOfBooking,labTestName,labTestResult,amount;

    public TestRequestModel(String bookingId, String patientName, String datOfBooking, String labTestName, String labTestResult, String amount) {
        BookingId = bookingId;
        this.patientName = patientName;
        this.datOfBooking = datOfBooking;
        this.labTestName = labTestName;
        this.labTestResult = labTestResult;
        this.amount = amount;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDatOfBooking() {
        return datOfBooking;
    }

    public void setDatOfBooking(String datOfBooking) {
        this.datOfBooking = datOfBooking;
    }

    public String getLabTestName() {
        return labTestName;
    }

    public void setLabTestName(String labTestName) {
        this.labTestName = labTestName;
    }

    public String getLabTestResult() {
        return labTestResult;
    }

    public void setLabTestResult(String labTestResult) {
        this.labTestResult = labTestResult;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
