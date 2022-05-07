package com.example.mail.service.impl;

import com.example.mail.pojo.Mail;
import com.example.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("mailservice")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            FileSystemResource fileSystem
                    = new FileSystemResource(new File("./sample.txt"));
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "Soumya Learning"));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent());
            mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
