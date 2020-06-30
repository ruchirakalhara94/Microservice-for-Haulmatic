package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="role")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Role {
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The auto generated id for the role table. This will be the primary key of the ROLE table")
    private int id;

    @Column(unique = true)
    @ApiModelProperty(notes = "The NIC of the role")
    private String nic;

    @ApiModelProperty(notes = "The organization of the role")
    private String organizatoin;

    @ApiModelProperty(notes = "The First name of the role")
    private String firstName;

    @ApiModelProperty(notes = "The Last name of the role")
    private String lastName;

    @ApiModelProperty(notes = "The type of the role")
    private String role_type;

    @ApiModelProperty(notes = "The date of creatation of the data")
    private Date created_date;

    @ApiModelProperty(notes = "The date of last modification of the data")
    private Date last_modified_date;

    public void setId(int id) {
        this.id = id;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setOrganizatoin(String organizatoin) {
        this.organizatoin = organizatoin;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public int getId() {
        return id;
    }

    public String getNic() {
        return nic;
    }

    public String getOrganizatoin() {
        return organizatoin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole_type() {
        return role_type;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }
}
