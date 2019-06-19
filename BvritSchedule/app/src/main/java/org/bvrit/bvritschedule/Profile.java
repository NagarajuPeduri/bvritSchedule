package org.bvrit.bvritschedule;

import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;


public class Profile {
    private String name;
    private String email;
    private String number;
    private String profilePic;
    private String schedulePic;
    private String id;
    private String deptname;
    private String period;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
// private ArrayList<ArrayList> period;
    //private Context context;

    public Profile() {
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Profile(String name, String email, String number, String profilePic, String schedulePic, String id, String deptname, String period) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.profilePic = profilePic;
        this.schedulePic = schedulePic;
        this.id = id;
        this.deptname = deptname;
        this.period = period;
        //this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getSchedulePic() {
        return schedulePic;
    }

    public void setSchedulePic(String schedulePic) {
        this.schedulePic = schedulePic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public ArrayList<ArrayList> getPeriod() {
        return period;
    }

    public void setPeriod(ArrayList<ArrayList> period) {
        this.period = period;
    }*/

}
