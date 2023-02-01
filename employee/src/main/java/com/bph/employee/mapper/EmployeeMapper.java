package com.bph.employee.mapper;

import com.bph.commons.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee login (Employee employee);
}
