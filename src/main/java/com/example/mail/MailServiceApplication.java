package com.example.mail;

import com.example.mail.pojo.Mail;
import com.example.mail.service.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MailServiceApplication {

	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.setMailFrom("kc.mukherjee130@gmail.com");
		mail.setMailTo("rivu10@gmail.com");
		mail.setMailSubject("Spring Boot - Email Example");
		mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks,\nSoumya Mukherjee");

		ApplicationContext ctx = SpringApplication.run(MailServiceApplication.class, args);
		MailService mailService = (MailService) ctx.getBean("mailservice");
		mailService.sendEmail(mail);
	}

}
