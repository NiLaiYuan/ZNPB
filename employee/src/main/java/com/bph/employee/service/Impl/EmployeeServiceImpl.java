package com.bph.employee.service.Impl;

import com.bph.commons.pojo.Employee;
import com.bph.commons.vo.ResultVo;
import com.bph.employee.mapper.EmployeeMapper;
import com.bph.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;
    @Override
    public ResultVo login(Employee employee){

        Employee employee1 = employeeMapper.login(employee);
        if(employee1 != null){
            return ResultVo.getSuccessVo("登录成功","employee1");
        }
        else {
            return ResultVo.getFailVo("error","密码错误");
        }
    }
}
