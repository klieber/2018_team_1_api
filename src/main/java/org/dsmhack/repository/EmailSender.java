package org.dsmhack.repository;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class EmailSender {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    private String TEMPLATE_ID = "b4ca0502-1ba9-450e-be9a-cec75fd0a302";

    public void sendTo(String emailAddress, String loginToken) {
        Email from = new Email("from@dsmhack.org");
        Email to = new Email(emailAddress);
        Content content = new Content("text/html", "hello");
        Mail mail = new Mail(from, "subject", to, content);
        mail.setTemplateId(TEMPLATE_ID);
        mail.personalization.get(0).addSubstitution(":loginToken:", loginToken);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}