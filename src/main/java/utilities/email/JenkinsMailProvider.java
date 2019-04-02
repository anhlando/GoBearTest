package utilities.email;

import utilities.Helper;
import utilities.Log;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JenkinsMailProvider implements IEmailProvider {

    private Properties emailServerProperties;
    private Session emailSession;
    private MimeMessage emailMessage;

    public JenkinsMailProvider(){
        //setup Jenkins mail server
        emailServerProperties = System.getProperties();

        emailServerProperties.put("mail.smtp.host", Helper.getSetting("jenkins.mail.smtp.host")); //
        emailServerProperties.put("mail.smtp.port", Helper.getSetting("jenkins.mail.smtp.port"));
        emailServerProperties.put("mail.smtp.auth", Helper.getSetting("jenkins.mail.smtp.auth"));
        Log.info("JENKINS Mail Server Properties have been setup successfully..");

    }

    @Override
    public void sendMail(String subject, String body, String mailto) {

    }
}
