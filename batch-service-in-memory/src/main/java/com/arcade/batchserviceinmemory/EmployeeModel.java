package com.arcade.batchserviceinmemory;

public class EmployeeModel {
    private String firstname;
    private String place;
    private String team;

    public EmployeeModel() {
        
    }

    public EmployeeModel(String firstname, String place, String team) {
        this.firstname = firstname;
        this.place = place;
        this.team = team;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
