package org.bvrit.bvritschedule;

public class classProfile {

    private String scheduleUrl;
    private String incharge;
    private String inchargeNumber;
    private String inchargeEmail;
    private String cr1;
    private String cr2;
    private String cr1Number;
    private String cr1Email;
    private String cr2Number;
    private String cr2Email;

    public classProfile(){

    }

    public classProfile(String scheduleUrl, String incharge, String inchargeNumber, String inchargeEmail, String cr1, String cr2, String cr1Number, String cr1Email, String cr2Number, String cr2Email) {
        this.scheduleUrl = scheduleUrl;
        this.incharge = incharge;
        this.inchargeNumber = inchargeNumber;
        this.inchargeEmail = inchargeEmail;
        this.cr1 = cr1;
        this.cr2 = cr2;
        this.cr1Number = cr1Number;
        this.cr1Email = cr1Email;
        this.cr2Number = cr2Number;
        this.cr2Email = cr2Email;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public String getInchargeNumber() {
        return inchargeNumber;
    }

    public void setInchargeNumber(String inchargeNumber) {
        this.inchargeNumber = inchargeNumber;
    }

    public String getInchargeEmail() {
        return inchargeEmail;
    }

    public void setInchargeEmail(String inchargeEmail) {
        this.inchargeEmail = inchargeEmail;
    }

    public String getCr1() {
        return cr1;
    }

    public void setCr1(String cr1) {
        this.cr1 = cr1;
    }

    public String getCr2() {
        return cr2;
    }

    public void setCr2(String cr2) {
        this.cr2 = cr2;
    }

    public String getCr1Number() {
        return cr1Number;
    }

    public void setCr1Number(String cr1Number) {
        this.cr1Number = cr1Number;
    }

    public String getCr1Email() {
        return cr1Email;
    }

    public void setCr1Email(String cr1Email) {
        this.cr1Email = cr1Email;
    }

    public String getCr2Number() {
        return cr2Number;
    }

    public void setCr2Number(String cr2Number) {
        this.cr2Number = cr2Number;
    }

    public String getCr2Email() {
        return cr2Email;
    }

    public void setCr2Email(String cr2Email) {
        this.cr2Email = cr2Email;
    }
}
