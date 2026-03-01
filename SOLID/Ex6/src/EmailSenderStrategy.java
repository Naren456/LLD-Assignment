public class EmailSenderStrategy implements SenderStrategy{
    @Override
    public void deliver(Notification n, AuditLog audit) {
        String body = n.body;
        if (body.length() > 40) body = body.substring(0, 40);
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}
