package ua.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ua.springboot.web.mail.Mail;

@Service
public class EmaiServiceImpl {

	@Autowired private JavaMailSender javaMailSender;
	
	public void sendMessage(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());
		
		javaMailSender.send(message);
	}
	
}
