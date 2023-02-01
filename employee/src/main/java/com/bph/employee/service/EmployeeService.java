package com.bph.employee.service;

import com.bph.commons.pojo.Employee;
import com.bph.commons.vo.ResultVo;

public interface EmployeeService {
    public ResultVo login(Employee employee);
}
