public interface SenderStrategy {
    void deliver(Notification n,AuditLog audit);
}
