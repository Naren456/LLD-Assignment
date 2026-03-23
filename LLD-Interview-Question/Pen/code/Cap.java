
public class Cap implements OpenCloseStrategy {
    public void open(){
        System.out.println("Cap Open , Pen is ready to write");
    }
    public void close(){
        System.out.println("Pen close with Cap");
    }
}
