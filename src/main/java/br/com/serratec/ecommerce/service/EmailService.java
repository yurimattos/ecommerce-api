package br.com.serratec.ecommerce.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;
	
	@Value("${mail.from}")
    private String mailFrom;

    @Value("${spring.mail.host}")
    private String emailServerHost;

    @Value("${spring.mail.port}")
    private Integer emailServerPort;

    @Value("${spring.mail.username}")
    private String emailServerUserName;

    @Value("${spring.mail.password}")
    private String emailServerPassword;
	
	public JavaMailSender javaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties prop = new Properties();

        mailSender.setHost(emailServerHost);
        mailSender.setPort(emailServerPort);
        mailSender.setUsername(emailServerUserName);
        mailSender.setPassword(emailServerPassword);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        mailSender.setJavaMailProperties(prop);

        return mailSender;
    }
	
	public void sendMail(String para, String assunto, String conteudo) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        helper.setFrom("grupoumserratec@yahoo.com");
        helper.setTo(para);
        helper.setSubject(assunto);
        helper.setText(conteudo, true);
        emailSender.send(message);
    }
}

