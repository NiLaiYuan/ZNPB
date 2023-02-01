package com.bph.employee.service.Impl;

import com.bph.commons.utils.VerificationCode;
import com.bph.commons.vo.ResultVo;
import com.bph.employee.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String mailUsername;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private TemplateEngine templateEngine;

    public ResultVo sendMail(String employeeEmail) {
        //创建邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = null;
        //生成验证码
        String verificationcode = VerificationCode.getLetter();
        try {
            message = new MimeMessageHelper(mimeMessage, true);
            //设置主题
            message.setSubject("欢迎来到智能排班系统 - 帐号验证");
            //设置发送者
            message.setFrom(mailUsername);
            //设置接收者
            message.setTo(employeeEmail);
            //设置发送日期
            message.setSentDate(new Date());
            //创建上下文环境
            Context context = new Context();
            //生成验证码
            context.setVariable("verificationcode", verificationcode);
            //设置正文
            String text= templateEngine.process("verify-account.html", context);
            message.setText(text, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //邮件发送
        javaMailSender.send(mimeMessage);

        if(verificationcode == null){
            return ResultVo.getFailVo("error", "邮件发送失败");
        }
        else {
            return ResultVo.getSuccessVo("邮件发送成功", verificationcode);
        }
    }
}
