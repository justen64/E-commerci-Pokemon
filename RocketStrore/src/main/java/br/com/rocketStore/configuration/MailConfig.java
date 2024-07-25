package br.com.rocketStore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender mail;

	public void sendMail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("samuel.dornellas@aluno.senai.br");// vou deixar o meu por enquanto ou vai ficar asssim para sempre
		message.setTo(para);
		message.setSubject(assunto);
		message.setText(texto);
		mail.send(message);
	}
}
