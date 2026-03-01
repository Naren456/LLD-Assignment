public abstract class NotificationSender {
    protected final AuditLog audit;
    protected final SenderStrategy strategy;
    protected NotificationSender(AuditLog audit,SenderStrategy strategy) {
        this.audit = audit;
        this.strategy = strategy;
    }
    public final void send(Notification n){
        if(n == null){
            throw new IllegalArgumentException("Notification cannot be null");
        }
        strategy.deliver(n,audit);
    }
}
