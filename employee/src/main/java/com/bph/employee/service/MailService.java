package com.bph.employee.service;

import com.bph.commons.vo.ResultVo;

public interface MailService {
    public ResultVo sendMail(String employeeEmail);
}
