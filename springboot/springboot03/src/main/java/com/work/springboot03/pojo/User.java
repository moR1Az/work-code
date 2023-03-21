package com.work.springboot03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uId;

    private String uName;

    private String uPassword;

    private Integer uAge;

    private Date uBirthday;

    private Integer rId;

    private Role role;
}