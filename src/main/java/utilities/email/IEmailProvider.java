package utilities.email;

public interface IEmailProvider {
    public void sendMail(String subject, String body, String mailto);
}
