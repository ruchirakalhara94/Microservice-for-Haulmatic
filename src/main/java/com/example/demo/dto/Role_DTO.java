package com.example.demo.dto;

public class Role_DTO {
    private String firstName;
    private String lastName;
    private String nic;

    public Role_DTO(String firstName, String lastName, String nic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
    }

    public Role_DTO() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNic() {
        return nic;
    }
}
