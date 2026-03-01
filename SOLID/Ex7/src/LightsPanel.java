public class LightsPanel implements PowerControl, BrightnessControl,SmartClassroomDevice {

    public void powerOn() { /* always on */ }
    public void powerOff() { System.out.println("Lights OFF"); }

    public void setBrightness(int pct) {
        System.out.println("Lights set to " + pct + "%");
    }
}