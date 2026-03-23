
public class Click implements OpenCloseStrategy {
    public void open(){
        System.out.println("Pen clicked, ready to write");
    }
    public void close(){
        System.out.println("Pen clicked, closed");
    }
}
