public class Main {
    public static void main(String[] args) {
        Pen clickPen = PenFactory.getPen("gel", "blue", "click");
        clickPen.start();
        clickPen.write("Writing with a factory-created click pen.");
        clickPen.close();
    }
}
