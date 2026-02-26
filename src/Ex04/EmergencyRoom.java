package Ex04;

import java.util.LinkedList;

public class EmergencyRoom {
    private LinkedList<String> waiting_list;

    public EmergencyRoom() {
        waiting_list = new LinkedList<>();
    }

    public void patientCheckIn(String name) {
        waiting_list.addLast(name);
        System.out.println("Da check in (benh nhan thuong): " + name);
    }

    public void emergencyCheckIn(String name) {
        waiting_list.addFirst(name);
        System.out.println("Da check in (benh nhan cap cuu): " + name);
    }

    public void treatPatient() {
        if (waiting_list.isEmpty()) {
            System.out.println("Khong con benh nhan nao");
            return;
        }

        String patient = waiting_list.removeFirst();

        if (patient.equals("C")) {
            System.out.println("Dang cap cuu: " + patient);
        }else {
            System.out.println("Dang kham: " + patient);
        }
    }

    public static void main(String[] args) {
        EmergencyRoom emergencyRoom = new EmergencyRoom();

        emergencyRoom.patientCheckIn("A");
        emergencyRoom.patientCheckIn("B");
        emergencyRoom.emergencyCheckIn("C");

        emergencyRoom.treatPatient();
        emergencyRoom.treatPatient();
        emergencyRoom.treatPatient();

    }
}
