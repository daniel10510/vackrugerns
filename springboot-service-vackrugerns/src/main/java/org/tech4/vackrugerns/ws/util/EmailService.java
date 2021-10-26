package org.tech4.vackrugerns.ws.util;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tech4.vackrugerns.ws.model.Mail;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.sun.mail.util.MailConnectException;

@Service
public class EmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;
    
    public Mail prepMailWithBody(String fromEmail, String toEmail, String subjectEmail, Map<String, Object> parametros) {
    	Mail mail = new Mail();
		mail.setFrom(fromEmail);
		mail.setTo(toEmail);
		mail.setSubject(subjectEmail);
		if (parametros.size() > 0){
			mail.setModel(parametros);
		}
		return mail;
    }
    
    @Async("threadPoolExecutor")
    public String sendEmailCodVerif(Mail mail) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariable("logo", "logo");
            context.setVariable("logoDown", "logoDown");
            context.setVariables(mail.getModel());
            
            String html = templateEngine.process("email/email-template-credentials", context);

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());
            helper.addInline("logo", new ClassPathResource("templates/email/images/logokruhead.png"), "image/png");
            helper.addInline("logoDown", new ClassPathResource("templates/email/images/rounder-dwn.png"), "image/png");
            emailSender.send(message);
            
            return "000";
		} catch (Exception e){
        	logger.error(e.getMessage());
        	if (e.getCause() instanceof MailConnectException) {
        		return  "100";
        	} else{
        		return "500";
        	}
		}
    }
    
}