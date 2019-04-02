package services.emailServices;

import utilities.Helper;
import utilities.Log;
import utilities.email.GmailProvider;
import utilities.email.IEmailProvider;
import utilities.email.JenkinsMailProvider;

public class EmailServices implements IEmailServices {

    private IEmailProvider emailProvider;

    public EmailServices(){
        switch (Helper.getSetting("email.provider").trim().toLowerCase()) {
            case "jenkins":
                this.emailProvider = new JenkinsMailProvider();
                break;
            case "gmail":
                this.emailProvider = new GmailProvider();
                break;
            default:
                this.emailProvider = null;
                break;

        }
    }

    @Override
    public void sendMail(String subject, String content, String mailto) {
        try {
            if (this.emailProvider != null) {
                this.emailProvider.sendMail(subject, content, mailto);
            }
            else {
                throw new Exception("Cannot instantiate EmailProvider, please check the setting of Email provider!!!");
            }
        } catch (Exception e) {
            Log.info("Cannot send email!!! Exception catched: " + e.getMessage());
        }
    }

}
