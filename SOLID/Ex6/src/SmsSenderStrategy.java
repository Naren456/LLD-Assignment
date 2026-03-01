public class SmsSenderStrategy implements SenderStrategy{
    @Override
    public void deliver(Notification n, AuditLog audit) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
