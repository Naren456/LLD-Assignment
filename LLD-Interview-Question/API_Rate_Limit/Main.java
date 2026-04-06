import org.example.resource.Resource;
import org.example.resource.RemoteResource;
import org.example.proxy.RemoteResourceProxy;
import org.example.strategy.RateLimitingStrategy;
import org.example.strategy.SlidingWindowStrategy;

public class Main {
    public static void main(String[] args) {
        Resource resource = new RemoteResource();
        RateLimitingStrategy strategy = new SlidingWindowStrategy(3, 4);
        RemoteResourceProxy proxy = new RemoteResourceProxy(strategy, resource);

        for (int i = 0; i < 10; i++) {
            try {
                proxy.getResponse();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
