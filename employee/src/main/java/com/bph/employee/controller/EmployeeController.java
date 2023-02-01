package com.bph.employee.controller;

import com.bph.commons.pojo.Employee;
import com.bph.commons.vo.ResultVo;
import com.bph.employee.service.EmployeeService;
import com.bph.employee.service.MailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private MailService mailService;
    @PostMapping("/login")
    public ResultVo login(Employee employee){
        System.out.println(employee.getEmployeeMail());
        System.out.println(employee.getEmployeePwd());
        return employeeService.login(employee);
    }

    @PostMapping("/mail")
    public ResultVo sendMail(Employee employee){
        String employeeMail = employee.getEmployeeMail();
        return mailService.sendMail(employeeMail);
    }
}
