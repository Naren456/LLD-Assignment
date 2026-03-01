public class AirConditioner implements PowerControl, TemperatureControl , SmartClassroomDevice {

    public void powerOn() { }
    public void powerOff() { System.out.println("AC OFF"); }

    public void setTemperatureC(int c) {
        System.out.println("AC set to " + c + "C");
    }
}