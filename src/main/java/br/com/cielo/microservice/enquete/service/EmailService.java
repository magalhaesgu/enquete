package br.com.cielo.microservice.enquete.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired 
	private static JavaMailSender mailSender;
	
	public static String sendMail(String sendTo) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper( mail );
			helper.setTo("poc.enquete.cielo@gmail.com");
			helper.setSubject( "Teste Envio de e-mail" );
			helper.setText("<p>Hello from Spring Boot Application</p>", true);
			mailSender.send(mail);
			
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			return "Erro ao enviar email.";
		}
	}	

}
