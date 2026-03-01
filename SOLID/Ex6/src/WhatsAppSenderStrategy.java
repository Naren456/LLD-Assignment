public class WhatsAppSenderStrategy implements SenderStrategy {
    @Override
    public void deliver(Notification n, AuditLog audit) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return;
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
