// public class ClassroomController {
//     private final DeviceRegistry reg;

//     public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

//     public void startClass() {
//         SmartClassroomDevice pj = reg.getFirstOfType("Projector");
//         pj.powerOn();
//         pj.connectInput("HDMI-1");

//         SmartClassroomDevice lights = reg.getFirstOfType("LightsPanel");
//         lights.setBrightness(60);

//         SmartClassroomDevice ac = reg.getFirstOfType("AirConditioner");
//         ac.setTemperatureC(24);

//         SmartClassroomDevice scan = reg.getFirstOfType("AttendanceScanner");
//         System.out.println("Attendance scanned: present=" + scan.scanAttendance());
//     }

//     public void endClass() {
//         System.out.println("Shutdown sequence:");
//         reg.getFirstOfType("Projector").powerOff();
//         reg.getFirstOfType("LightsPanel").powerOff();
//         reg.getFirstOfType("AirConditioner").powerOff();
//     }
// }

public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        PowerControl pjPower = reg.get(Projector.class);
        InputConnectable pjInput = reg.get(InputConnectable.class);
        pjPower.powerOn();
        pjInput.connectInput("HDMI-1");

        BrightnessControl lights = reg.get(BrightnessControl.class);
        lights.setBrightness(60);

        TemperatureControl ac = reg.get(TemperatureControl.class);
        ac.setTemperatureC(24);

        AttendanceCapable scan = reg.get(AttendanceCapable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.get(Projector.class).powerOff();
        reg.get(LightsPanel.class).powerOff();
        reg.get(AirConditioner.class).powerOff();
    }
}
