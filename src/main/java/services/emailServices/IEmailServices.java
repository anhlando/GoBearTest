package services.emailServices;

public interface IEmailServices {
    public void sendMail(String subject, String content, String mailto);
}
