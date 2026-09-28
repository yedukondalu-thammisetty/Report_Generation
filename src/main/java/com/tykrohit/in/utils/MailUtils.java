package com.tykrohit.in.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class MailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public boolean sendMail(String subject,String body,String mail,File file) {
		try {
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(mail);
			helper.addAttachment("Plans-Info", file );
			
			mailSender.send(mimeMessage);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	

}
