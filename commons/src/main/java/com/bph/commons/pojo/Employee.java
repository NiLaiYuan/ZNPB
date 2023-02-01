package com.bph.commons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeSex;
    private String employeeMail;
    private String employeePwd;
    private String employeeTitle;
    private String storeId;
}
