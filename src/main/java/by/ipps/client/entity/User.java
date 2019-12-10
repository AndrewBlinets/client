package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {

    private String login;
    private String hashPassword;
    private Date dateLastChangePassword;
    private String name;
    private String surName;
    private String patronicName;
    private List<Role> role;
    private String position;
    private String email;
    private Department department;
    private boolean block;

}
